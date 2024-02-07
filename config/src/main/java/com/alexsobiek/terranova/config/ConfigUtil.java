package com.alexsobiek.terranova.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.file.FileNotFoundAction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class ConfigUtil {
    public static final File CONFIG_DIR = new File("config");

    static {
        if (!CONFIG_DIR.exists()) {
            if (!CONFIG_DIR.mkdirs()) {
                throw new RuntimeException("Could not create config directory");
            }
        }
    }

    public static Optional<CommentedFileConfig> getConfig(Class<?> _class, File file, String name) {
        try (InputStream is = _class.getResourceAsStream((name.startsWith("/") ? name : "/" + name))) {
            if (is == null) throw new IOException("Could not find resource: " + name);
            CommentedFileConfig config = CommentedFileConfig.builder(file).onFileNotFound(FileNotFoundAction.copyData(is)).autosave().build();
            config.load();
            is.close();
            return Optional.of(config);
        } catch (IOException e) {
            // TODO: handle this with exception handler
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
