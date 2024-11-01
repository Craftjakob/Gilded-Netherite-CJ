package com.craftjakob.gildednetherite.neoforge.providers;

import com.craftjakob.gildednetherite.GildedNetherite;
import com.craftjakob.gildednetherite.neoforge.providers.assets.ModItemModelProvider;
import com.craftjakob.gildednetherite.neoforge.providers.data.ModAdvancementProvider;
import com.craftjakob.gildednetherite.neoforge.providers.data.ModRecipeProvider;
import com.craftjakob.gildednetherite.neoforge.providers.data.tags.ModBlockTagsProvider;
import com.craftjakob.gildednetherite.neoforge.providers.data.tags.ModItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = GildedNetherite.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(packOutput, lookupProvider, helper);

        // Assets
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, helper));

        // Data
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(packOutput, lookupProvider, helper));

        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), helper));
    }
}
