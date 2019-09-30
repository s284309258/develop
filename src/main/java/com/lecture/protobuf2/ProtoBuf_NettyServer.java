package com.lecture.protobuf2;

import com.lecture.automatic.proto2.proto_simple;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class ProtoBuf_NettyServer {

	////d:\protobuf\bin>protoc  -I=D:\netty_lecture\src\main\java\ --java_out=D:\netty_lecture\src\main\java\ D:\netty_lecture\src\main\java\com\lecture\protobuf2\simple.proto
	//cmd命令生成跨域跨语言访问的java对象 使用protoc-3.9.0-win64编译器
	//D:\software\protoc-3.9.0-win64\bin>protoc -I=F:\jtim\netty_studio\src\main\java\
	//		 --java_out=F:\jtim\netty_studio\src\main\java\ F:\jtim\netty_studio\src\main\java\netty_studio\simple.proto
	public static void main(String[] args) throws Exception{
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try
		{
			ServerBootstrap server = new ServerBootstrap();
			
			server.group(boss, worker).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<NioSocketChannel>() {

				protected void initChannel(NioSocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					
					pipeline.addLast(new ProtobufVarint32FrameDecoder());
					pipeline.addLast(new ProtobufDecoder(proto_simple.MySimple.getDefaultInstance()));
					pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
					pipeline.addLast(new ProtobufEncoder());
					
					
					pipeline.addLast(new ProtoBuf_NettyServerHandler());
				}
			});
			
			ChannelFuture future = server.bind(3636).sync();
			
			future.channel().closeFuture().sync();
			
		}
		catch(Exception e)
		{
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
		
	}
}
