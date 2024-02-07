package com.alexsobiek.terranova.network.protocol.packet;

import com.alexsobiek.terranova.network.protocol.packet.in.*;
import com.alexsobiek.terranova.network.protocol.packet.out.*;
import com.alexsobiek.terranova.network.protocol.packet.bi.*;

import java.util.HashMap;
import java.util.Map;

// Protocol documentation: https://wiki.vg/index.php?title=Protocol&oldid=510
public class PacketRegistry {
    private static final Map<Byte, Class<? extends OutgoingPacket>> outgoingById = new HashMap<>();
    private static final Map<Class<? extends OutgoingPacket>, Byte> outgoingByClass = new HashMap<>();

    private static final Map<Byte, Class<? extends IncomingPacket>> incomingById = new HashMap<>();
    private static final Map<Class<? extends IncomingPacket>, Byte> incomingByClass = new HashMap<>();

    static {
        // Incoming Packets
        registerIncoming((byte) 0x00, PacketBiKeepAlive.class);
        registerIncoming((byte) 0x01, PacketInLogin.class);
        registerIncoming((byte) 0x02, PacketBiHandshake.class);
        registerIncoming((byte) 0x07, PacketInClickEntity.class);
        registerIncoming((byte) 0x09, PacketBiRespawn.class);
        registerIncoming((byte) 0x0A, PacketInFlying.class);
        registerIncoming((byte) 0x0B, PacketInPosition.class);
        registerIncoming((byte) 0x0C, PacketInLook.class);
        registerIncoming((byte) 0x0D, PacketBiLookPosition.class);
        registerIncoming((byte) 0x0E, PacketInMine.class);
        registerIncoming((byte) 0x0F, PacketInPlaceBlock.class);
        registerIncoming((byte) 0x10, PacketInHeldItem.class);
        registerIncoming((byte) 0x12, PacketBiEntityAnimation.class);
        registerIncoming((byte) 0x13, PacketInEntityAction.class);
        registerIncoming((byte) 0x1C, PacketBiEntityVelocity.class);
        // TODO: registerIncoming((byte) 0x46, PacketBiNewInvalidState.class);  // ???
        // TODO: registerIncoming((byte) 0x65, PacketInCloseWindow.class);
        // TODO: registerIncoming((byte) 0x66, PacketInWindowClick.class);
        registerIncoming((byte) 0x6A, PacketBiTransaction.class);
        registerIncoming((byte) 0x82, PacketBiUpdateSign.class);
        registerIncoming((byte) 0xFF, PacketBiDisconnect.class);

        // Outgoing Packets
        registerOutgoing((byte) 0x00, PacketBiKeepAlive.class);
        registerOutgoing((byte) 0x01, PacketOutLogin.class);
        registerOutgoing((byte) 0x02, PacketBiHandshake.class);
        registerOutgoing((byte) 0x03, PacketOutChat.class);
        registerOutgoing((byte) 0x04, PacketOutSetTime.class);
        registerOutgoing((byte) 0x05, PacketOutEntityInventory.class);
        registerOutgoing((byte) 0x06, PacketOutSetSpawn.class);
        registerOutgoing((byte) 0x08, PacketOutSetHealth.class);
        registerOutgoing((byte) 0x09, PacketBiRespawn.class);
        registerOutgoing((byte) 0x0D, PacketBiLookPosition.class);
        registerOutgoing((byte) 0x11, PacketOutUseBed.class);
        registerOutgoing((byte) 0x12, PacketBiEntityAnimation.class);
        registerOutgoing((byte) 0x14, PacketOutSpawnPlayer.class);
        registerOutgoing((byte) 0x15, PacketOutSpawnItem.class);
        registerOutgoing((byte) 0x16, PacketOutCollectItem.class);
        registerOutgoing((byte) 0x17, PacketOutSpawnObject.class);
        registerOutgoing((byte) 0x18, PacketOutSpawnMob.class);
        registerOutgoing((byte) 0x19, PacketOutPainting.class);   // This might be bi-directional
        registerOutgoing((byte) 0x1C, PacketBiEntityVelocity.class);
        registerOutgoing((byte) 0x1D, PacketOutDestroyEntity.class);
        // TODO: registerOutgoing((byte) 0x1E, PacketOutEntity.class);          // ??? - not used
        registerOutgoing((byte) 0x1F, PacketOutEntityRelativeMove.class);
        registerOutgoing((byte) 0x20, PacketOutEntityLook.class);
        registerOutgoing((byte) 0x21, PacketOutEntityLookAndRelativeMove.class);
        registerOutgoing((byte) 0x22, PacketOutEntityTeleport.class);
        registerOutgoing((byte) 0x26, PacketOutEntityStatus.class);             // ??? - not fully understood
        registerOutgoing((byte) 0x27, PacketOutAttachEntity.class);             // This might be bi-directional
        registerOutgoing((byte) 0x28, PacketOutEntityMetadata.class);
        registerOutgoing((byte) 0x32, PacketOutPreChunk.class);
        registerOutgoing((byte) 0x33, PacketOutChunk.class);
        // TODO: registerOutgoing((byte) 0x34, PacketOutMultiBlockChange.class);// This might be bi-directional
        // TODO: registerOutgoing((byte) 0x35, PacketOutBlockChange.class);     // This might be bi-directional
        // TODO: registerOutgoing((byte) 0x36, PacketOutBlockAction.class);     // Sent on note block or piston state change
        // TODO: registerOutgoing((byte) 0x3C, PacketOutExplosion.class);
        // TODO: registerOutgoing((byte) 0x3D, PacketOutSoundEffect.class);
        // TODO: registerOutgoing((byte) 0x46, PacketBiNewInvalidState.class);  // ???
        // TODO: registerOutgoing((byte) 0x47, PacketOutThunderbolt.class);
        // TODO: registerOutgoing((byte) 0x64, PacketOutOpenWindow.class);
        registerOutgoing((byte) 0x67, PacketOutSetSlot.class);
        registerOutgoing((byte) 0x68, PacketOutWindowItems.class);
        registerOutgoing((byte) 0x69, PacketOutUpdateProgressBar.class);
        registerOutgoing((byte) 0x6A, PacketBiTransaction.class);
        registerOutgoing((byte) 0x82, PacketBiUpdateSign.class);
        registerOutgoing((byte) 0x83, PacketOutItemData.class);
        registerOutgoing((byte) 0xC8, PacketOutIncrementStatistic.class);



        registerOutgoing((byte) 0xFF, PacketBiDisconnect.class);
    }

    private static void registerOutgoing(byte id, Class<? extends OutgoingPacket> clazz) {
        outgoingById.put(id, clazz);
        outgoingByClass.put(clazz, id);
    }

    private static void registerIncoming(byte id, Class<? extends IncomingPacket> clazz) {
        incomingById.put(id, clazz);
        incomingByClass.put(clazz, id);
    }

    public static byte getOutgoingId(Class<? extends OutgoingPacket> clazz) {
        return outgoingByClass.get(clazz);
    }

    public static Class<? extends OutgoingPacket> getOutgoingClass(byte id) {
        return outgoingById.get(id);
    }

    public static byte getIncomingId(Class<? extends IncomingPacket> clazz) {
        return incomingByClass.get(clazz);
    }

    public static Class<? extends IncomingPacket> getIncomingClass(byte id) {
        return incomingById.get(id);
    }

    public static String getHexString(byte id) {
        return String.format("0x%02X", id);
    }

    @SuppressWarnings("unchecked")
    public static String getHexString(Class<? extends Packet> clazz) {
        if (IncomingPacket.class.isAssignableFrom(clazz))
            return getHexString(getIncomingId((Class<? extends IncomingPacket>) clazz));
        else if (OutgoingPacket.class.isAssignableFrom(clazz))
            return getHexString(getOutgoingId((Class<? extends OutgoingPacket>) clazz));
        else throw new IllegalArgumentException("Class must be assignable from IncomingPacket or OutgoingPacket");
    }
}