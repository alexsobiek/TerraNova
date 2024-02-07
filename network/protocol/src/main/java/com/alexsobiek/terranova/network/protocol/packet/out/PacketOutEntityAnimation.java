package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.entity.EntityAnimation;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutEntityAnimation implements OutgoingPacket {
    private final int id;
    private final byte animation;

    public PacketOutEntityAnimation(int entityId, EntityAnimation animation) {
        this(entityId, (byte) animation.getId());
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(id);
        out.writeByte(animation);
    }
}