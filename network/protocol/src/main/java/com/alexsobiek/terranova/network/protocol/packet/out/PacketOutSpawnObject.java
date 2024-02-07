package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;

public class PacketOutSpawnObject implements OutgoingPacket {
    private final int entityId;


    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {

    }
}
