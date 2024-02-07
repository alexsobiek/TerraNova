package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;

public class PacketBiKeepAlive implements IncomingPacket, OutgoingPacket {
    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
    }
}