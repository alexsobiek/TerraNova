package com.alexsobiek.terranova.event.api;

import java.util.Collection;

public interface IEventPipeline<E> extends IEventSubscriber<E> {
    Class<E> getType();

    void post(E event);

    IEventSubscriber<E> subscribe(IEventConsumer<E> consumer);

    IEventSubscriber<E> subscribeBefore(String name, IEventConsumer<E> consumer);

    IEventSubscriber<E> subscribeAfter(String name, IEventConsumer<E> consumer);

    void unsubscribe(IEventSubscriber<E> subscriber);

    void unsubscribe(String name);

    Collection<IEventSubscriber<E>> subscribers();

//    @Override
//    default String toString() {
//        StringBuilder builder = new StringBuilder("EventPipeline[");
//        EventSubscriber[] subscribers = subscribers().toArray(new EventSubscriber[0]);
//        int size = subscribers.length;
//        for (int i = 0; i < size - 1; i++) builder.append(subscribers[i].toString()).append(", ");
//        if (size > 0) builder.append(subscribers[size - 1].toString());
//        return builder.append("]").toString();
//    }
}
