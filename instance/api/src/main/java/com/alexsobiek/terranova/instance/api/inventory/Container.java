package com.alexsobiek.terranova.instance.api.inventory;


import java.util.Optional;
import java.util.function.BiConsumer;

public interface Container {
    short slots();

    short usedSlots();

    Optional<? extends ItemStack> get(int slot);

    void set(int slot, ItemStack item);

    default void forEach(BiConsumer<Byte, ItemStack> consumer) {
        for (int i = 0; i < slots(); i++) {
            final int slotId = i;
            get(i).ifPresent(item -> consumer.accept((byte) slotId, item));
        }
    }
}