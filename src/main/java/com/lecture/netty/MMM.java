package com.lecture.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class MMM {
	public static void main(String[] args) throws Exception {
		
		
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup work = new NioEventLoopGroup();
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(boss, work).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
			protected void initChannel(NioSocketChannel ch) {
				ch.pipeline().addLast(new HttpServerCodec());
				ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {
					@Override
					protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
						if(msg instanceof HttpRequest) 
						{
							HttpRequest request = (HttpRequest)msg;
							System.out.println(request.getClass().getName());
							ByteBuf content = Unpooled.copiedBuffer("hello world",CharsetUtil.UTF_8);
							FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
							ctx.writeAndFlush(response);
							ctx.channel().close();
						}
					}
				});
			}
		}).bind(1212);
	}
}
