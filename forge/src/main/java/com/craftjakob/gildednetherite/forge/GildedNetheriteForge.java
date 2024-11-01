package com.craftjakob.gildednetherite.forge;

import com.craftjakob.gildednetherite.GildedNetherite;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GildedNetherite.MOD_ID)
public class GildedNetheriteForge {
    public GildedNetheriteForge() {
        EventBuses.registerModEventBus(GildedNetherite.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        GildedNetherite.init();
    }
}