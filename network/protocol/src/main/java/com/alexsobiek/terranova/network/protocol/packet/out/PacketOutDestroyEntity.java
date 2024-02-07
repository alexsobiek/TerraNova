package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutDestroyEntity implements OutgoingPacket {
    private final int id;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(id);
    }
}