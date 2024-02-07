package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.instance.api.world.Dimension;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PacketBiRespawn implements IncomingPacket, OutgoingPacket {
    private Dimension dimension;


    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        dimension = Dimension.fromId(in.readByte());
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeByte(dimension.getId());
    }
}
