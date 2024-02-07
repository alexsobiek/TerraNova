package com.alexsobiek.terranova.instance.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EntityAction {
    CROUCH(1),
    UNCROUCH(2),
    LEAVE_BED(3);

    private final int id;

    public static EntityAction of(byte id) {
        return switch (id) {
            case 1 -> CROUCH;
            case 2 -> UNCROUCH;
            case 3 -> LEAVE_BED;
            default -> null;
        };
    }
}