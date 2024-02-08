package com.alexsobiek.terranova.network.codec;

import com.alexsobiek.terranova.network.Connection;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.PacketRegistry;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;

public class PlayCodec extends PacketCodec {
    public PlayCodec(Connection connection) {
        super(connection);
    }

    @Override
    protected void encode(Connection connection, OutgoingPacket msg, PacketByteBuf out) throws PacketWriteException {
        msg.write(out);
    }

    @Override
    protected IncomingPacket decode(Connection connection, byte id, PacketByteBuf in) throws PacketReadException {
        Class<? extends IncomingPacket> clazz = PacketRegistry.getIncomingClass(id);
        if (clazz == null) {
            connection.disconnect(String.format("Bad packet %s", PacketRegistry.getHexString(id)));
            throw new PacketReadException(String.format("Got bad packet %s from %s", PacketRegistry.getHexString(id), connection.getAddress()));
        }

        try {
            IncomingPacket packet = clazz.getDeclaredConstructor().newInstance();
            packet.read(in);

            return packet;
        } catch (Exception e) {
            throw new PacketReadException(e);
        }
    }
}