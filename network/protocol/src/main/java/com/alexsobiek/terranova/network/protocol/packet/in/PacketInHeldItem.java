package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.instance.api.inventory.Item;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.Getter;

@Getter
public class PacketInHeldItem implements IncomingPacket {
    private short slot;

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        slot = in.readShort();
    }
}
