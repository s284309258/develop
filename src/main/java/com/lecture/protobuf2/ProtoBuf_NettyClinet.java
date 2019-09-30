package com.lecture.protobuf2;

import java.util.Date;

import com.lecture.automatic.proto2.proto_simple;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;

public class ProtoBuf_NettyClinet {
	
	public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                    	ChannelPipeline pipeline = ch.pipeline();
                    	pipeline.addLast(new ProtobufVarint32FrameDecoder());
    					pipeline.addLast(new ProtobufDecoder(proto_simple.simple.getDefaultInstance()));
    					pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
    					pipeline.addLast(new ProtobufEncoder());
    					
    					pipeline.addLast(new ProtoBuf_NettyClinetHandler());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 3636).channel();
        
    }
}
