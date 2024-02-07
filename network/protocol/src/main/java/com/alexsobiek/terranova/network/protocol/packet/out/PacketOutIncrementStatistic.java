package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutIncrementStatistic implements OutgoingPacket {
    private final int statisticId;
    private final byte amount;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(statisticId);
        out.writeByte(amount);
    }
}
