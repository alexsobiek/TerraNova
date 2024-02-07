package com.alexsobiek.terranova.network.protocol.packet.out;

import com.alexsobiek.terranova.instance.api.inventory.Item;
import com.alexsobiek.terranova.instance.api.inventory.ItemStack;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import lombok.RequiredArgsConstructor;

// https://wiki.vg/index.php?title=Protocol&oldid=510#Item_Data_.280x83.29
@RequiredArgsConstructor
public class PacketOutItemData implements OutgoingPacket {
    private final ItemStack stack;
    private final String text;

    @Override
    public void write(PacketByteBuf out) throws PacketWriteException {
        out.writeShort(stack.item().getId());
        out.writeByte(stack.uses()); // FIXME: this might not be correct, this is a damage field
        out.writeByte(text.length());
        // write ASCII string
        for (char c : text.toCharArray()) out.writeByte(c);
    }
}
