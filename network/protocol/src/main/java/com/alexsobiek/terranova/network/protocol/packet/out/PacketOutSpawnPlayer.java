package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutSpawnPlayer implements OutgoingPacket {
    private final int id;
    private final String name;
    private final int x;
    private final int y;
    private final int z;
    private final byte yaw;
    private final byte pitch;
    private final short currentItem;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(id);
        out.writeUTF16BE(name);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(yaw);
        out.writeByte(pitch);
        out.writeShort(currentItem);
    }
}
