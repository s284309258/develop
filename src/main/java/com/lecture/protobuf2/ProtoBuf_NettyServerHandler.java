package com.lecture.protobuf2;

import com.lecture.automatic.proto2.proto_simple;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBuf_NettyServerHandler extends SimpleChannelInboundHandler<proto_simple.MySimple>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, proto_simple.MySimple msg) throws Exception {
		
		proto_simple.MySimple.DataType dataType = msg.getDataType();
		//路由编写
		if(dataType==proto_simple.MySimple.DataType.simpleType) 
		{
			proto_simple.simple s1 = msg.getS1();
			System.out.println("im simpleType");
			System.out.println(s1.getAddress());
			System.out.println(s1.getAge());
			System.out.println(s1.getName());
			
			ctx.channel().writeAndFlush(proto_simple.simple.newBuilder().build());
		}
		else if(dataType==proto_simple.MySimple.DataType.simple_no1Type) 
		{
			System.out.println("im simple_no1Type");
			proto_simple.simple_no1 s2 = msg.getS2();
			System.out.println(s2.getAddress());
			System.out.println(s2.getName());
		}
		else if(dataType==proto_simple.MySimple.DataType.simple_no2Type)
		{
			System.out.println("im simple_no2Type");
			proto_simple.simple_no2 s3 = msg.getS3();
			System.out.println(s3.getAddress());
			System.out.println(s3.getName());
			System.out.println(s3.getMyheight());
			System.out.println(s3.getMytel());
		}
	}
	
}
