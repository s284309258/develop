package netty_practice.protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import protos.proto_simple;

public class ProtoBuf_NettyClinet {
	
	public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                    	ChannelPipeline pipeline = ch.pipeline();
                    	pipeline.addLast(new ProtobufVarint32FrameDecoder());
    					pipeline.addLast(new ProtobufDecoder(proto_simple.simple.getDefaultInstance()));
    					pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
    					pipeline.addLast(new ProtobufEncoder());
    					
    					pipeline.addLast(new ProtoBuf_NettyClinetHandler());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 3636).channel();
        
    }
}
