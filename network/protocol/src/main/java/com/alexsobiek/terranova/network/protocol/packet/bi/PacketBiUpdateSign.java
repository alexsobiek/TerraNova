package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PacketBiUpdateSign implements IncomingPacket, OutgoingPacket {
    private int x;
    private short y;
    private int z;
    private String[] lines;


    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        x = in.readInt();
        y = in.readShort();
        z = in.readInt();
        lines = new String[4];
        for (int i = 0; i < 4; i++) lines[i] = in.readUTF16BE();
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(x);
        out.writeShort(y);
        out.writeInt(z);
        for (int i = 0; i < 4; i++) out.writeUTF16BE(lines[i]);
    }
}
