package com.alexsobiek.terranova.event.api;

public interface IEventBus<T> {
    <E extends T> void post(E event);

    <E extends T> IEventSubscriber<E> subscribe(Class<E> eventClass, IEventConsumer<E> consumer);

    <E extends T> void unsubscribe(IEventSubscriber<E> subscriber);
}
