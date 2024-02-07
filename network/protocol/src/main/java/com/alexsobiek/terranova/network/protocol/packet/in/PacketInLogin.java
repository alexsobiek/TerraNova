package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PacketInLogin implements IncomingPacket {
    private int protocolVersion;
    private String username;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        protocolVersion = in.readInt();
        username = in.readUTF16BE();
        // Read unused fields
        in.readLong();
        in.readByte();
    }
}