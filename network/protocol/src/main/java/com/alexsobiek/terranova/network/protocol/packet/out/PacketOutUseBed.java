package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutUseBed implements OutgoingPacket {
    private final int entityId;
    private byte inBed; // ??? 0 appears when players use bed
    private int x;
    private byte y;
    private int z;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeByte(inBed);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
    }
}
