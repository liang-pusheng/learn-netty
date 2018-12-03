package protocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    private static final ProtocolEncoder ENCODER = new ProtocolEncoder();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(ENCODER);
        pipeline.addLast(new ProtocolDecoder());
        pipeline.addLast(new ClientHandler());
    }
}
