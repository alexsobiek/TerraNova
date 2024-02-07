package com.alexsobiek.terranova.instance.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EntityInventory {
    HELD((short) 0),
    HELMET((short) 1), // This might be boots, so this could be backwards
    CHESTPLATE((short) 2),
    LEGGINGS((short) 3),
    BOOTS((short) 4);

    private final short id;
}