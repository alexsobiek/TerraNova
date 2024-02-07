package com.alexsobiek.terranova.network.protocol.packet.in;

import com.alexsobiek.terranova.instance.api.world.BlockFace;
import com.alexsobiek.terranova.instance.api.world.MineStatus;
import com.alexsobiek.terranova.network.protocol.buffer.PacketByteBuf;
import com.alexsobiek.terranova.network.protocol.exception.PacketReadException;

public class PacketInMine implements IncomingPacket {
    private MineStatus status;
    private int x;
    private byte y;
    private int z;
    private BlockFace face;


    @Override
    public void read(PacketByteBuf in) throws PacketReadException {
        status = MineStatus.fromId(in.readByte());
        x = in.readInt();
        y = in.readByte();
        z = in.readInt();
        face = BlockFace.fromId(in.readByte());
    }
}
