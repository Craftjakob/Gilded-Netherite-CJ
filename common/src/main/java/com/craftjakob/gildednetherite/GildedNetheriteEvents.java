package com.craftjakob.gildednetherite;

import com.craftjakob.gildednetherite.configs.CommonConfig;
import com.craftjakob.gildednetherite.core.init.ModItems;
import dev.architectury.event.events.common.LootEvent;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class GildedNetheriteEvents {
    public static void registerEvents() {
        registerModifiedCreativeTabs();
        registerLootTables();
    }
    private static void registerModifiedCreativeTabs() {
        CreativeTabRegistry.modifyBuiltin(CreativeModeTabs.allTabs().get(7), (flags, output, canUseGameMasterBlocks) -> {
            output.acceptAfter(Items.NETHERITE_HOE, ModItems.GILDED_NETHERITE_SHOVEL.get());
            output.acceptAfter(ModItems.GILDED_NETHERITE_SHOVEL.get(), ModItems.GILDED_NETHERITE_PICKAXE.get());
            output.acceptAfter(ModItems.GILDED_NETHERITE_PICKAXE.get(), ModItems.GILDED_NETHERITE_AXE.get());
            output.acceptAfter(ModItems.GILDED_NETHERITE_AXE.get(), ModItems.GILDED_NETHERITE_HOE.get());
        });
        CreativeTabRegistry.modifyBuiltin(CreativeModeTabs.allTabs().get(8), (flags, output, canUseGameMasterBlocks) -> {
            output.acceptAfter(Items.NETHERITE_SWORD, ModItems.GILDED_NETHERITE_SWORD.get());
            output.acceptAfter(Items.NETHERITE_AXE, ModItems.GILDED_NETHERITE_AXE.get());
            output.acceptAfter(Items.NETHERITE_BOOTS, ModItems.GILDED_NETHERITE_HELMET.get());
            output.acceptAfter(ModItems.GILDED_NETHERITE_HELMET.get(), ModItems.GILDED_NETHERITE_CHESTPLATE.get());
            output.acceptAfter(ModItems.GILDED_NETHERITE_CHESTPLATE.get(), ModItems.GILDED_NETHERITE_LEGGINGS.get());
            output.acceptAfter(ModItems.GILDED_NETHERITE_LEGGINGS.get(), ModItems.GILDED_NETHERITE_BOOTS.get());
        });
        CreativeTabRegistry.modifyBuiltin(CreativeModeTabs.allTabs().get(10), (flags, output, canUseGameMasterBlocks) -> {
            output.acceptAfter(Items.NETHERITE_INGOT, ModItems.GOLDEN_CORE.get());
        });
    }
    // Does work on Fabric, Forge
    private static void registerLootTables() { // /give @s chest{BlockEntityTag:{LootTable:"minecraft:chests/end_city_treasure"}}
        LootEvent.MODIFY_LOOT_TABLE.register((key, context, builtin) -> {
            if (CommonConfig.EnableChestLoot.getValue()) {
                if (builtin && BuiltInLootTables.PIGLIN_BARTERING.equals(key)) {
                    if (CommonConfig.TradeWithPiglinsForGoldenCore.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreFromPiglinsChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_TREASURE.equals(key)) {
                    if (CommonConfig.GoldenCoreInBastionBridgeChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionTreasureChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_OTHER.equals(key)) {
                    if (CommonConfig.GoldenCoreInBastionOtherChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionOtherChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_BRIDGE.equals(key)) {
                    if (CommonConfig.GoldenCoreInNetherBridgeChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionBridgeChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(key)) {
                    if (CommonConfig.GoldenCoreInBastionHoglinStableChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInBastionHoglinStableChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
                    if (CommonConfig. GoldenCoreInNetherBridgeChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInNetherBridgeChances.getValue())).setQuality(2)));
                    }
                }
                if (builtin && BuiltInLootTables.RUINED_PORTAL.equals(key)) {
                    if (CommonConfig.GoldenCoreInRuinedPortalChest.getValue()) {
                        context.addPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GOLDEN_CORE.get())
                                .when(LootItemRandomChanceCondition.randomChance(CommonConfig.GoldenCoreInRuinedPortalChances.getValue())).setQuality(2)));
                    }
                }
            }
        });
    }
}
