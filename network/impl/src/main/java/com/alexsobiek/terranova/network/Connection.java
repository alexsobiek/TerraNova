package com.alexsobiek.terranova.network;

import com.alexsobiek.terranova.network.api.IConnection;
import com.alexsobiek.terranova.network.channel.Channel;
import com.alexsobiek.terranova.network.codec.HandshakeCodec;
import com.alexsobiek.terranova.network.codec.PacketHandlerCodec;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;
import com.alexsobiek.terranova.network.protocol.exception.PacketWriteException;
import com.alexsobiek.terranova.network.protocol.packet.bi.PacketBiDisconnect;
import com.alexsobiek.terranova.network.protocol.packet.bi.PacketBiKeepAlive;
import com.alexsobiek.terranova.network.protocol.packet.in.IncomingPacket;
import com.alexsobiek.terranova.network.protocol.packet.out.OutgoingPacket;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketAddress;

@RequiredArgsConstructor
public class Connection implements IConnection {

    @Getter
    private final ChannelHandlerContext context;
    @Getter
    private boolean active = false;

    public void open() {
        if (this.active) {
            handleException(new IllegalStateException("Connection is already active"));
            return;
        }

        this.active = true;

        context.pipeline()
                .addBefore(Channel.CHANNEL_HANDLER, Channel.PACKET_HANDLER, new PacketHandlerCodec(this))
                .addBefore(Channel.PACKET_HANDLER, Channel.HANDSHAKE_CODEC, new HandshakeCodec(this));
    }

    @Override
    public SocketAddress getAddress() {
        return this.context.channel().remoteAddress();
    }

    @Override
    public void read(IncomingPacket packet) throws PacketReadException {

    }

    @Override
    public void write(OutgoingPacket packet) throws PacketWriteException {
        if (isActive()) {
            context.writeAndFlush(packet).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);

            if (packet instanceof PacketBiDisconnect) {
                try {
                    this.close();
                } catch (Exception e) {
                    throw new PacketWriteException("Failed to close connection", e);
                }
            }
        }
    }

    public void sendKeepAlive() {
        try {
            this.write(new PacketBiKeepAlive());
        } catch (PacketWriteException e) {
            this.handleException(e);
        }
    }

    @Override
    public void disconnect(String reason) {
        try {
            this.write(new PacketBiDisconnect(reason));
        } catch (PacketWriteException e) {
            this.handleException(e); // FIXME: this might cause a loop if handleException calls disconnect on exception
        }
    }

    @Override
    public void handleException(Throwable cause) {
        if (cause instanceof EncoderException ee) cause = ee.getCause();
        else if (cause instanceof InvocationTargetException ite) cause = ite.getCause();

        Network.getLogger().error("Exception caught in connection {}", getAddress(), cause);
        this.disconnect("Internal server error"); // TODO: maybe be more descriptive to the client?
    }

    @Override
    public void close() throws Exception {
        if (isActive() || context.channel().isActive()) {
            // TODO: this.packetHandler.close();
            Network.getLogger().debug("Closing connection {}", getAddress());
            if (context.channel().isActive()) {
                Network.getLogger().debug("Closing channel {}", getAddress());
                ChannelFuture future = context.close().sync();
                if (!future.isSuccess()) this.handleException(future.cause());
            }
            Network.getLogger().info("Closed connection {}", getAddress());
            this.active = false;
        }
    }
}
