package protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.UUID;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ClientInitializer());

            Channel channel = b.connect("127.0.0.1", 9999).sync().channel();

            int version = 1;
            String sessionId = UUID.randomUUID().toString();
            String content = "this is a new protocol";
            ProtocolHeader header = new ProtocolHeader(version, content.length(), sessionId);
            ProtocolContent message = new ProtocolContent(header, content);
            channel.writeAndFlush(message);
            channel.close();
        } finally {
            group.shutdownGracefully();
        }
    }
}
