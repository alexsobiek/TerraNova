package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.entity.EntityObject;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class PacketOutSpawnObject implements OutgoingPacket {
    private final int entityId;
    private final EntityObject type;
    private final int x;
    private final int y;
    private final int z;
    private final byte unknownField1;   // following unknown fields are sent when this is >0
    private short unknownField2;        // x on map?
    private short unknownField3;        // y on map?
    private short unknownField4;        // z on map?


    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeByte(type.getId());
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(unknownField1);
        if (unknownField1 > 0) {
            out.writeShort(unknownField2);
            out.writeShort(unknownField3);
            out.writeShort(unknownField4);
        }
    }
}
