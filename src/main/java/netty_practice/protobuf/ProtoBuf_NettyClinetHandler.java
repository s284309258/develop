package netty_practice.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protos.proto_simple;
import protos.proto_simple.simple;

public class ProtoBuf_NettyClinetHandler extends SimpleChannelInboundHandler<proto_simple.MySimple>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, proto_simple.MySimple msg) throws Exception {
		System.out.println("from server msg:"+msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		proto_simple.MySimple simple = null;
		
		//proto_simple.simple ss = proto_simple.simple.newBuilder().setAddress("杭州").setName("张三生").setAge(22).build();
//		simple = proto_simple.MySimple.newBuilder().setDataType(proto_simple.MySimple.DataType.simple_no1Type).setS2(
//				proto_simple.simple_no1.newBuilder().setAddress("北京").setName("老张").build()
//				).build();
		
//		simple = proto_simple.MySimple.newBuilder().setDataType(
//				proto_simple.MySimple.DataType.simple_no2Type).setS3(proto_simple.simple_no2.newBuilder().setAddress("郴州").setMyheight("188").setName("老王").build()
//						).build();
//		
		simple = proto_simple.MySimple.newBuilder().setDataType(proto_simple.MySimple.DataType.simpleType).setS1(
				proto_simple.simple.newBuilder().setAddress("深圳").setAge(22).setName("老李").build()
				).build();
		
		ctx.channel().writeAndFlush(simple);
		
	}
}
