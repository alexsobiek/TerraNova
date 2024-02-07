package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

// https://wiki.vg/index.php?title=Protocol&oldid=510#Update_progress_bar_.280x69.29
@RequiredArgsConstructor
public class PacketOutUpdateProgressBar implements OutgoingPacket {
    private final int windowId;
    private final short progressBar;
    private final short value;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeByte(windowId);
        out.writeShort(progressBar);
        out.writeShort(value);
    }
}
