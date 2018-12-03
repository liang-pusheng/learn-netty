package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ProtocolEncoder extends MessageToByteEncoder<ProtocolContent> {


    @Override
    protected void encode(ChannelHandlerContext ctx,
                          ProtocolContent content, ByteBuf out) throws Exception {
        ProtocolHeader header = content.getProtocolHeader();
        // 将content转成二进制，写入的顺序就是自定义协议的顺序
        out.writeInt(header.getVersion());
        out.writeInt(content.getContent().length());
        out.writeBytes(header.getSessionId().getBytes());
        out.writeBytes(content.getContent().getBytes());
    }
}
