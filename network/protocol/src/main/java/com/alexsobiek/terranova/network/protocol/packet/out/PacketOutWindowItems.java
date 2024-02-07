package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.inventory.Container;
import com.alexsobiek.terranova.instance.api.inventory.Item;
import com.alexsobiek.terranova.instance.api.inventory.ItemStack;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

import java.nio.ByteBuffer;

@RequiredArgsConstructor
public class PacketOutWindowItems implements OutgoingPacket {
    private final byte windowId;
    private final short count;
    private final byte[] payload;

    public PacketOutWindowItems(byte windowId, Container container) {
        this.windowId = windowId;
        this.count = container.slots();
        short usedSlots = container.usedSlots();
        short unusedSlots = (short) (this.count - usedSlots);
        ByteBuffer buffer = ByteBuffer.allocate((unusedSlots * 2) + (usedSlots * 5));
        for (int i = 0; i < this.count; i++) {
            ItemStack stack = container.get(i).get();
            Item item = stack.item();
            buffer.putShort(item.getId());
            if (item != Item.AIR) {
                buffer.put(stack.count());
                buffer.putShort(stack.uses());
            }
        }
        this.payload = buffer.array();
    }

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeByte(windowId);
        out.writeShort(count);
        out.writeBytes(payload);
    }
}