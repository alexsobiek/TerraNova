package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PacketOutSetHealth implements OutgoingPacket {
    private final short health;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeShort(health);
    }
}
