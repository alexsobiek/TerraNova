package com.alexsobiek.terranova.event;

import com.alexsobiek.terranova.event.api.IEventConsumer;
import com.alexsobiek.terranova.event.api.IEventSubscriber;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class EventSubscriber<E> implements IEventSubscriber<E> {
    private final EventPipeline<E> pipeline;
    @Getter
    private final IEventConsumer<E> consumer;
    private final String name;

    public EventSubscriber(EventPipeline<E> pipeline, IEventConsumer<E> consumer) {
        this(pipeline, consumer, null);
    }

    @Override
    public Class<E> getType() {
        return pipeline.getType();
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public void close() {
        this.pipeline.unsubscribe(this);
    }

    public String toString() {
        return new StringBuilder("EventSubscriber{")
                .append("name=").append(name)
                .append(", consumer=").append(consumer)
                .append("}")
                .toString();
    }
}
