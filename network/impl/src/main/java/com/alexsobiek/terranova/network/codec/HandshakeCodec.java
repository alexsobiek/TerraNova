package com.alexsobiek.terranova.network.codec;

import com.alexsobiek.terranova.network.Connection;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.PacketRegistry;
import com.alexsobiek.terranova.network.protocol.packet.bi.PacketBiDisconnect;
import com.alexsobiek.terranova.network.protocol.packet.bi.PacketBiHandshake;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;

public class HandshakeCodec extends PacketCodec {

    public HandshakeCodec(Connection connection) {
        super(connection);
    }

    @Override
    protected void encode(Connection connection, OutgoingPacket msg, PacketByteBuf out) throws PacketWriteException {
        if (!(msg instanceof PacketBiHandshake) && !(msg instanceof PacketBiDisconnect))
            throw new PacketWriteException("Cannot write packet before handshake");

        msg.write(out);
    }

    @Override
    protected IncomingPacket decode(Connection connection, byte id, PacketByteBuf in) throws PacketReadException {
        if (id != PacketRegistry.getIncomingId(PacketBiHandshake.class))
            throw new PacketReadException("Tried to read play packet before handshake");

        PacketBiHandshake packet = new PacketBiHandshake();
        packet.read(in);
        return packet;
    }
}