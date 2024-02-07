package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class PacketInPosition implements IncomingPacket {
    private double x, y, z, stance;
    private boolean onGround;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        x = in.readDouble();
        y = in.readDouble();
        stance = in.readDouble();
        z = in.readDouble();
        onGround = in.readBoolean();
    }
}