package com.craftjakob.gildednetherite.fabric;

import com.craftjakob.gildednetherite.GildedNetherite;
import net.fabricmc.api.ModInitializer;

public class GildedNetheriteFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GildedNetherite.init();
    }
}