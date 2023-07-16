package net.architects.morestructuresmod.config;

import com.mojang.datafixers.util.Pair;
import net.architects.morestructuresmod.MoreStructuresMod;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int INSANITY_LEVEL;

    public static int MAX_DEPTH;
    public static int MAX_SHIPS;

    public static int MAX_FAT_TOWERS;

    public static int Bridge_Length;

    public static boolean MoreBranches;

    public static boolean MoreLootRooms;
    public static boolean ScaleType;
    public static boolean UpOrDown;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(MoreStructuresMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("Increase Number of Structures", true), "true=will increase the structure count, false=will decrease the structure count.");
        configs.addKeyValuePair(new Pair<>("Scale Type", true), "true=0,1-100 scale, false=0,1-5 scale. WARNING: when false and level is 5 the world will not generate without pregenerator.");
        configs.addKeyValuePair(new Pair<>("Insanity Level", 0), "Higher More Structures. More structures can also mean more lag. 0 will disable the mod.");
//        configs.addKeyValuePair(new Pair<>("Maximum Depth", 8), "Higher means more Junctions");
//        configs.addKeyValuePair(new Pair<>("Maximum Ships", 1), "Best value is 10 to allow for many ships");
//        configs.addKeyValuePair(new Pair<>("Maximum Middle Towers in a stack", 2), "Best Value is 6");
//        configs.addKeyValuePair(new Pair<>("Bridge Lengths choose between: short, medium, long", "short"), "Best for large cities is medium");
//        configs.addKeyValuePair(new Pair<>("Prioratize Branching. setting this to true will make more branches occur. can cause more overlap. Best is true", false), "");
//        configs.addKeyValuePair(new Pair<>("More Loot Rooms. this will make more 3 layer buildings spawn. this will also make the cities much taller. Best is true", false), "");
//
    }

    private static void assignConfigs() {


        INSANITY_LEVEL = CONFIG.getOrDefault("Insanity Level", 0);
        ScaleType = CONFIG.getOrDefault("Scale Type", true);
        UpOrDown = CONFIG.getOrDefault("Increase Number of Structures", true);
//
//        MAX_DEPTH_PRE = CONFIG.getOrDefault("Maximum Depth", 8);
//
//        MAX_SHIPS = CONFIG.getOrDefault("Maximum Ships", 1);
//
//        MAX_FAT_TOWERS = CONFIG.getOrDefault("Maximum Middle Towers in a stack", 8);
//
//        String bridge_Length_String = CONFIG.getOrDefault("Bridge Lengths choose between: short, medium, long", "short");
//
//        MoreBranches = CONFIG.getOrDefault("Prioratize Branching. setting this to true will make more branches occur. can cause more overlap", false);
//
//        MoreLootRooms = CONFIG.getOrDefault("More Loot Rooms. this will make more 3 layer buildings spawn. this will also make the cities much taller", false);



        if(INSANITY_LEVEL < 0) {
            INSANITY_LEVEL = 0;
        }

        if (ScaleType) {
            if(INSANITY_LEVEL > 0 && INSANITY_LEVEL <= 4) {
                Bridge_Length = 4;
            } else if (INSANITY_LEVEL > 4 && INSANITY_LEVEL <= 8) {
                Bridge_Length = 6;
            } else if (INSANITY_LEVEL > 8 && INSANITY_LEVEL <= 12) {
                Bridge_Length = 8;
            } else if (INSANITY_LEVEL > 12 && INSANITY_LEVEL <= 16) {
                Bridge_Length = 10;
            } else {
                Bridge_Length = 12;
            }
            if(INSANITY_LEVEL > 0 && INSANITY_LEVEL <= 4) {
                MAX_DEPTH = 8;
            } else if (INSANITY_LEVEL > 4 && INSANITY_LEVEL <= 8) {
                MAX_DEPTH = 9;
            } else if (INSANITY_LEVEL > 8 && INSANITY_LEVEL <= 12) {
                MAX_DEPTH = 10;
            } else if (INSANITY_LEVEL > 12 && INSANITY_LEVEL <= 16) {
                MAX_DEPTH = 11;
            } else {
                MAX_DEPTH = 12;
            }
            if(INSANITY_LEVEL > 0 && INSANITY_LEVEL <= 4) {
                MAX_SHIPS = 2;
            } else if (INSANITY_LEVEL > 4 && INSANITY_LEVEL <= 8) {
                MAX_SHIPS = 3;
            } else if (INSANITY_LEVEL > 8 && INSANITY_LEVEL <= 12) {
                MAX_SHIPS = 5;
            } else if (INSANITY_LEVEL > 12 && INSANITY_LEVEL <= 16) {
                MAX_SHIPS = 7;
            } else {
                MAX_SHIPS = 10;
            }
            if(INSANITY_LEVEL > 0 && INSANITY_LEVEL <= 4) {
                MAX_FAT_TOWERS = 4;
            } else if (INSANITY_LEVEL > 4 && INSANITY_LEVEL <= 8) {
                MAX_FAT_TOWERS = 5;
            } else if (INSANITY_LEVEL > 8 && INSANITY_LEVEL <= 12) {
                MAX_FAT_TOWERS = 6;
            } else if (INSANITY_LEVEL > 12 && INSANITY_LEVEL <= 16) {
                MAX_FAT_TOWERS = 7;
            } else {
                MAX_FAT_TOWERS = 8;
            }

            if(INSANITY_LEVEL < 10) {
                MoreBranches = false;
                MoreLootRooms = false;
            } else {
                MoreBranches = true;
                MoreLootRooms = true;
            }
        } else {
            if(INSANITY_LEVEL == 1) {
                Bridge_Length = 4;
            } else if (INSANITY_LEVEL == 2) {
                Bridge_Length = 6;
            } else if (INSANITY_LEVEL == 3) {
                Bridge_Length = 8;
            } else if (INSANITY_LEVEL == 4) {
                Bridge_Length = 10;
            } else {
                Bridge_Length = 12;
            }

            if(INSANITY_LEVEL == 1) {
                MAX_DEPTH = 8;
            } else if (INSANITY_LEVEL == 2) {
                MAX_DEPTH = 9;
            } else if (INSANITY_LEVEL == 3) {
                MAX_DEPTH = 10;
            } else if (INSANITY_LEVEL == 4) {
                MAX_DEPTH = 11;
            } else {
                MAX_DEPTH = 12;
            }

            if(INSANITY_LEVEL == 1) {
                MAX_SHIPS = 1;
            } else if (INSANITY_LEVEL == 2) {
                MAX_SHIPS = 3;
            } else if (INSANITY_LEVEL == 3) {
                MAX_SHIPS = 5;
            } else if (INSANITY_LEVEL == 4) {
                MAX_SHIPS = 7;
            } else {
                MAX_SHIPS = 10;
            }

            if(INSANITY_LEVEL == 1) {
                MAX_FAT_TOWERS = 4;
            } else if (INSANITY_LEVEL == 2) {
                MAX_FAT_TOWERS = 5;
            } else if (INSANITY_LEVEL == 3) {
                MAX_FAT_TOWERS = 6;
            } else if (INSANITY_LEVEL == 4) {
                MAX_FAT_TOWERS = 7;
            } else {
                MAX_FAT_TOWERS = 8;
            }

            if(INSANITY_LEVEL < 3) {
                MoreBranches = false;
                MoreLootRooms = false;
            } else {
                MoreBranches = true;
                MoreLootRooms = true;
            }
        }


        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
