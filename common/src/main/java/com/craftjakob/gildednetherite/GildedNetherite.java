package com.craftjakob.gildednetherite;

import com.craftjakob.configapi.core.Config;
import com.craftjakob.configapi.core.ConfigRegister;
import com.craftjakob.gildednetherite.configs.ClientConfig;
import com.craftjakob.gildednetherite.configs.CommonConfig;
import com.craftjakob.gildednetherite.core.init.*;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class GildedNetherite {
	public static final String MOD_ID = "gildednetherite";
	public static final Logger LOGGER = LogUtils.getLogger();
	public static void init() {
		ConfigRegister.get().registerConfig(Config.ConfigType.CLIENT, ClientConfig::new, MOD_ID);
		ConfigRegister.get().registerConfig(Config.ConfigType.COMMON, CommonConfig::new, MOD_ID);

		ModItems.ITEMS.register();
		ModCreativeModeTabs.CREATIVE_MODE_TABS.register();

		GildedNetheriteEvents.registerEvents();
	}
	/*private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.getEntries().putAfter(new ItemStack(Items.NETHERITE_HOE), new ItemStack(ModItems.GILDED_NETHERITE_SHOVEL.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(ModItems.GILDED_NETHERITE_SHOVEL.get()), new ItemStack(ModItems.GILDED_NETHERITE_PICKAXE.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(ModItems.GILDED_NETHERITE_PICKAXE.get()), new ItemStack(ModItems.GILDED_NETHERITE_AXE.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(ModItems.GILDED_NETHERITE_AXE.get()), new ItemStack(ModItems.GILDED_NETHERITE_HOE.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
		if (event.getTabKey() == CreativeModeTabs.COMBAT) {
			event.getEntries().putAfter(new ItemStack(Items.NETHERITE_SWORD), new ItemStack(ModItems.GILDED_NETHERITE_SWORD.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(Items.NETHERITE_AXE), new ItemStack(ModItems.GILDED_NETHERITE_AXE.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(Items.NETHERITE_BOOTS), new ItemStack(ModItems.GILDED_NETHERITE_HELMET.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(ModItems.GILDED_NETHERITE_HELMET.get()), new ItemStack(ModItems.GILDED_NETHERITE_CHESTPLATE.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(ModItems.GILDED_NETHERITE_CHESTPLATE.get()), new ItemStack(ModItems.GILDED_NETHERITE_LEGGINGS.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(new ItemStack(ModItems.GILDED_NETHERITE_LEGGINGS.get()), new ItemStack(ModItems.GILDED_NETHERITE_BOOTS.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.getEntries().putAfter(new ItemStack(Items.NETHERITE_INGOT), new ItemStack(ModItems.GOLDEN_CORE.get()), TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}*/
}
