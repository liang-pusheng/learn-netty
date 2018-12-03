package helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Arrays;

public class Test extends ChannelInboundHandlerAdapter {
    // when you finish netty course
    // can you implement a IM Server
    // can you implement a RPC framework
    // main assembly
    // Channel ChannelHandler ChannelPipeline ChannelHandlerContext ByteBuf
    // Codec HTTP TCP WebSocket
    public static void main(String[] args) {
        byte[] bytes = {'w', 'e', 'r'};
        // 把字节数组拷贝到ByteBuf中
        ByteBuf buf = Unpooled.copiedBuffer(bytes);

        System.out.println(buf.readableBytes());
        System.out.println(buf.capacity());
        System.out.println(buf);
        ByteBuf buf1 = Unpooled.copiedBuffer(bytes);// 字节数组拷贝到ByteBuf容器中
        System.out.println(buf1.readableBytes());
        System.out.println(Arrays.toString(buf.array()));
        System.out.println(buf == buf1);
    }
}
