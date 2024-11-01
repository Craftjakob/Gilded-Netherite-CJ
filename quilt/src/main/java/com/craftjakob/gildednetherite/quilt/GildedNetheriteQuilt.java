package com.craftjakob.gildednetherite.quilt;

import com.craftjakob.gildednetherite.GildedNetherite;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class GildedNetheriteQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        GildedNetherite.init();
    }
}