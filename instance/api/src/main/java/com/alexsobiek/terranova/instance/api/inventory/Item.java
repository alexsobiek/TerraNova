package com.alexsobiek.terranova.instance.api.inventory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Item {
    AIR((short) -1, (byte) 0, (byte) 0),
    STONE((short) 1, (byte) 0, (byte) 64),
    GRASS((short) 2, (byte) 0, (byte) 64),
    DIRT((short) 3, (byte) 0, (byte) 64),
    COBBLESTONE((short) 4, (byte) 0, (byte) 64),
    OAK_PLANKS((short) 5, (byte) 0, (byte) 64),
    OAK_SAPLING((short) 6, (byte) 0, (byte) 64),
    SPRUCE_SAPLING((short) 6, (byte) 1, (byte) 64),
    BIRCH_SAPLING((short) 6, (byte) 2, (byte) 64),
    BEDROCK((short) 7, (byte) 0, (byte) 64),
    FLOWING_WATER((short) 8, (byte) 0, (byte) 64),
    STILL_WATER((short) 9, (byte) 0, (byte) 64),
    FLOWING_LAVA((short) 10, (byte) 0, (byte) 64),
    STILL_LAVA((short) 11, (byte) 0, (byte) 64),
    SAND((short) 12, (byte) 0, (byte) 64),
    GRAVEL((short) 13, (byte) 0, (byte) 64),
    GOLD_ORE((short) 14, (byte) 0, (byte) 64),
    IRON_ORE((short) 15, (byte) 0, (byte) 64),
    COAL_ORE((short) 16, (byte) 0, (byte) 64),
    OAK_LOG((short) 17, (byte) 0, (byte) 64),
    SPRUCE_LOG((short) 17, (byte) 1, (byte) 64),
    BIRCH_LOG((short) 17, (byte) 2, (byte) 64),
    OAK_LEAVES((short) 18, (byte) 0, (byte) 64),
    SPRUCE_LEAVES((short) 18, (byte) 1, (byte) 64),
    BIRCH_LEAVES((short) 18, (byte) 2, (byte) 64),
    SPONGE((short) 19, (byte) 0, (byte) 64),
    GLASS((short) 20, (byte) 0, (byte) 64),
    LAPIS_LAZULI_ORE((short) 21, (byte) 0, (byte) 64),
    LAPIS_LAZULI_BLOCK((short) 22, (byte) 0, (byte) 64),
    DISPENSER((short) 23, (byte) 0, (byte) 64),
    SANDSTONE((short) 24, (byte) 0, (byte) 64),
    NOTE_BLOCK((short) 25, (byte) 0, (byte) 64),
    BED_BLOCK((short) 26, (byte) 0, (byte) 64),
    POWERED_RAIL((short) 27, (byte) 0, (byte) 64),
    DETECTOR_RAIL((short) 28, (byte) 0, (byte) 64),
    STICKY_PISTON((short) 29, (byte) 0, (byte) 64),
    COBWEB((short) 30, (byte) 0, (byte) 64),
    DEAD_SHRUB((short) 31, (byte) 0, (byte) 64),
    TALL_GRASS((short) 31, (byte) 1, (byte) 64),
    FERN((short) 31, (byte) 2, (byte) 64),
    DEAD_BUSH((short) 32, (byte) 0, (byte) 64),
    PISTON((short) 33, (byte) 0, (byte) 64),
    PISTON_HEAD((short) 34, (byte) 0, (byte) 64),
    WHITE_WOOL((short) 35, (byte) 0, (byte) 64),
    ORANGE_WOOL((short) 35, (byte) 1, (byte) 64),
    MAGENTA_WOOL((short) 35, (byte) 2, (byte) 64),
    LIGHT_BLUE_WOOL((short) 35, (byte) 3, (byte) 64),
    YELLOW_WOOL((short) 35, (byte) 4, (byte) 64),
    LIME_WOOL((short) 35, (byte) 5, (byte) 64),
    PINK_WOOL((short) 35, (byte) 6, (byte) 64),
    GRAY_WOOL((short) 35, (byte) 7, (byte) 64),
    LIGHT_GRAY_WOOL((short) 35, (byte) 8, (byte) 64),
    CYAN_WOOL((short) 35, (byte) 9, (byte) 64),
    PURPLE_WOOL((short) 35, (byte) 10, (byte) 64),
    BLUE_WOOL((short) 35, (byte) 11, (byte) 64),
    BROWN_WOOL((short) 35, (byte) 12, (byte) 64),
    GREEN_WOOL((short) 35, (byte) 13, (byte) 64),
    RED_WOOL((short) 35, (byte) 14, (byte) 64),
    BLACK_WOOL((short) 35, (byte) 15, (byte) 64),
    DANDELION((short) 37, (byte) 0, (byte) 64),
    POPPY((short) 38, (byte) 0, (byte) 64),
    BROWN_MUSHROOM((short) 39, (byte) 0, (byte) 64),
    RED_MUSHROOM((short) 40, (byte) 0, (byte) 64),
    GOLD_BLOCK((short) 41, (byte) 0, (byte) 64),
    IRON_BLOCK((short) 42, (byte) 0, (byte) 64),
    DOUBLE_STONE_SLAB((short) 43, (byte) 0, (byte) 64),
    DOUBLE_SANDSTONE_SLAB((short) 43, (byte) 1, (byte) 64),
    DOUBLE_WOODEN_SLAB((short) 43, (byte) 2, (byte) 64),
    DOUBLE_COBBLESTONE_SLAB((short) 43, (byte) 3, (byte) 64),
    STONE_SLAB((short) 44, (byte) 0, (byte) 64),
    SANDSTONE_SLAB((short) 44, (byte) 1, (byte) 64),
    WOODEN_SLAB((short) 44, (byte) 2, (byte) 64),
    COBBLESTONE_SLAB((short) 44, (byte) 3, (byte) 64),
    BRICKS((short) 45, (byte) 0, (byte) 64),
    TNT((short) 46, (byte) 0, (byte) 64),
    BOOKSHELF((short) 47, (byte) 0, (byte) 64),
    MOSS_STONE((short) 48, (byte) 0, (byte) 64),
    OBSIDIAN((short) 49, (byte) 0, (byte) 64),
    TORCH((short) 50, (byte) 0, (byte) 64),
    FIRE((short) 51, (byte) 0, (byte) 64),
    MONSTER_SPAWNER((short) 52, (byte) 0, (byte) 64),
    OAK_WOOD_STAIRS((short) 53, (byte) 0, (byte) 64),
    CHEST((short) 54, (byte) 0, (byte) 64),
    REDSTONE_WIRE((short) 55, (byte) 0, (byte) 64),
    DIAMOND_ORE((short) 56, (byte) 0, (byte) 64),
    DIAMOND_BLOCK((short) 57, (byte) 0, (byte) 64),
    CRAFTING_TABLE((short) 58, (byte) 0, (byte) 64),
    GROWING_WHEAT((short) 59, (byte) 0, (byte) 64),
    FARMLAND((short) 60, (byte) 0, (byte) 64),
    FURNACE((short) 61, (byte) 0, (byte) 64),
    BURNING_FURNACE((short) 62, (byte) 0, (byte) 64),
    STANDING_SIGN_BLOCK((short) 63, (byte) 0, (byte) 64),
    OAK_DOOR_BLOCK((short) 64, (byte) 0, (byte) 64),
    LADDER((short) 65, (byte) 0, (byte) 64),
    RAIL((short) 66, (byte) 0, (byte) 64),
    COBBLESTONE_STAIRS((short) 67, (byte) 0, (byte) 64),
    WALL_MOUNTED_SIGN_BLOCK((short) 68, (byte) 0, (byte) 64),
    LEVER((short) 69, (byte) 0, (byte) 64),
    STONE_PRESSURE_PLATE((short) 70, (byte) 0, (byte) 64),
    IRON_DOOR_BLOCK((short) 71, (byte) 0, (byte) 64),
    WOODEN_PRESSURE_PLATE((short) 72, (byte) 0, (byte) 64),
    REDSTONE_ORE((short) 73, (byte) 0, (byte) 64),
    GLOWING_REDSTONE_ORE((short) 74, (byte) 0, (byte) 64),
    REDSTONE_TORCH_OFF((short) 75, (byte) 0, (byte) 64),
    REDSTONE_TORCH_ON((short) 76, (byte) 0, (byte) 64),
    STONE_BUTTON((short) 77, (byte) 0, (byte) 64),
    SNOW_LAYER((short) 78, (byte) 0, (byte) 64),
    ICE((short) 79, (byte) 0, (byte) 64),
    SNOW((short) 80, (byte) 0, (byte) 64),
    CACTUS((short) 81, (byte) 0, (byte) 64),
    CLAY_BLOCK((short) 82, (byte) 0, (byte) 64),
    GROWING_SUGAR_CANE((short) 83, (byte) 0, (byte) 64),
    JUKEBOX((short) 84, (byte) 0, (byte) 64),
    OAK_FENCE((short) 85, (byte) 0, (byte) 64),
    PUMPKIN((short) 86, (byte) 0, (byte) 64),
    NETHERRACK((short) 87, (byte) 0, (byte) 64),
    SOUL_SAND((short) 88, (byte) 0, (byte) 64),
    GLOWSTONE((short) 89, (byte) 0, (byte) 64),
    NETHER_PORTAL((short) 90, (byte) 0, (byte) 64),
    JACK_O_LANTERN((short) 91, (byte) 0, (byte) 64),
    CAKE_BLOCK((short) 92, (byte) 0, (byte) 64),
    REDSTONE_REPEATER_BLOCK_OFF((short) 93, (byte) 0, (byte) 64), // NOT SURE IF THIS IS CORRECT
    REDSTONE_REPEATER_BLOCK_ON((short) 94, (byte) 0, (byte) 64), // NOT SURE IF THIS IS CORRECT
    // CHEST((short) 95, (byte) 0, (byte) 64),
    OAK_TRAPDOOR((short) 96, (byte) 0, (byte) 64),
    IRON_SHOVEL((short) 256, (byte) 0, (byte) 1),
    IRON_PICKAXE((short) 257, (byte) 0, (byte) 1),
    IRON_AXE((short) 258, (byte) 0, (byte) 1),
    FLINT_AND_STEEL((short) 259, (byte) 0, (byte) 1),
    APPLE((short) 260, (byte) 0, (byte) 64),
    BOW((short) 261, (byte) 0, (byte) 1),
    ARROW((short) 262, (byte) 0, (byte) 64),
    COAL((short) 263, (byte) 0, (byte) 64),
    DIAMOND((short) 264, (byte) 0, (byte) 64),
    IRON_INGOT((short) 265, (byte) 0, (byte) 64),
    GOLD_INGOT((short) 266, (byte) 0, (byte) 64),
    IRON_SWORD((short) 267, (byte) 0, (byte) 1),
    WOODEN_SWORD((short) 268, (byte) 0, (byte) 1),
    WOODEN_SHOVEL((short) 269, (byte) 0, (byte) 1),
    WOODEN_PICKAXE((short) 270, (byte) 0, (byte) 1),
    WOODEN_AXE((short) 271, (byte) 0, (byte) 1),
    STONE_SWORD((short) 272, (byte) 0, (byte) 1),
    STONE_SHOVEL((short) 273, (byte) 0, (byte) 1),
    STONE_PICKAXE((short) 274, (byte) 0, (byte) 1),
    STONE_AXE((short) 275, (byte) 0, (byte) 1),
    DIAMOND_SWORD((short) 276, (byte) 0, (byte) 1),
    DIAMOND_SHOVEL((short) 277, (byte) 0, (byte) 1),
    DIAMOND_PICKAXE((short) 278, (byte) 0, (byte) 1),
    DIAMOND_AXE((short) 279, (byte) 0, (byte) 1),
    STICK((short) 280, (byte) 0, (byte) 64),
    BOWL((short) 281, (byte) 0, (byte) 64),
    MUSHROOM_STEW((short) 282, (byte) 0, (byte) 1),
    GOLDEN_SWORD((short) 283, (byte) 0, (byte) 1),
    GOLDEN_SHOVEL((short) 284, (byte) 0, (byte) 1),
    GOLDEN_PICKAXE((short) 285, (byte) 0, (byte) 1),
    GOLDEN_AXE((short) 286, (byte) 0, (byte) 1),
    STRING((short) 287, (byte) 0, (byte) 64),
    FEATHER((short) 288, (byte) 0, (byte) 64),
    GUNPOWDER((short) 289, (byte) 0, (byte) 64),
    WOODEN_HOE((short) 290, (byte) 0, (byte) 1),
    STONE_HOE((short) 291, (byte) 0, (byte) 1),
    IRON_HOE((short) 292, (byte) 0, (byte) 1),
    DIAMOND_HOE((short) 293, (byte) 0, (byte) 1),
    GOLDEN_HOE((short) 294, (byte) 0, (byte) 1),
    WHEAT_SEEDS((short) 295, (byte) 0, (byte) 64),
    WHEAT((short) 296, (byte) 0, (byte) 64),
    BREAD((short) 297, (byte) 0, (byte) 64),
    LEATHER_CAP((short) 298, (byte) 0, (byte) 1),
    LEATHER_TUNIC((short) 299, (byte) 0, (byte) 1),
    LEATHER_PANTS((short) 300, (byte) 0, (byte) 1),
    LEATHER_BOOTS((short) 301, (byte) 0, (byte) 1),
    CHAIN_HELMET((short) 302, (byte) 0, (byte) 1),
    CHAIN_CHESTPLATE((short) 303, (byte) 0, (byte) 1),
    CHAIN_LEGGINGS((short) 304, (byte) 0, (byte) 1),
    CHAIN_BOOTS((short) 305, (byte) 0, (byte) 1),
    IRON_HELMET((short) 306, (byte) 0, (byte) 1),
    IRON_CHESTPLATE((short) 307, (byte) 0, (byte) 1),
    IRON_LEGGINGS((short) 308, (byte) 0, (byte) 1),
    IRON_BOOTS((short) 309, (byte) 0, (byte) 1),
    DIAMOND_HELMET((short) 310, (byte) 0, (byte) 1),
    DIAMOND_CHESTPLATE((short) 311, (byte) 0, (byte) 1),
    DIAMOND_LEGGINGS((short) 312, (byte) 0, (byte) 1),
    DIAMOND_BOOTS((short) 313, (byte) 0, (byte) 1),
    GOLDEN_HELMET((short) 314, (byte) 0, (byte) 1),
    GOLDEN_CHESTPLATE((short) 315, (byte) 0, (byte) 1),
    GOLDEN_LEGGINGS((short) 316, (byte) 0, (byte) 1),
    GOLDEN_BOOTS((short) 317, (byte) 0, (byte) 1),
    FLINT((short) 318, (byte) 0, (byte) 64),
    RAW_PORKCHOP((short) 319, (byte) 0, (byte) 64),
    COOKED_PORKCHOP((short) 320, (byte) 0, (byte) 64),
    PAINTING((short) 321, (byte) 0, (byte) 64),
    GOLDEN_APPLE((short) 322, (byte) 0, (byte) 64),
    SIGN((short) 323, (byte) 0, (byte) 16),
    OAK_DOOR((short) 324, (byte) 0, (byte) 64),
    BUCKET((short) 325, (byte) 0, (byte) 16),
    WATER_BUCKET((short) 326, (byte) 0, (byte) 1),
    LAVA_BUCKET((short) 327, (byte) 0, (byte) 1),
    MINECART((short) 328, (byte) 0, (byte) 1),
    SADDLE((short) 329, (byte) 0, (byte) 1),
    IRON_DOOR((short) 330, (byte) 0, (byte) 64),
    REDSTONE((short) 331, (byte) 0, (byte) 64),
    SNOWBALL((short) 332, (byte) 0, (byte) 16),
    BOAT((short) 333, (byte) 0, (byte) 1),
    LEATHER((short) 334, (byte) 0, (byte) 64),
    MILK_BUCKET((short) 335, (byte) 0, (byte) 1),
    BRICK((short) 336, (byte) 0, (byte) 64),
    CLAY((short) 337, (byte) 0, (byte) 64),
    SUGAR_CANE((short) 338, (byte) 0, (byte) 64),
    PAPER((short) 339, (byte) 0, (byte) 64),
    BOOK((short) 340, (byte) 0, (byte) 64),
    SLIMEBALL((short) 341, (byte) 0, (byte) 64),
    MINECART_WITH_CHEST((short) 342, (byte) 0, (byte) 1),
    MINECART_WITH_FURNACE((short) 343, (byte) 0, (byte) 1),
    EGG((short) 344, (byte) 0, (byte) 16),
    COMPASS((short) 345, (byte) 0, (byte) 1),
    FISHING_ROD((short) 346, (byte) 0, (byte) 1),
    CLOCK((short) 347, (byte) 0, (byte) 1),
    GLOWSTONE_DUST((short) 348, (byte) 0, (byte) 64),
    RAW_FISH((short) 349, (byte) 0, (byte) 64),
    COOKED_FISH((short) 350, (byte) 0, (byte) 64),
    DYE((short) 351, (byte) 0, (byte) 64),
    RED_DYE((short) 351, (byte) 1, (byte) 64),
    GREEN_DYE((short) 351, (byte) 2, (byte) 64),
    COCOA_BEANS((short) 351, (byte) 3, (byte) 64),
    LAPIS_LAZULI((short) 351, (byte) 4, (byte) 64),
    PURPLE_DYE((short) 351, (byte) 5, (byte) 64),
    CYAN_DYE((short) 351, (byte) 6, (byte) 64),
    LIGHT_GRAY_DYE((short) 351, (byte) 7, (byte) 64),
    GRAY_DYE((short) 351, (byte) 8, (byte) 64),
    PINK_DYE((short) 351, (byte) 9, (byte) 64),
    LIME_DYE((short) 351, (byte) 10, (byte) 64),
    YELLOW_DYE((short) 351, (byte) 11, (byte) 64),
    LIGHT_BLUE_DYE((short) 351, (byte) 12, (byte) 64),
    MAGENTA_DYE((short) 351, (byte) 13, (byte) 64),
    ORANGE_DYE((short) 351, (byte) 14, (byte) 64),
    BONE_MEAL((short) 351, (byte) 15, (byte) 64),
    BONE((short) 352, (byte) 0, (byte) 64),
    SUGAR((short) 353, (byte) 0, (byte) 64),
    CAKE((short) 354, (byte) 0, (byte) 1),
    BED((short) 355, (byte) 0, (byte) 1),
    REDSTONE_REPEATER((short) 356, (byte) 0, (byte) 64),
    COOKIE((short) 357, (byte) 0, (byte) 64),
    MAP((short) 358, (byte) 0, (byte) 1),
    SHEARS((short) 359, (byte) 0, (byte) 1),
    DISC_13((short) 2256, (byte) 0, (byte) 1),
    DISC_CAT((short) 2257, (byte) 0, (byte) 1);

    private final short id;
    private final byte data;
    private final byte maxStack;

    private final static Map<Short, Item> byId;

    static {
        Item[] values = values();
        byId = new HashMap<Short, Item>(values.length);
        for (Item item : values) byId.put(item.getId(), item);
    }

    public static Item getById(short id) {
        return byId.get(id);
    }
}