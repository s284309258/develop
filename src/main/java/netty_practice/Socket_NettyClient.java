package netty_practice;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class Socket_NettyClient {
	public static void main(String[] args) throws Exception{
		
		EventLoopGroup client = new NioEventLoopGroup();
		
		try
		{
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(client).channel(NioSocketChannel.class).handler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
					pipeline.addLast(new LengthFieldPrepender(4));
					pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
					pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
					
					pipeline.addLast(new Socket_NettyClientHandler());
					
				}
				
			});
			ChannelFuture cf = bootstrap.connect("127.0.0.1", 8899).sync();
			cf.channel().closeFuture().sync();
			
		}
		finally
		{
			client.shutdownGracefully();
		}
	}
}
