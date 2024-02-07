package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class PacketOutChat implements OutgoingPacket {
    private final String message;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeUTF16BE(message);
    }
}
