package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutCollectItem implements OutgoingPacket {
    private int collectedEntityId;
    private int collectorEntityId;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(collectedEntityId);
        out.writeInt(collectorEntityId);
    }
}
