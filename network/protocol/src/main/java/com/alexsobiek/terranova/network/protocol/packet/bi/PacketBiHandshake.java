package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PacketBiHandshake implements IncomingPacket, OutgoingPacket {
    private String payload;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        payload = in.readUTF16BE();
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeUTF16BE(payload);
    }
}