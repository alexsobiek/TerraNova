package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutEntityLook implements OutgoingPacket {
    private final int id;
    private final byte yaw, pitch;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(id);
        out.writeByte(yaw);
        out.writeByte(pitch);
    }
}