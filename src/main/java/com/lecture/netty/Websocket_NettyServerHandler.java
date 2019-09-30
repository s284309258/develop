package com.lecture.netty;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Websocket_NettyServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

	private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		
		System.out.println("channelRead0");
		System.out.println(channels.size());
		Channel channel = ctx.channel();
//		for (Channel channel : channels) {
//            if (channel != incoming){
//                channel.writeAndFlush(new TextWebSocketFrame("[" + incoming.remoteAddress() + "]" + msg.text()));
//            } else {
//            	channel.writeAndFlush(new TextWebSocketFrame("[you]" + msg.text() ));
//            }
//        }
		channels.forEach(ch->{
			if (ch != channel){
				ch.writeAndFlush(new TextWebSocketFrame("[" + channel.remoteAddress() + "]" + msg.text()));
			} else {
				ch.writeAndFlush(new TextWebSocketFrame("[you]" + msg.text() ));
			}
		});
	}
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerAdded");
		channels.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress()+" join"));
		channels.add(ctx.channel());
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerRemoved");
		channels.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress()+" down"));
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActive");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelInactive");
	}

}
