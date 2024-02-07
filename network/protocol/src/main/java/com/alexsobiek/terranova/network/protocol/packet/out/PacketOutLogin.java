package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.world.Dimension;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutLogin implements OutgoingPacket {
    private final int entityId;
    private final String payload;
    private final long seed;
    private final Dimension dimension;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeUTF16BE(payload);
        out.writeLong(seed);
        out.writeByte(dimension.getId());
    }
}