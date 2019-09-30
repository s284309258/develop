package netty_practice;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class Chat_NettyServerIntialize extends ChannelInitializer<NioSocketChannel>{

	@Override
	protected void initChannel(NioSocketChannel ch) throws Exception {
		System.out.println(123123);
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new StringDecoder());
		pipeline.addLast(new StringEncoder());
		
		pipeline.addLast(new Chat_NettyServerHandler());
		
	}

}
