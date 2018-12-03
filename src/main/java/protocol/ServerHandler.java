package protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<ProtocolContent> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtocolContent content)
            throws Exception {
        System.out.println("server handler:" + content.toString());
        ctx.write(content);
    }
}
