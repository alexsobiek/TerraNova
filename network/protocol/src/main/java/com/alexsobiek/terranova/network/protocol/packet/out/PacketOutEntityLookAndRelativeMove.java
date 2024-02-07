package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutEntityLookAndRelativeMove implements OutgoingPacket {
    private final int entityId;
    private final byte dX;
    private final byte dY;
    private final byte dZ;
    private final byte yaw;
    private final byte pitch;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeByte(dX);
        out.writeByte(dY);
        out.writeByte(dZ);
        out.writeByte(yaw);
        out.writeByte(pitch);
    }
}
