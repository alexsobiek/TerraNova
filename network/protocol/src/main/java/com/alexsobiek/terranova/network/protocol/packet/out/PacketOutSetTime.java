package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutSetTime implements OutgoingPacket {
    private final long time;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        // Max 24000L (1 day)
        // 0 is sunrise, 6000 is noon, 12000 is sunset, and 18000 is midnight
        out.writeLong(time);
    }
}