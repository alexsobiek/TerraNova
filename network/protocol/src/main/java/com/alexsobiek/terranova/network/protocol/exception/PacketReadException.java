package com.alexsobiek.terranova.network.protocol.exception;

public class PacketReadException extends PacketException {
    public PacketReadException() {
    }

    public PacketReadException(String message) {
        super(message);
    }

    public PacketReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacketReadException(Throwable cause) {
        super(cause);
    }

    public PacketReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}