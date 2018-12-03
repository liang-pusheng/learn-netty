package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

public class ProtocolDecoder extends ByteToMessageDecoder {
    // 自定义的协议是TCP协议
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
            throws Exception {
        // 获取协议头
        int version = in.readInt();
        int contentLength = in.readInt();
        byte[] sessionByte = new byte[36];
        in.readBytes(sessionByte);
        String sessionId = new String(sessionByte);

        // 组装协议头
        ProtocolHeader header = new ProtocolHeader(version, contentLength, sessionId);

        String content = new String(ByteBufUtil.getBytes(in), Charset.forName("UTF-8"));
//        byte[] content = in.readBytes(in.readableBytes()).array();
        ProtocolContent message = new ProtocolContent(header, content);
        out.add(message);

    }
}
