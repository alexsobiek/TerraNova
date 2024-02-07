package com.alexsobiek.terranova.config;

import ch.qos.logback.classic.Level;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import java.net.InetSocketAddress;

public class ServerConfig {
    private final CommentedFileConfig config;

    public ServerConfig() {
        config = ConfigUtil.getConfig(this.getClass(), ConfigUtil.CONFIG_DIR.toPath().resolve("server.toml").toFile(), "server.toml").orElseThrow(() -> new RuntimeException("Could not load server config"));
    }

    public Level getLogLevel() {
        return Level.valueOf(config.getOrElse("log.level", "INFO"));
    }

    public int getPort() {
        return config.getOrElse("network.port", 25565);
    }

    public String getHost() {
        return config.getOrElse("network.host", "0.0.0.0");
    }

    public InetSocketAddress getSocketAddress() {
        return new InetSocketAddress(getHost(), getPort());
    }
}
