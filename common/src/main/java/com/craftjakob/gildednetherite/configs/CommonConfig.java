package com.craftjakob.gildednetherite.configs;

import com.craftjakob.configapi.core.ConfigValueTypes;
import com.craftjakob.configapi.core.ConfigBuilder;
import com.craftjakob.configapi.core.IConfigurator;

public class CommonConfig implements IConfigurator {
    public static ConfigValueTypes.BooleanValue TradeWithPiglinsForGoldenCore;

    public static ConfigValueTypes.BooleanValue EnableChestLoot;
    public static ConfigValueTypes.BooleanValue GoldenCoreInNetherBridgeChest;
    public static ConfigValueTypes.BooleanValue GoldenCoreInBastionTreasureChest;
    public static ConfigValueTypes.BooleanValue GoldenCoreInBastionOtherChest;
    public static ConfigValueTypes.BooleanValue GoldenCoreInBastionHoglinStableChest;
    public static ConfigValueTypes.BooleanValue GoldenCoreInBastionBridgeChest;
    public static ConfigValueTypes.BooleanValue GoldenCoreInRuinedPortalChest;

    public static ConfigValueTypes.FloatValue GoldenCoreFromPiglinsChances;
    public static ConfigValueTypes.FloatValue GoldenCoreInBastionTreasureChances;
    public static ConfigValueTypes.FloatValue GoldenCoreInBastionOtherChances;
    public static ConfigValueTypes.FloatValue GoldenCoreInBastionBridgeChances;
    public static ConfigValueTypes.FloatValue GoldenCoreInBastionHoglinStableChances;
    public static ConfigValueTypes.FloatValue GoldenCoreInNetherBridgeChances;
    public static ConfigValueTypes.FloatValue GoldenCoreInRuinedPortalChances;

    @Override
    public void configure(ConfigBuilder builder) {
        EnableChestLoot = builder.requiresClientRestart()
                .comment("If false, then all Chest Loot Tables from this mod, can not spawn. Default is true")
                .define("EnableChestLoot", true);
        TradeWithPiglinsForGoldenCore = builder.requiresClientRestart()
                .comment("If false, then Piglins don't trade Golden Cores. Default is true.")
                .define("TradeWithPiglinsForGoldenCore", true);

        builder.requiresClientRestart().push("Chest Loot Tables");
        {
            GoldenCoreInNetherBridgeChest = builder.requiresClientRestart()
                    .comment("If true, then the Golden Core spawns in Nether Bridge Chests. Default is false.")
                    .define("GoldenCoreInNetherBridgeChest", false);
            GoldenCoreInBastionTreasureChest = builder.requiresClientRestart()
                    .comment("If true, then thhe Golden Core spawns in Bastion Treasure Chests. Default is false.")
                    .define("GoldenCoreInBastionTreasureChest", false);
            GoldenCoreInBastionOtherChest = builder.requiresClientRestart()
                    .comment("If true, then the Golden Core spawns in Bastion Other Chests. Default is false.")
                    .define("GoldenCoreInBastionOtherChest", false);
            GoldenCoreInBastionHoglinStableChest = builder.requiresClientRestart()
                    .comment("If true, then the Golden Core spawns in Bastion Hoglin Stable Chests. Default is false.")
                    .define("GoldenCoreInBastionHoglinStableChest", false);
            GoldenCoreInBastionBridgeChest = builder.requiresClientRestart()
                    .comment("If true, then the Golden Core spawns in Bastion Bridge Chests. Default is false.")
                    .define("GoldenCoreInBastionBridgeChest", false);
            GoldenCoreInRuinedPortalChest = builder.requiresClientRestart()
                    .comment("If true, then the Golden Core spawns in Runied Portal Chests. Default is true.")
                    .define("GoldenCoreInRuinedPortalChest", true);
        }
        builder.pop();

        builder.requiresClientRestart().push("Item Chances");
        {
            GoldenCoreFromPiglinsChances = builder.requiresClientRestart()
                    .comment("Chance to trade a Golden Core. Default is 0.075")
                    .defineInRange("GoldenCoreFromPiglinsChances", 0.075F, 0F, 1.0F);

            GoldenCoreInBastionTreasureChances = builder.requiresClientRestart()
                    .comment("Chance to get a Golden Core in Bastion Treasure chest. Default is 0.5")
                    .defineInRange("GoldenCoreInBastionTreasureChances", 0.5F, 0F, 1.0F);
            GoldenCoreInBastionOtherChances = builder.requiresClientRestart()
                    .comment("Chance to get a Golden Core in Bastion Other chest. Default is 0.15")
                    .defineInRange("GoldenCoreInBastionOtherChances", 0.15F, 0F, 1.0F);
            GoldenCoreInBastionBridgeChances = builder.requiresClientRestart()
                    .comment("Chance to get a Golden Core in Bastion Bridge chest. Default is 0.15")
                    .defineInRange("GoldenCoreInBastionBridgeChances", 0.25F, 0F, 1.0F);
            GoldenCoreInBastionHoglinStableChances = builder.requiresClientRestart()
                    .comment("Chance to get a Golden Core in Bastion Hoglin Stable chest. Default is 0.2")
                    .defineInRange("GoldenCoreInBastionHoglinStableChances", 0.2F, 0F, 1.0F);
            GoldenCoreInNetherBridgeChances = builder.requiresClientRestart()
                    .comment("Chance to get a Golden Core in Nether Bridge chest. Default is 0.25")
                    .defineInRange("GoldenCoreInNetherBridgeChances", 0.2F, 0F, 1.0F);
            GoldenCoreInRuinedPortalChances = builder.requiresClientRestart()
                    .comment("Chance to get a Golden Core in Ruined Portal chest. Default is 0.001")
                    .defineInRange("GoldenCoreInRuinedPortalChances", 0.001F, 0F, 1.0F);
        }
        builder.pop();
    }
}
