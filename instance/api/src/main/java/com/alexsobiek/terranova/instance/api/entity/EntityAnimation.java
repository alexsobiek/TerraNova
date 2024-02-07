package com.alexsobiek.terranova.instance.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EntityAnimation {
    NONE(0),
    SWING_ARM(1),
    DAMAGE(2),
    LEAVE_BED(3),
    UNKNOWN(102),   // TODO: Find out what animation this is
    CROUCH(104),
    UNCROUCH(105);

    private final int id;

    public static EntityAnimation fromId(int id) {
        for (EntityAnimation animation : values()) {
            if (animation.getId() == id) {
                return animation;
            }
        }
        throw new IllegalStateException("Unknown animation id: " + id);
    }
}