package com.craftjakob.gildednetherite.neoforge.providers.data;

import com.craftjakob.gildednetherite.GildedNetherite;
import com.craftjakob.gildednetherite.core.init.ModItems;
import com.craftjakob.gildednetherite.core.tags.ModItemTags;
import com.craftjakob.gildednetherite.neoforge.providers.custom.ExtendedRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends ExtendedRecipeProvider {
	public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture, GildedNetherite.MOD_ID);
	}
	@Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_HELMET, ModItemTags.GOLDEN_CORE, RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_HELMET.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_CHESTPLATE, ModItemTags.GOLDEN_CORE, RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_CHESTPLATE.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_LEGGINGS, ModItemTags.GOLDEN_CORE, RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_LEGGINGS.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_BOOTS, ModItemTags.GOLDEN_CORE, RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_BOOTS.get());

		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_SWORD, ModItemTags.GOLDEN_CORE, RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_SWORD.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_PICKAXE, ModItemTags.GOLDEN_CORE, RecipeCategory.TOOLS, ModItems.GILDED_NETHERITE_PICKAXE.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_AXE, ModItemTags.GOLDEN_CORE, RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_AXE.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_SHOVEL, ModItemTags.GOLDEN_CORE, RecipeCategory.TOOLS, ModItems.GILDED_NETHERITE_SHOVEL.get());
		this.smithingRecipe(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_HOE, ModItemTags.GOLDEN_CORE, RecipeCategory.TOOLS, ModItems.GILDED_NETHERITE_HOE.get());

	}
}