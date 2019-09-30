package netty_practice;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Chat_NettyServerHandler extends SimpleChannelInboundHandler<String>{

	private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("group size:"+group.size());
		group.forEach(ch ->{
			if(ch==ctx.channel())
			{
				ch.writeAndFlush(ch.remoteAddress()+"自己说："+msg);
			}
			else
			{
				ch.writeAndFlush(ch.remoteAddress()+"说："+msg);
			}
		});
		
//		ctx.channel().close();
	}
	
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		String msg = "server-"+ctx.channel().remoteAddress()+":加入";
		group.writeAndFlush(msg);
		group.add(ctx.channel());
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		String msg = "server-"+ctx.channel().remoteAddress()+":已掉线";
		group.writeAndFlush(msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String msg = "server-"+ctx.channel().remoteAddress()+":已上线";
		System.out.println(msg);
		//group.writeAndFlush(msg);
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		String msg = "server-"+ctx.channel().remoteAddress()+":已离线";
		System.out.println(msg);
		//group.writeAndFlush(msg);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.channel().close();
	}
	
}
