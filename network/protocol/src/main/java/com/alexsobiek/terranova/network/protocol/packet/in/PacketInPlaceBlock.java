package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.instance.api.inventory.Item;
import com.alexsobiek.terranova.instance.api.world.BlockFace;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import lombok.Getter;

@Getter
public class PacketInPlaceBlock implements IncomingPacket {
    private int x;
    private byte y;
    private int z;
    private BlockFace direction;
    private Item item;
    private byte amount;    // Optional
    private byte damage;    // Optional

    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
        direction = BlockFace.fromId(in.readByte());
        item = Item.getById(in.readShort());
        amount =  in.readableBytes() > 0 ? in.readByte() : 1;
        damage =  in.readableBytes() > 0 ? in.readByte() : 0;
    }
}
