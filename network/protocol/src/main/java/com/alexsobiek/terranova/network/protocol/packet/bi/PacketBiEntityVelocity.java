package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.AllArgsConstructor;
import lombok.Getter;

// https://wiki.vg/index.php?title=Protocol&oldid=510#Entity_Velocity.3F_.280x1C.29
@Getter
@AllArgsConstructor
public class PacketBiEntityVelocity implements IncomingPacket, OutgoingPacket {
    private int entityId;
    private short velocityX;
    private short velocityY;
    private short velocityZ;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        entityId = in.readInt();
        velocityX = in.readShort();
        velocityY = in.readShort();
        velocityZ = in.readShort();
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeShort(velocityX);
        out.writeShort(velocityY);
        out.writeShort(velocityZ);
    }
}
