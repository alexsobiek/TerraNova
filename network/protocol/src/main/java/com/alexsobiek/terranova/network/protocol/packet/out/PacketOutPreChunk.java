package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutPreChunk implements OutgoingPacket {
    private final int x, z;
    private final boolean initialize;


    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(x);
        out.writeInt(z);
        out.writeBoolean(initialize);
    }
}
