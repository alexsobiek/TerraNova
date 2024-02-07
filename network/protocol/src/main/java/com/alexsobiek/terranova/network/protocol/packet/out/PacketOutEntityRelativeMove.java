package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutEntityRelativeMove implements OutgoingPacket {
    private final int id;
    private final byte dX;
    private final byte dY;
    private final byte dZ;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(id);
        out.writeByte(dX);
        out.writeByte(dY);
        out.writeByte(dZ);
    }
}