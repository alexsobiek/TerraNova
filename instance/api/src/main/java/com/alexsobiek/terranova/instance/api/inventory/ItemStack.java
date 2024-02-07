package com.alexsobiek.terranova.instance.api.inventory;

public interface ItemStack {
    Item item();

    byte count();

    short uses();

    void count(byte count);

    void uses(short uses);
}