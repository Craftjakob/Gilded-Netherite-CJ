package com.craftjakob.gildednetherite.core.tags;

import com.craftjakob.configapi.api.TagUtilities;
import com.craftjakob.gildednetherite.GildedNetherite;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagUtilities<Item> ITEM_TAGS = TagUtilities.create(GildedNetherite.MOD_ID, Registries.ITEM);

    public static final TagKey<Item> GOLDEN_CORE = ITEM_TAGS.commonTag("materials/golden_core");

    public static final TagKey<Item> GILDED_NETHERITE_ITEMS = ITEM_TAGS.modTag("gilded_netherite_items");
    public static final TagKey<Item> GILDED_NETHERITE_ARMOR = ITEM_TAGS.modTag("gilded_netherite_armor");
    public static final TagKey<Item> GILDED_NETHERITE_TOOLS = ITEM_TAGS.modTag("gilded_netherite_tools");

    public static final TagKey<Item> BIG_HARVESTING_HOES = ITEM_TAGS.customTag("quark", "big_harvesting_hoes");

    public static final TagKey<Item> GILDED_NETHERITE_HELMET = ITEM_TAGS.commonTag("armors/gilded_netherite_helmet");
    public static final TagKey<Item> GILDED_NETHERITE_CHESTPLATE = ITEM_TAGS.commonTag("armors/gilded_netherite_chestplate");
    public static final TagKey<Item> GILDED_NETHERITE_LEGGINGS = ITEM_TAGS.commonTag("armors/gilded_netherite_leggings");
    public static final TagKey<Item> GILDED_NETHERITE_BOOTS = ITEM_TAGS.commonTag("armors/gilded_netherite_boots");
    public static final TagKey<Item> GILDED_NETHERITE_SWORD = ITEM_TAGS.commonTag("tools/gilded_netherite_sword");
    public static final TagKey<Item> GILDED_NETHERITE_PICKAXE = ITEM_TAGS.commonTag("tools/gilded_netherite_pickaxe");
    public static final TagKey<Item> GILDED_NETHERITE_AXE = ITEM_TAGS.commonTag("tools/gilded_netherite_axe");
    public static final TagKey<Item> GILDED_NETHERITE_SHOVEL = ITEM_TAGS.commonTag("tools/gilded_netherite_shovel");
    public static final TagKey<Item> GILDED_NETHERITE_HOE = ITEM_TAGS.commonTag("tools/gilded_netherite_hoe");
}
