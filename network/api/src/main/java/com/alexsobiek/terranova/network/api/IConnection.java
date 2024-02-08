package com.alexsobiek.terranova.network.api;

import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;

import java.net.SocketAddress;

public interface IConnection extends AutoCloseable {
    boolean isActive();

    SocketAddress getAddress();

    void read(IncomingPacket packet) throws PacketReadException;

    void write(OutgoingPacket packet) throws PacketWriteException;

    void handleException(Throwable e);

    void disconnect(String reason);

    default void disconnect() {
        disconnect("Disconnected");
    }
}
