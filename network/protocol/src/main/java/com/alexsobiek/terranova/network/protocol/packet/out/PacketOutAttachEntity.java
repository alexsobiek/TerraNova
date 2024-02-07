package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutAttachEntity implements OutgoingPacket {
    private final int entityId;
    private final int vehicleId;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeInt(vehicleId);
    }
}
