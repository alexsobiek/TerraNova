package com.alexsobiek.terranova.instance.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MobType {
    CREEPER((byte) 50),
    SKELETON((byte) 51),
    SPIDER((byte) 52),
    GIANT_ZOMBIE((byte) 53),
    ZOMBIE((byte) 54),
    SLIME((byte) 55),
    GHAST((byte) 56),
    ZOMBIE_PIGMAN((byte) 57),
    PIG((byte) 90),
    SHEEP((byte) 91),
    COW((byte) 92),
    CHICKEN((byte) 93),
    SQUID((byte) 94),
    WOLF((byte) 95);

    private final byte id;

    public static MobType fromId(byte id) {
        for (MobType mob : values()) {
            if (mob.getId() == id) {
                return mob;
            }
        }
        throw new IllegalStateException("Unknown mob id: " + id);
    }
}
