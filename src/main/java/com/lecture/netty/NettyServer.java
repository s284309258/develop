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
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class NettyServer 
{
	public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        EventLoopGroup boos = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boos, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                    	System.out.println("ssssssssss");
                    	//ch.pipeline().addLast(new StringEncoder());
                    	//ch.pipeline().addLast(new StringDecoder());
                    	ch.pipeline().addLast("httpServerCodec", new HttpServerCodec());
                    	//ch.pipeline().addLast("httpServerHandler", new HttpServerHandler());
                    	
                    	
                    	ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {

							@Override
							protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
								
								if(msg instanceof HttpRequest) 
								{
									ByteBuf content = Unpooled.copiedBuffer("你好呀呀呀呀呀呀",CharsetUtil.UTF_8);
									
									FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
									
									response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=UTF-8");
									response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
									
									ctx.writeAndFlush(response);
									
									ctx.channel().close();
								}
								
							}});
//                        ch.pipeline().addLast(new StringDecoder());
//                        ch.pipeline().addLast(new StringEncoder());
//                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
//                            
//                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
//                                System.out.println(ctx.newSucceededFuture()+msg);
//                                //ctx.channel().writeAndFlush("zxczxczxc");
//                            }
//                        });
                    }
                })
                .bind(1111);
    }
}
