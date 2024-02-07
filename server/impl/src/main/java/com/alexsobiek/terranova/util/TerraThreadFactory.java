package com.alexsobiek.terranova.util;


import com.alexsobiek.terranova.TerraNova;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

@Getter
public class TerraThreadFactory implements ThreadFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger("TerraThreadFactory");
    private final TerraThreadGroup group;

    public TerraThreadFactory(String name, TerraNova terraNova) {
        group = new TerraThreadGroup(name, terraNova::handleUncaughtException);
    }

    public Thread newThread(Runnable runnable, String name) {
        Thread thread = new Thread(group, runnable);
        if (name == null) name = String.format("%d", thread.getId());
        thread.setName(String.format("%s/%s", group.getName(), name));
        LOGGER.debug("Created new thread: {}", thread.getName());
        return thread;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return this.newThread(runnable, null);
    }


}
