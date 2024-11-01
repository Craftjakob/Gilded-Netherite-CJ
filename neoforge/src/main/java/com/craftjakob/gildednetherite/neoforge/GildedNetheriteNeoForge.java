package com.craftjakob.gildednetherite.neoforge;

import com.craftjakob.gildednetherite.GildedNetherite;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GildedNetherite.MOD_ID)
public class GildedNetheriteNeoForge {
    public GildedNetheriteNeoForge() {
        GildedNetherite.init();
    }
}