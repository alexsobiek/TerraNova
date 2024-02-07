package com.alexsobiek.terranova;

import com.alexsobiek.logger.LogUtil;
import com.alexsobiek.terranova.api.ITerraNova;
import com.alexsobiek.terranova.api.event.ServerEvent;
import com.alexsobiek.terranova.api.event.TestServerEvent;
import com.alexsobiek.terranova.config.ServerConfig;
import com.alexsobiek.terranova.event.EventBus;
import com.alexsobiek.terranova.event.EventSubscriber;
import com.alexsobiek.terranova.util.TerraThreadFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class TerraNova implements ITerraNova {
    protected static final Logger LOGGER = LoggerFactory.getLogger("TerraNova");
    @Getter
    private final TerraThreadFactory threadFactory = new TerraThreadFactory("Main", this);
    private final ServerConfig config;
    @Getter
    private final EventBus<ServerEvent> eventBus = new EventBus<>();

    protected void start() {
        LOGGER.info("Starting TerraNova...");
        long startTime = System.currentTimeMillis();

        // Start server
        EventSubscriber<TestServerEvent> subscriber = eventBus.subscribe(TestServerEvent.class, event -> LOGGER.info("Received test event"));
        eventBus.post(new TestServerEvent());
        subscriber.close();
        eventBus.post(new TestServerEvent()); // Should not be received

        LOGGER.info("Done ({}ms)", System.currentTimeMillis() - startTime);
    }

    public void handleUncaughtException(Thread t, Throwable e) {
        LOGGER.error("Uncaught exception in thread {}", t.getName(), e);
    }

    @Override
    public void close() throws Exception {
    }
}
