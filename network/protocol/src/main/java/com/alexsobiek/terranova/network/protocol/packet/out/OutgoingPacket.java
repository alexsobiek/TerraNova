package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.packet.Packet;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;

public interface OutgoingPacket extends Packet {
    void write(PacketByteBuf out) throws PacketWriteException;
}
