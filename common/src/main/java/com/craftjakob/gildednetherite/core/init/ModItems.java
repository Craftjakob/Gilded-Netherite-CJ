package com.craftjakob.gildednetherite.core.init;

import com.craftjakob.gildednetherite.GildedNetherite;
import com.craftjakob.gildednetherite.common.item.GildedNetheriteArmor;
import com.craftjakob.gildednetherite.common.item.GoldenCore;
import com.craftjakob.gildednetherite.core.util.ModArmorMaterials;
import com.craftjakob.gildednetherite.core.util.ModToolTiers;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(GildedNetherite.MOD_ID, Registries.ITEM);

    // Material
    public static final RegistrySupplier<Item> GOLDEN_CORE = ITEMS.register("golden_core", () -> new GoldenCore(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Armor
    public static final RegistrySupplier<Item> GILDED_NETHERITE_HELMET = ITEMS.register("gilded_netherite_helmet",
            () -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties()
                    .fireResistant().rarity(Rarity.RARE).durability(ArmorItem.Type.HELMET.getDurability(38))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_CHESTPLATE = ITEMS.register("gilded_netherite_chestplate",
            () -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .fireResistant().rarity(Rarity.RARE).durability(ArmorItem.Type.CHESTPLATE.getDurability(38))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_LEGGINGS = ITEMS.register("gilded_netherite_leggings",
            () -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .fireResistant().rarity(Rarity.RARE).durability(ArmorItem.Type.LEGGINGS.getDurability(38))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_BOOTS = ITEMS.register("gilded_netherite_boots",
            () -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties()
                    .fireResistant().rarity(Rarity.RARE).durability(ArmorItem.Type.BOOTS.getDurability(38))));

    // Tools
    public static final RegistrySupplier<Item> GILDED_NETHERITE_SWORD = ITEMS.register("gilded_netherite_sword",
            () -> new SwordItem(ModToolTiers.GILDED_NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.RARE)
                    .attributes(SwordItem.createAttributes(ModToolTiers.GILDED_NETHERITE, 3, -2.4F))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_PICKAXE = ITEMS.register("gilded_netherite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GILDED_NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.RARE)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.GILDED_NETHERITE, 1.0F, -2.8F))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_AXE = ITEMS.register("gilded_netherite_axe",
            () -> new AxeItem(ModToolTiers.GILDED_NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.RARE)
                    .attributes(AxeItem.createAttributes(ModToolTiers.GILDED_NETHERITE, 5.0F, -3.0F))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_SHOVEL = ITEMS.register("gilded_netherite_shovel",
            () -> new ShovelItem(ModToolTiers.GILDED_NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.RARE)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.GILDED_NETHERITE, 1.5F, -3.0F))));
    public static final RegistrySupplier<Item> GILDED_NETHERITE_HOE = ITEMS.register("gilded_netherite_hoe",
            () -> new HoeItem(ModToolTiers.GILDED_NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.RARE)
                    .attributes(HoeItem.createAttributes(ModToolTiers.GILDED_NETHERITE, -5.0F, 0.0F))));
}
