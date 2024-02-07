package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.entity.MobType;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

// https://wiki.vg/index.php?title=Protocol&oldid=510#Mob_Spawn_.280x18.29
@RequiredArgsConstructor
public class PacketOutSpawnMob implements OutgoingPacket {
    private final int entityId;
    private final MobType type;
    private final int x;
    private final int y;
    private final int z;
    private final byte yaw;
    private final byte pitch;
    private final byte metadata; // Indexed metadata for Mob. Terminated by 0x7F

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeByte(type.getId());
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(yaw);
        out.writeByte(pitch);
        out.writeByte(metadata);
    }
}
