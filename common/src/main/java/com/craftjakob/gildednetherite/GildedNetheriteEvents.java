package com.craftjakob.gildednetherite;

import com.craftjakob.gildednetherite.configs.CommonConfig;
import com.craftjakob.gildednetherite.core.init.ModItems;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class GildedNetheriteEvents {
    public static void registerEvents() {
        registerLootTables();
    }
    // Does work on Fabric, Forge
    private static void registerLootTables() { // /give @s chest{BlockEntityTag:{LootTable:"minecraft:chests/end_city_treasure"}}
        LootEvent.MODIFY_LOOT_TABLE.register((lootDataManager, id, context, builtin) -> {
            if (CommonConfig.EnableChestLoot.getValue()) {
                if (builtin && BuiltInLootTables.PIGLIN_BARTERING.equals(id)) {
                    if (CommonConfig.TradeWithPiglinsForGoldenCore.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreFromPiglinsChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_TREASURE.equals(id)) {
                    if (CommonConfig.GoldenCoreInBastionBridgeChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionTreasureChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_OTHER.equals(id)) {
                    if (CommonConfig.GoldenCoreInBastionOtherChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionOtherChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_BRIDGE.equals(id)) {
                    if (CommonConfig.GoldenCoreInNetherBridgeChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionBridgeChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(id)) {
                    if (CommonConfig.GoldenCoreInBastionHoglinStableChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionHoglinStableChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.NETHER_BRIDGE.equals(id)) {
                    if (CommonConfig. GoldenCoreInNetherBridgeChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInNetherBridgeChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.RUINED_PORTAL.equals(id)) {
                    if (CommonConfig.GoldenCoreInRuinedPortalChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInRuinedPortalChances.getValue())).setQuality(2)));
                    }
                }
            }
        });
    }
}
