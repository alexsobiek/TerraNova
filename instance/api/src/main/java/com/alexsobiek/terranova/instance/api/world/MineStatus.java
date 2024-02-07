package com.alexsobiek.terranova.instance.api.world;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MineStatus {
    STARTED((byte) 0),
    FINISHED((byte) 2),
    DROP_ITEM((byte) 4);

    private final byte id;

    public static MineStatus fromId(byte id) {
        for (MineStatus mineStatus : values()) {
            if (mineStatus.getId() == id) {
                return mineStatus;
            }
        }
        return null;
    }
}
