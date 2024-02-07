package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.instance.api.entity.EntityAnimation;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PacketBiEntityAnimation implements IncomingPacket, OutgoingPacket {
    private int entityId;
    private EntityAnimation animation;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        entityId = in.readInt();
        animation = EntityAnimation.fromId(in.readByte());
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeByte(animation.getId());
    }
}
