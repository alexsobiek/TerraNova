package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.inventory.Item;
import com.alexsobiek.terranova.instance.api.inventory.ItemStack;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
public class PacketOutSpawnItem implements OutgoingPacket {
    private final int entityId;
    private final ItemStack stack;
    private byte damage;        // Optional
    private int x;
    private byte y;
    private int z;
    private byte rot;
    private byte pitch;
    private byte roll;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        Item item = stack.item();
        out.writeInt(entityId);
        out.writeShort(item.getId());
        out.writeByte(stack.count());
        out.writeByte(item.getData() != 0 ? item.getData() : damage);
        out.writeInt(x);
        out.writeByte(y);
        out.writeInt(z);
        out.writeByte(rot);
        out.writeByte(pitch);
        out.writeByte(roll);
    }
}
