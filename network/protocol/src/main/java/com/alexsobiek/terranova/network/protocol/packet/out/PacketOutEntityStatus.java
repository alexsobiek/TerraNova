package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

// https://wiki.vg/index.php?title=Protocol&oldid=510#Entity_Status.3F_.280x26.29
@RequiredArgsConstructor
public class PacketOutEntityStatus implements OutgoingPacket {
    private final int entityId;
    private final byte status;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeByte(status);
    }
}
