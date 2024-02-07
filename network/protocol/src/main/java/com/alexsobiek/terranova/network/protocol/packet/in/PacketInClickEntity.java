package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.Getter;

@Getter
public class PacketInClickEntity implements IncomingPacket {
    private int playerId;
    private int entityId;
    private boolean leftClick;


    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        playerId = in.readInt();
        entityId = in.readInt();
        leftClick = in.readBoolean();
    }
}
