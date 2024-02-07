package com.alexsobiek.terranova.event.api;

@FunctionalInterface
public interface IEventConsumer<E> {
    void consume(E event);
}
