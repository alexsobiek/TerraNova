package com.alexsobiek.terranova.network.protocol.packet;

import com.alexsobiek.terranova.network.protocol.packet.in.*;
import com.alexsobiek.terranova.network.protocol.packet.out.*;
import com.alexsobiek.terranova.network.protocol.packet.bi.*;

import java.util.HashMap;
import java.util.Map;

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
        // TODO: registerIncoming((byte) 0x0F, PacketInPlace.class);
        // TODO: registerIncoming((byte) 0x10, PacketInHeldItem.class);
        // TODO: registerIncoming((byte) 0x12, PacketBiAnimation.class);
        registerIncoming((byte) 0x13, PacketInEntityAction.class);
        // TODO: registerIncoming((byte) 0x1C, PacketBiEntityVelocity.class);
        // TODO: registerIncoming((byte) 0x27, PacketBiAttachEntity.class);
        // TODO: registerIncoming((byte) 0x28, PacketBiEntityMetadata.class);   // This might only be outgoing
        // TODO: registerIncoming((byte) 0x46, PacketBiNewInvalidState.class);  // ???
        // TODO: registerIncoming((byte) 0x65, PacketInCloseWindow.class);
        // TODO: registerIncoming((byte) 0x66, PacketInWindowClick.class);
        // TODO: registerIncoming((0x6A, PacketBiTransaction.class);
        // TODO: registerIncoming((0x82, PacketBiUpdateSign.class);
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
        // TODO: registerOutgoing((byte) 0x11, PacketOutUseBed.class);
        registerOutgoing((byte) 0x12, PacketOutEntityAnimation.class);          // TODO: this is bi-directional
        registerOutgoing((byte) 0x14, PacketOutSpawnPlayer.class);
        // TODO: registerOutgoing((byte) 0x15, PacketOutSpawnItem.class);
        // TODO: registerOutgoing((byte) 0x16, PacketOutCollectItem.class);
        // TODO: registerOutgoing((byte) 0x17, PacketOutSpawnObject.class);
        // TODO: registerOutgoing((byte) 0x18, PacketOutSpawnMob.class);
        // TODO: registerOutgoing((byte) 0x19, PacketOutSpawnPainting.class);   // This might be bi-directional
        // TODO: registerOutgoing((byte) 0x1C, PacketBiEntityVelocity.class);
        registerOutgoing((byte) 0x1D, PacketOutDestroyEntity.class);
        // TODO: registerOutgoing((byte) 0x1E, PacketOutEntity.class);          // ???
        registerOutgoing((byte) 0x1F, PacketOutEntityRelativeMove.class);
        registerOutgoing((byte) 0x20, PacketOutEntityLook.class);
        // TODO: registerOutgoing((byte) 0x21, PacketOutEntityLookAndRelativeMove.class);
        // TODO: registerOutgoing((byte) 0x22, PacketOutEntityTeleport.class);
        // TODO: registerOutgoing((byte) 0x26, PacketOutEntityStatus.class);    // ???
        // TODO: registerOutgoing((byte) 0x27, PacketBiAttachEntity.class);
        // TODO: registerOutgoing((byte) 0x28, PacketBiEntityMetadata.class);   // This might only be outgoing
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
        // TODO: registerOutgoing((byte) 0x67, PacketOutSetSlot.class);
        registerOutgoing((byte) 0x68, PacketOutWindowItems.class);
        // TODO: registerOutgoing((0x69, PacketOutUpdateProgressBar.class);
        // TODO: registerOutgoing((0x6A, PacketBiTransaction.class);
        // TODO: registerOutgoing((0x82, PacketBiUpdateSign.class);
        // TODO: registerOutgoing((0x83, PacketOutItemData.class);
        // TODO: registerOutgoing((0xC8, PacketOutIncrementStatistic.class);



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