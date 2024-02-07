package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PacketInFlying implements IncomingPacket {
    private boolean flying;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        flying = in.readBoolean();
    }
}
