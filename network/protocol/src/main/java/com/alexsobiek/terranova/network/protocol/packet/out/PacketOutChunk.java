package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutChunk implements OutgoingPacket {
    private final int x, y, z, sizeX, sizeY, sizeZ;
    private final byte[] chunkData;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(x);
        out.writeShort(y);
        out.writeInt(z);
        out.writeByte(sizeX);
        out.writeByte(sizeY);
        out.writeByte(sizeZ);

        out.writeInt(chunkData.length);
        out.writeBytes(chunkData);
    }
}