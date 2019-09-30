package netty_practice;

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
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class TTT 
{
	public static void main(String[] args) 
	{
		System.out.println("git测试11111111111111111112221");
//        ServerBootstrap serverBootstrap = new ServerBootstrap();
//        EventLoopGroup boos = new NioEventLoopGroup();
//        EventLoopGroup worker = new NioEventLoopGroup();
//        serverBootstrap
//                .group(boos, worker)
//                .channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<NioSocketChannel>() {
//                    protected void initChannel(NioSocketChannel ch) {
//                    	ch.pipeline().addLast("httpServerCodec", new HttpServerCodec());
//                    	ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpObject>() {
//							@Override
//							protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
//								if(msg instanceof HttpRequest) 
//								{
//									ByteBuf content = Unpooled.copiedBuffer("hello world",CharsetUtil.UTF_8);
//									FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
//									response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=UTF-8");
//									response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
//									ctx.writeAndFlush(response);
//									ctx.channel().close();
//								}
//							}});
//                    }
//                }).bind(33333);
		
		

		ServerBootstrap serverBootstrap = new ServerBootstrap();
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup work = new NioEventLoopGroup();
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
		}).bind(5656);
	}
}
