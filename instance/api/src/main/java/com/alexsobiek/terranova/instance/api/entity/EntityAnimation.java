package com.alexsobiek.terranova.instance.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EntityAnimation {
    NONE(0),
    SWING_ARM(1),
    DAMAGE(2),
    LEAVE_BED(3);

    private final int id;
}