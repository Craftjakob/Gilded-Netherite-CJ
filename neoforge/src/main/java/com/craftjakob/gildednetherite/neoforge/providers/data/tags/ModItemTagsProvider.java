package com.craftjakob.gildednetherite.neoforge.providers.data.tags;

import com.craftjakob.gildednetherite.GildedNetherite;
import com.craftjakob.gildednetherite.core.init.ModItems;
import com.craftjakob.gildednetherite.core.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
	public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper helper) {
		super(output, registries, blockTags, GildedNetherite.MOD_ID, helper);
	}
	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		// Common Tags
		this.tag(ModItemTags.GOLDEN_CORE).add(ModItems.GOLDEN_CORE.get());

		this.tag(ModItemTags.GILDED_NETHERITE_HELMET).add(ModItems.GILDED_NETHERITE_HELMET.get());
		this.tag(ModItemTags.GILDED_NETHERITE_CHESTPLATE).add(ModItems.GILDED_NETHERITE_CHESTPLATE.get());
		this.tag(ModItemTags.GILDED_NETHERITE_LEGGINGS).add(ModItems.GILDED_NETHERITE_LEGGINGS.get());
		this.tag(ModItemTags.GILDED_NETHERITE_BOOTS).add(ModItems.GILDED_NETHERITE_BOOTS.get());
		this.tag(ModItemTags.GILDED_NETHERITE_SWORD).add(ModItems.GILDED_NETHERITE_SWORD.get());
		this.tag(ModItemTags.GILDED_NETHERITE_PICKAXE).add(ModItems.GILDED_NETHERITE_PICKAXE.get());
		this.tag(ModItemTags.GILDED_NETHERITE_AXE).add(ModItems.GILDED_NETHERITE_AXE.get());
		this.tag(ModItemTags.GILDED_NETHERITE_SHOVEL).add(ModItems.GILDED_NETHERITE_SHOVEL.get());
		this.tag(ModItemTags.GILDED_NETHERITE_HOE).add(ModItems.GILDED_NETHERITE_HOE.get());

		// Gilded Netherite Tags
		this.tag(ModItemTags.GILDED_NETHERITE_ARMOR)
				.add(ModItems.GILDED_NETHERITE_HELMET.get())
				.add(ModItems.GILDED_NETHERITE_CHESTPLATE.get())
				.add(ModItems.GILDED_NETHERITE_LEGGINGS.get())
				.add(ModItems.GILDED_NETHERITE_BOOTS.get());

		this.tag(ModItemTags.GILDED_NETHERITE_TOOLS)
				.add(ModItems.GILDED_NETHERITE_SWORD.get())
				.add(ModItems.GILDED_NETHERITE_PICKAXE.get())
				.add(ModItems.GILDED_NETHERITE_AXE.get())
				.add(ModItems.GILDED_NETHERITE_SHOVEL.get())
				.add(ModItems.GILDED_NETHERITE_HOE.get());

		this.tag(ModItemTags.GILDED_NETHERITE_ITEMS)
				.add(ModItems.GOLDEN_CORE.get())
				.addTag(ModItemTags.GILDED_NETHERITE_ARMOR)
				.addTag(ModItemTags.GILDED_NETHERITE_TOOLS);

		// Minecraft Tags
		this.tag(ItemTags.HEAD_ARMOR).replace(false).add(ModItems.GILDED_NETHERITE_HELMET.get());
		this.tag(ItemTags.CHEST_ARMOR).replace(false).add(ModItems.GILDED_NETHERITE_CHESTPLATE.get());
		this.tag(ItemTags.LEG_ARMOR).replace(false).add(ModItems.GILDED_NETHERITE_LEGGINGS.get());
		this.tag(ItemTags.FOOT_ARMOR).replace(false).add(ModItems.GILDED_NETHERITE_BOOTS.get());

		this.tag(ItemTags.SWORDS).replace(false).add(ModItems.GILDED_NETHERITE_SWORD.get());
		this.tag(ItemTags.PICKAXES).replace(false).add(ModItems.GILDED_NETHERITE_PICKAXE.get());
		this.tag(ItemTags.AXES).replace(false).add(ModItems.GILDED_NETHERITE_AXE.get());
		this.tag(ItemTags.SHOVELS).replace(false).add(ModItems.GILDED_NETHERITE_SHOVEL.get());
		this.tag(ItemTags.HOES).replace(false).add(ModItems.GILDED_NETHERITE_HOE.get());

		this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES).replace(false).add(ModItems.GILDED_NETHERITE_PICKAXE.get());
		this.tag(ItemTags.PIGLIN_LOVED).replace(false).addTag(ModItemTags.GILDED_NETHERITE_ITEMS);
		this.tag(ItemTags.TRIMMABLE_ARMOR).replace(false).addTag(ModItemTags.GILDED_NETHERITE_ARMOR);

		// Quark
		this.tag(ModItemTags.BIG_HARVESTING_HOES).replace(false).add(ModItems.GILDED_NETHERITE_HOE.get());
	}
}
