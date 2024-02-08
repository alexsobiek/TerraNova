package com.alexsobiek.terranova.network.codec;

import com.alexsobiek.terranova.network.Connection;
import com.alexsobiek.terranova.network.Network;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketException;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.PacketRegistry;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class PacketCodec extends ByteToMessageCodec<OutgoingPacket> {
    private final Connection connection;

    @Override
    protected void encode(ChannelHandlerContext ctx, OutgoingPacket msg, ByteBuf out) throws Exception {
        preconditions(ctx);

        byte id = PacketRegistry.getOutgoingId(msg.getClass());
        out.writeByte(id);
        this.encode(this.connection, msg, PacketByteBuf.wrap(out));
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        preconditions(ctx);

        byte id = in.readByte(); // read id

        try {
            IncomingPacket packet = this.decode(connection, id, PacketByteBuf.wrap(in));
            Network.getLogger().debug("Received packet {} from {}", packet.getClass().getSimpleName(), ctx.channel().remoteAddress());
            out.add(packet);
        } catch (PacketReadException e) {
            Network.getLogger().warn("Received unknown or malformed packet {} from {}", PacketRegistry.getHexString(id), ctx.channel().remoteAddress());
            connection.handleException(e);

            // read (skip) all bytes
            in.readerIndex(in.writerIndex());
        }

        // Check if we have any remaining bytes for another packet
        if (in.readableBytes() > 0) {
            // Continue processing data from current buffer
            this.decode(ctx, in, out);
        }
    }

    private void preconditions(ChannelHandlerContext ctx) throws PacketException {
        if (!connection.isActive())
            throw new PacketException(String.format("Tried to handle packet on %s while connection is not active", ctx.channel().remoteAddress()));

        if (!connection.getAddress().equals(ctx.channel().remoteAddress()))
            throw new PacketException("Channel mismatch");
    }

    protected abstract void encode(Connection connection, OutgoingPacket msg, PacketByteBuf out) throws PacketWriteException;

    protected abstract IncomingPacket decode(Connection connection, byte id, PacketByteBuf in) throws PacketReadException;
}
