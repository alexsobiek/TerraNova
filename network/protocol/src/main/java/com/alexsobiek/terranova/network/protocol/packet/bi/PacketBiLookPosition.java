package com.alexsobiek.terranova.network.protocol.packet.bi;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PacketBiLookPosition implements IncomingPacket, OutgoingPacket {
    private double x, y, z, stance;
    private float yaw, pitch;
    private boolean onGround;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        x = in.readDouble();
        y = in.readDouble();
        stance = in.readDouble();
        z = in.readDouble();
        yaw = in.readFloat();
        pitch = in.readFloat();
        onGround = in.readBoolean();
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(stance);
        out.writeDouble(z);
        out.writeFloat(yaw);
        out.writeFloat(pitch);
        out.writeBoolean(onGround);
    }
}