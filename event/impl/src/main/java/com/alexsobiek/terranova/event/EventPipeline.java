package com.alexsobiek.terranova.event;

import com.alexsobiek.terranova.event.api.IEventConsumer;
import com.alexsobiek.terranova.event.api.IEventPipeline;
import com.alexsobiek.terranova.event.api.IEventSubscriber;
import com.alexsobiek.terranova.event.util.list.ConcurrentLinkedList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class EventPipeline<E> implements IEventPipeline<E> {
    @Getter
    private final Class<E> type;
    private final ConcurrentLinkedList<EventSubscriber<E>> subscribers = new ConcurrentLinkedList<>();
    private final String name;
    private final Consumer<EventPipeline<E>> closeFunction;

    public EventPipeline(Class<E> type, EventPipeline<E> parent) {
        this(type, null, parent::unsubscribe);
    }

    public EventPipeline(Class<E> type, String name, EventPipeline<E> parent) {
        this(type, name, parent::unsubscribe);
    }

    public EventPipeline(Class<E> type, EventBus<?> bus) {
        this(type, null, bus::unsubscribePipeline);
    }

    @Override
    public void post(E event) {
        subscribers.forEach(s -> s.getConsumer().consume(event));
    }

    @Override
    public EventSubscriber<E> subscribe(IEventConsumer<E> consumer) {
        EventSubscriber<E> subscriber = new EventSubscriber<>(this, consumer);
        subscribers.add(subscriber);
        return subscriber;
    }

    @Override
    public IEventSubscriber<E> subscribeBefore(String name, IEventConsumer<E> consumer) {
        EventSubscriber<E> subscriber = new EventSubscriber<>(this, consumer, name);
        subscribers.addBefore(subscriber, s -> s.getName().map(n -> n.equals(name)).orElse(false));
        return subscriber;
    }

    @Override
    public IEventSubscriber<E> subscribeAfter(String name, IEventConsumer<E> consumer) {
        EventSubscriber<E> subscriber = new EventSubscriber<>(this, consumer, name);
        subscribers.addAfter(subscriber, s -> s.getName().map(n -> n.equals(name)).orElse(false));
        return subscriber;
    }

    @Override
    public void unsubscribe(IEventSubscriber<E> subscriber) {
        subscribers.remove((EventSubscriber<E>) subscriber);
    }

    @Override
    public void unsubscribe(String name) {
        subscribers.removeIf(s -> s.getName().map(n -> n.equals(name)).orElse(false));
    }

    @Override
    public Collection<IEventSubscriber<E>> subscribers() {
        return null;
    }

    @Override
    public IEventConsumer<E> getConsumer() {
        return this::post;
    }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public void close() {
        closeFunction.accept(this);
    }
}
