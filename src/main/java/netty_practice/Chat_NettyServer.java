package netty_practice;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class Chat_NettyServer 
{
	public static void main(String[] args) throws Exception{
//		EventLoopGroup boss = new NioEventLoopGroup();
//		EventLoopGroup worker = new NioEventLoopGroup();
//		
//		try
//		{
//			ServerBootstrap serverBootstrap = new ServerBootstrap();
//			
//			serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class).childHandler(new Chat_NettyServerIntialize());
//			
//			ChannelFuture future = serverBootstrap.bind(8899).sync();
//			
//			future.channel().closeFuture();
//		}
//		finally
//		{
//			boss.shutdownGracefully();
//			worker.shutdownGracefully();
//		}
		
		
		
		
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worder = new NioEventLoopGroup();
		
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		
		serverBootstrap.group(boss, worder).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<NioSocketChannel>() {

			protected void initChannel(NioSocketChannel ch) throws Exception {
				ChannelPipeline pipeline = ch.pipeline();
				pipeline.addLast(new IdleStateHandler(6, 9, 12,TimeUnit.SECONDS));
				pipeline.addLast(new Chat_NettyHeart());
				pipeline.addLast(new StringDecoder());
				pipeline.addLast(new StringEncoder());
				pipeline.addLast(new Chat_NettyServerHandler());
			}
		}).bind(3333);
		
		
		
		
	}
}
