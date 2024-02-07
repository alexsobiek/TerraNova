package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PacketInLook implements IncomingPacket {
    private float yaw, pitch;
    private boolean onGround;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        yaw = in.readFloat();
        pitch = in.readFloat();
        onGround = in.readBoolean();
    }
}