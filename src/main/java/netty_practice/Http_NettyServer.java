package netty_practice;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class Http_NettyServer 
{
	public static void main(String[] args) throws Exception
	{
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup work = new NioEventLoopGroup();
		
		try
		{
			ServerBootstrap starp = new ServerBootstrap();
			starp.group(boss, work).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {

				@Override
				protected void initChannel(NioSocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast("httpServerCodec", new HttpServerCodec());
					pipeline.addLast("httpServerHandler", new Http_ServerHandler());
				}
				
			}).bind(2222).sync();
			
			
		}
		finally
		{
			boss.shutdownGracefully();
			work.shutdownGracefully();
		}
	}
}
