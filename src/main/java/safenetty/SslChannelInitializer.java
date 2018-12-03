package safenetty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/**
 * 使用SSL/TLS创建安全的Netty程序
 */
public class SslChannelInitializer extends ChannelInitializer<Channel> {

    private final SSLContext context;

    private final boolean client;

    private final boolean startTLs;

    public SslChannelInitializer(SSLContext context, boolean client, boolean startTLs) {
        this.context = context;
        this.client = client;
        this.startTLs = startTLs;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        SSLEngine engine = context.createSSLEngine();
        engine.setUseClientMode(client);
        ChannelPipeline pipeline = channel.pipeline();
        // 需要注意的是SSLHandler必须添加到pipeline的第一个位置
        pipeline.addFirst("ssl", new SslHandler(engine, startTLs));
    }
}
