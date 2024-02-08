package com.alexsobiek.terranova.network.codec;

import com.alexsobiek.terranova.network.Connection;
import com.alexsobiek.terranova.network.protocol.exception.PacketException;
import com.alexsobiek.terranova.network.protocol.packet.Packet;
import com.alexsobiek.terranova.network.protocol.packet.PacketRegistry;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PacketHandlerCodec extends MessageToMessageCodec<IncomingPacket, OutgoingPacket> {
    private final Connection connection;


    @Override
    protected void encode(ChannelHandlerContext ctx, OutgoingPacket msg, List<Object> out) throws Exception {
        preconditions(ctx, msg);
        // TODO: any last minute packet checking
        out.add(msg);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, IncomingPacket msg, List<Object> out) throws Exception {
        preconditions(ctx, msg);
        connection.read(msg);
    }

    private void preconditions(ChannelHandlerContext ctx, Packet msg) throws PacketException {
        if (!connection.isActive())
            throw new PacketException(String.format("Tried to handle packet %s on %s while connection is not active", PacketRegistry.getHexString(msg.getClass()), ctx.channel().remoteAddress()));

        if (!connection.getAddress().equals(ctx.channel().remoteAddress()))
            throw new PacketException("Channel mismatch");
    }
}
