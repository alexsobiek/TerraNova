package com.alexsobiek.terranova.instance.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EntityObject {
    BOAT((byte) 1),
    MINECART((byte) 10),
    MINECART_CHEST((byte) 11),
    POWERED_MINECART((byte) 12),
    ACTIVATED_TNT((byte) 50),
    ARROW((byte) 60),
    SNOWBALL((byte) 61),
    EGG((byte) 62),
    FALLING_SAND((byte) 70),
    FALLING_GRAVEL((byte) 71),
    FISHING_FLOAT((byte) 90); // What is this?

    private final byte id;

    public static EntityObject fromId(byte id) {
        for (EntityObject entity : values()) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        throw new IllegalStateException("Unknown entity id: " + id);
    }
}
