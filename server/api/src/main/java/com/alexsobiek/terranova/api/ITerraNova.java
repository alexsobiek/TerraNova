package com.alexsobiek.terranova.api;

import com.alexsobiek.terranova.api.event.ServerEvent;
import com.alexsobiek.terranova.event.api.IEventBus;

import java.util.concurrent.ThreadFactory;

public interface ITerraNova extends AutoCloseable {
    ThreadFactory getThreadFactory();
    IEventBus<ServerEvent> getEventBus();
}
