package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.inventory.ItemStack;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketOutSetSlot implements OutgoingPacket {
    private final byte windowId;
    private final short slot;
    private final ItemStack stack;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeByte(windowId);
        out.writeShort(slot);
        short id = stack.item().getId();
        out.writeShort(id);
        if (id != -1) {
            out.writeByte(stack.count());
            out.writeShort(stack.uses());
        }
    }
}
