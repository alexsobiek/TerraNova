package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.network.protocol.packet.Packet;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;

public interface IncomingPacket extends Packet {
    void read(PacketByteBuf in) throws PacketReadException;
}
