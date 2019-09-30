package netty_practice;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chat_NettyClient {
	public static void main(String[] args) throws Exception {
		EventLoopGroup work = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(work).channel(NioSocketChannel.class).handler(new ChannelInitializer<Channel>() {

			@Override
			protected void initChannel(Channel ch) throws Exception {
				ChannelPipeline pipelline = ch.pipeline();
				pipelline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
				pipelline.addLast(new StringEncoder());
				pipelline.addLast(new StringDecoder());
				pipelline.addLast(new SimpleChannelInboundHandler<String>() {

					@Override
					protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
						System.out.println(msg);
					}
					
				});
			}
			
		});
		
		 Channel channel = bootstrap.connect("127.0.0.1", 3333).sync().channel();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            channel.writeAndFlush(in.readLine() + "\r\n");
        }
	}
}
