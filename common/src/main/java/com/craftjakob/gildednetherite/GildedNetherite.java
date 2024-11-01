package com.craftjakob.gildednetherite;

import com.craftjakob.configapi.config.Config;
import com.craftjakob.configapi.config.ConfigRegister;
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

		GildedNetheriteEvents.registerEvents();
	}
}
