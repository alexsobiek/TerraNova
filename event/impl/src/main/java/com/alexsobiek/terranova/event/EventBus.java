package com.alexsobiek.terranova.event;

import com.alexsobiek.terranova.event.api.IEventBus;
import com.alexsobiek.terranova.event.api.IEventConsumer;
import com.alexsobiek.terranova.event.api.IEventSubscriber;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class EventBus<T> implements IEventBus<T> {
    private final ConcurrentHashMap<Class<? extends T>, EventPipeline<? extends T>> pipelines = new ConcurrentHashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <E extends T> void post(E event) {
        Optional.ofNullable(pipelines.get(event.getClass()))
                .map(pipeline -> (EventPipeline<E>) pipeline)
                .ifPresent(pipeline -> pipeline.post(event));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends T> EventSubscriber<E> subscribe(Class<E> eventClass, IEventConsumer<E> consumer) {
        EventPipeline<E> pipeline = (EventPipeline<E>) pipelines.computeIfAbsent(eventClass, ignored -> new EventPipeline<>(eventClass, this));
        return pipeline.subscribe(consumer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends T> void unsubscribe(IEventSubscriber<E> subscriber) {
        Optional.ofNullable(pipelines.get(subscriber.getType()))
                .map(pipeline -> (EventPipeline<E>) pipeline)
                .ifPresent(pipeline -> pipeline.unsubscribe(subscriber));
    }

    protected void unsubscribePipeline(EventPipeline<?> pipeline) {
        Optional.ofNullable(pipelines.get(pipeline.getType()))
                .filter(p -> p == pipeline) // remove only this pipeline if it exists
                .ifPresent(p -> pipelines.remove(pipeline.getType()));
    }
}
