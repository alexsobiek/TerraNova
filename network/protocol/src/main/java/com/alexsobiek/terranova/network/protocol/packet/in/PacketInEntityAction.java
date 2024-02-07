package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.instance.api.entity.EntityAction;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class PacketInEntityAction implements IncomingPacket {
    private int id;
    private EntityAction action;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        id = in.readInt();
        action = EntityAction.of(in.readByte());
    }
}