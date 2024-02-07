package com.alexsobiek.terranova.util;

import java.util.function.BiConsumer;

public class TerraThreadGroup extends ThreadGroup {
    private final BiConsumer<Thread, Throwable> uncaughtExceptionHandler;
    public TerraThreadGroup(String name, BiConsumer<Thread, Throwable> uncaughtExceptionHandler) {
        super(name);
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    public TerraThreadGroup(ThreadGroup parent, String name, BiConsumer<Thread, Throwable> uncaughtExceptionHandler) {
        super(parent, name);
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        uncaughtExceptionHandler.accept(t, e);
    }
}