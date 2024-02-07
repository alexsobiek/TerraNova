package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutPainting implements OutgoingPacket {
    private final int entityId;
    private final String title;
    private final int x;
    private final int y;
    private final int z;
    private final int direction;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        if (title.length() > 16) throw new PacketWriteException("Painting title cannot be longer than 16 characters");

        out.writeInt(entityId);
        out.writeUTF16BE(title);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        out.writeByte(direction);
    }
}
