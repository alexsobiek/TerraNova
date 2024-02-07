package com.alexsobiek.terranova.network.protocol.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

@SuppressWarnings("unused")
public class PacketByteBuf extends AbstractByteBuf {
    private PacketByteBuf(ByteBuf parent) {
        super(parent);
    }

    public static PacketByteBuf wrap(ByteBuf parent) {
        return new PacketByteBuf(parent);
    }

    public static PacketByteBuf wrap(byte[] array) {
        return new PacketByteBuf(Unpooled.copiedBuffer(array));
    }

    public static PacketByteBuf unpooled() {
        return new PacketByteBuf(Unpooled.buffer());
    }

    public static PacketByteBuf unpooled(int initialCapacity) {
        return new PacketByteBuf(Unpooled.buffer(initialCapacity));
    }

    public static PacketByteBuf direct() {
        return new PacketByteBuf(Unpooled.directBuffer());
    }

    public static PacketByteBuf direct(int initialCapacity) {
        return new PacketByteBuf(Unpooled.directBuffer(initialCapacity));
    }

    public String readUTF8() {
        short len = this.readShort();
        String s = buf.toString(buf.readerIndex(), len, StandardCharsets.UTF_8);
        buf.readerIndex(buf.readerIndex() + len); // we have to manually advance the reader index since ByteBuffer.toString() doesn't do it for us
        return s;
    }

    public void writeUTF8(String string) {
        this.writeShort(string.length());
        buf.writeBytes(string.getBytes(StandardCharsets.UTF_8));
    }

    public String readUTF16BE() {
        int len = this.readShort() * 2;
        String s = buf.toString(buf.readerIndex(), len, StandardCharsets.UTF_16BE);
        buf.readerIndex(buf.readerIndex() + len); // we have to manually advance the reader index since ByteBuffer.toString() doesn't do it for us
        return s;
    }

    public void writeUTF16BE(String string) {
        this.writeShort(string.length());
        buf.writeBytes(string.getBytes(StandardCharsets.UTF_16BE));
    }
}