package com.alexsobiek.terranova.network.channel;

import com.alexsobiek.terranova.network.Connection;
import com.alexsobiek.terranova.network.Network;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.net.SocketAddress;
import java.util.Map;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
@io.netty.channel.ChannelHandler.Sharable
public class ChannelHandler extends ChannelDuplexHandler {
    private final Map<SocketAddress, Connection> connections;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        ctx.channel().config().setOption(ChannelOption.TCP_NODELAY, true);
        connections.put(ctx.channel().remoteAddress(), new Connection(ctx));
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        connections.remove(ctx.channel().remoteAddress()).close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        getConnection(ctx).ifPresentOrElse(Connection::open, () -> {
            Network.getLogger().error("Channel {} became active but no connection was found", ctx.channel().remoteAddress());
            try {
                ctx.close().sync();
            } catch (InterruptedException e) {
                Network.getLogger().error("Failed to close channel", e);
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        getConnection(context).ifPresentOrElse(connection -> {
            connection.handleException(cause);
        }, () -> Network.getLogger().error("Unknown channel {} threw exception", context.channel().remoteAddress(), cause));
    }

    private Optional<Connection> getConnection(ChannelHandlerContext ctx) {
        return Optional.ofNullable(connections.get(ctx.channel().remoteAddress()));
    }
}