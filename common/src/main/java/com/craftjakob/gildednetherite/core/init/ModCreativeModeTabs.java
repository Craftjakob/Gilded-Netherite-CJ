package com.craftjakob.gildednetherite.core.init;

import com.craftjakob.gildednetherite.GildedNetherite;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(GildedNetherite.MOD_ID, Registries.CREATIVE_MODE_TAB);
	
    public static final RegistrySupplier<CreativeModeTab> GILDED_NETHERITE_TAB = CREATIVE_MODE_TABS.register("enderite_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 10)
            .title(Component.translatable("creativemodetab.gildednetherite.gildednetherite_tab"))
            .icon(() -> ModItems.GOLDEN_CORE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.GOLDEN_CORE.get());
                output.accept(ModItems.GILDED_NETHERITE_HELMET.get());
                output.accept(ModItems.GILDED_NETHERITE_CHESTPLATE.get());
                output.accept(ModItems.GILDED_NETHERITE_LEGGINGS.get());
                output.accept(ModItems.GILDED_NETHERITE_BOOTS.get());
                output.accept(ModItems.GILDED_NETHERITE_SWORD.get());
                output.accept(ModItems.GILDED_NETHERITE_PICKAXE.get());
                output.accept(ModItems.GILDED_NETHERITE_AXE.get());
                output.accept(ModItems.GILDED_NETHERITE_SHOVEL.get());
                output.accept(ModItems.GILDED_NETHERITE_HOE.get());
	}).build());
}
