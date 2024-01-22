package net.architects.BigEndCitiesMod.config;

import com.mojang.datafixers.util.Pair;
import net.architects.BigEndCitiesMod.BigEndCitiesMod;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int MAX_DEPTH = 8;

    public static int MAX_DEPTH_PRE = 8;
    public static int MAX_SHIPS = 3;

    public static int MAX_FAT_TOWERS = 8;

    public static int Bridge_Length = 6;

    public static boolean MoreBranches;

    public static boolean MoreLootRooms;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(BigEndCitiesMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("MaximumDepth", 8), "Higher means more Junctions");
        configs.addKeyValuePair(new Pair<>("MaximumShips", 1), "Best value is 10 to allow for many ships");
        configs.addKeyValuePair(new Pair<>("MaximumMiddleTowers", 2), "Best Value is 3-6");
        configs.addKeyValuePair(new Pair<>("BridgeLength", "short"), "Choose between: short, medium, long. Best for large cities is medium");
        configs.addKeyValuePair(new Pair<>("PrioritizeBranching", false), "Setting this to true will make more branches occur. Can cause more overlap. Best is true");
        configs.addKeyValuePair(new Pair<>("MoreLootRooms", false), "This will make more 3 layer buildings spawn. This will also make the cities much taller. Best is true");

    }

    private static void assignConfigs() {

        MAX_DEPTH_PRE = CONFIG.getOrDefault("MaximumDepth", 8);

        MAX_SHIPS = CONFIG.getOrDefault("MaximumShips", 8);

        MAX_FAT_TOWERS = CONFIG.getOrDefault("MaximumMiddleTowers", 8);

        String bridge_Length_String = CONFIG.getOrDefault("BridgeLength", "short");

        MoreBranches = CONFIG.getOrDefault("PrioritizeBranching", false);

        MoreLootRooms = CONFIG.getOrDefault("MoreLootRooms", false);


        if(MAX_DEPTH_PRE < 8) {
            MAX_DEPTH = 8;
        } else {
            MAX_DEPTH = MAX_DEPTH_PRE;
        }


        if(bridge_Length_String.equalsIgnoreCase("short")) {
            Bridge_Length = 4;
        } else if (bridge_Length_String.equalsIgnoreCase("medium")) {
            Bridge_Length = 8;
        } else if (bridge_Length_String.equalsIgnoreCase("long")) {
            Bridge_Length = 12;
        } else {
            Bridge_Length = 4;
        }

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
