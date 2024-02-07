package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.entity.EntityInventory;
import com.alexsobiek.terranova.instance.api.inventory.Item;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PacketOutEntityInventory implements OutgoingPacket {
    private final int entityId;
    private final EntityInventory slot;
    private final Optional<Item> item;
    private final short damage;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeInt(entityId);
        out.writeShort(slot.getId());
        out.writeShort(item.map(Item::getId).orElse((short) -1));
        out.writeShort(damage);
    }
}
