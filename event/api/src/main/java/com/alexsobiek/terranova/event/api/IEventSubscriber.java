package com.alexsobiek.terranova.event.api;

import java.util.Optional;

public interface IEventSubscriber<E> extends AutoCloseable {
    Class<E> getType();

    IEventConsumer<E> getConsumer();

    Optional<String> getName();
}
