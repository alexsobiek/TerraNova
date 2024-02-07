package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
public class PacketBiDisconnect implements IncomingPacket, OutgoingPacket {
    public String reason;

    public PacketBiDisconnect(String reason) {
        this.reason = reason;
    }

    public PacketBiDisconnect() {
        this("Disconnected");
    }


    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeUTF16BE(reason);
    }

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        reason = in.readUTF16BE();
    }
}