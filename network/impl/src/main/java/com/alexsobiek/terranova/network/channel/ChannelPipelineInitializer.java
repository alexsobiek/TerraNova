package com.alexsobiek.terranova.network.channel;

import com.alexsobiek.terranova.network.Connection;
import com.alexsobiek.terranova.network.Network;
import com.alexsobiek.terranova.network.protocol.ProtocolConstants;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.net.SocketAddress;
import java.util.Map;

public class ChannelPipelineInitializer extends ChannelInitializer<SocketChannel> {
    private final ChannelHandler channelHandler;

    public ChannelPipelineInitializer(Map<SocketAddress, Connection> connections) {
        channelHandler = new ChannelHandler(connections);
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        Network.getLogger().debug("Initializing pipeline for new connection {}", ch.remoteAddress());

        ch.pipeline()
                .addFirst(Channel.CHANNEL_HANDLER, channelHandler)
                .addFirst(Channel.READ_TIME_OUT, new ReadTimeoutHandler(ProtocolConstants.READ_TIME_OUT));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Network.getLogger().error("Exception caught in pipeline", cause);
        ctx.close();
    }
}
