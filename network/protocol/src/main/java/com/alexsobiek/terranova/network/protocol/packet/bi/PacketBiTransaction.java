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
public class PacketBiTransaction implements IncomingPacket, OutgoingPacket {
    private byte windowId;
    private short actionNumber;
    private boolean accepted;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        windowId = in.readByte();
        actionNumber = in.readShort();
        accepted = in.readBoolean();
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeByte(windowId);
        out.writeShort(actionNumber);
        out.writeBoolean(accepted);
    }
}
