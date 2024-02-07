package com.alexsobiek.terranova.instance.api.world;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BlockFace {
    NEGATIVE_Y((byte) 0),
    POSITIVE_Y((byte) 1),
    NEGATIVE_Z((byte) 2),
    POSITIVE_Z((byte) 3),
    NEGATIVE_X((byte) 4),
    POSITIVE_X((byte) 5);

    private final byte id;

    public static BlockFace fromId(byte id) {
        for (BlockFace mineStatus : values()) {
            if (mineStatus.getId() == id) {
                return mineStatus;
            }
        }
        return null;
    }
}
