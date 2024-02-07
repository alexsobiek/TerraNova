package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

// https://wiki.vg/index.php?title=Protocol&oldid=510#Entity_Metadata_.280x28.29
@RequiredArgsConstructor
public class PacketOutEntityMetadata implements OutgoingPacket {
    private final int entityId;
    private final byte[] metadata;
    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeBytes(metadata); // this might not be correct
    }
}
