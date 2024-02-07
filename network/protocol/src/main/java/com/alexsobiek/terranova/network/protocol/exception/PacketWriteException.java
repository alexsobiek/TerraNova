package com.alexsobiek.terranova.network.protocol.exception;

public class PacketWriteException extends PacketException {
    public PacketWriteException() {
    }

    public PacketWriteException(String message) {
        super(message);
    }

    public PacketWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacketWriteException(Throwable cause) {
        super(cause);
    }

    public PacketWriteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}