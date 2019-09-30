package netty_practice;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class Socket_NettyServer {
	
	public static void main(String[] args) throws Exception {
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		try
		{
			serverBootstrap
            .group(boss, worker)
            .channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
				protected void initChannel(NioSocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
					pipeline.addLast(new LengthFieldPrepender(4));
					pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
					pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
					
					
					pipeline.addLast(new SimpleChannelInboundHandler<String>() {
			
						@Override
						protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
							System.out.println(ctx.channel().remoteAddress()+","+msg);
							ctx.channel().writeAndFlush("server access success and notify client");
						}
						
						@Override
						public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
							cause.printStackTrace();
							ctx.close();
						}
						
					});
				}
			});
			
			ChannelFuture cf = serverBootstrap.bind(8899).sync();
			
			cf.channel().closeFuture().sync();
		}
		finally
		{
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
	
}
