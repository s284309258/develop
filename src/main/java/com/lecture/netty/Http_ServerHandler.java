package com.lecture.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class Http_ServerHandler extends SimpleChannelInboundHandler<HttpObject>{

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
	}

}
