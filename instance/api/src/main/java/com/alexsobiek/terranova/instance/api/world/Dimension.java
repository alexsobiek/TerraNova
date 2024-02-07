package com.alexsobiek.terranova.instance.api.world;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@RequiredArgsConstructor
public enum Dimension {
    OVERWORLD((byte) 0),
    NETHER((byte) -1);

    private final byte id;

    public static Dimension fromId(byte id) {
        for (Dimension dimension : values()) {
            if (dimension.getId() == id) {
                return dimension;
            }
        }
        return null;
    }
}