package com.alexsobiek.terranova;

import com.alexsobiek.logger.LogUtil;
import com.alexsobiek.terranova.config.ServerConfig;

public class Bootstrap {
    public static void main(String[] args) {
        TerraNova.LOGGER.info("Bootstrapping TerraNova...");
        ServerConfig config = new ServerConfig();

        // Set log level
        LogUtil.setLevel(config.getLogLevel());
        TerraNova.LOGGER.info("Log level set to {}", config.getLogLevel());

        try (TerraNova server = new TerraNova(config)) {
            Runtime.getRuntime().addShutdownHook(server.getThreadFactory().newThread(() -> {
                try {
                    server.close();
                } catch (Exception e) {
                    TerraNova.LOGGER.error("Got exception when closing server", e);
                }
            }, "ShutdownHook"));

            server.start();
        } catch (Exception e) {
            TerraNova.LOGGER.error("An error occurred while starting TerraNova", e);
        }
    }
}
