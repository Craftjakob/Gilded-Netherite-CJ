package com.craftjakob.gildednetherite.neoforge.providers.custom;

import com.craftjakob.configapi.api.SimpleResourceLocation;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public abstract class ExtendedRecipeProvider extends RecipeProvider {
    private final String modId;

    public ExtendedRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, String modId) {
        super(output, completableFuture);
        this.modId = modId;
    }
    public String getModId() {
        return this.modId;
    }
    @Override
    protected abstract void buildRecipes(@NotNull RecipeOutput recipeOutput);


    // Methods for generating
    public void smithingRecipe(RecipeOutput recipeOutput, Ingredient smithingTemplate, Ingredient base, Ingredient addition, RecipeCategory category, Item result) {
        Item firstBaseItem = Arrays.stream(base.getItems()).toList().getFirst().getItem();
        SmithingTransformRecipeBuilder.smithing(smithingTemplate, base, addition, category, result)
                .unlocks("has_" + getItemName(firstBaseItem) + "_smithing", has(firstBaseItem))
                .save(recipeOutput, SimpleResourceLocation.location(this.getModId(), getItemName(result) + "_smithing"));
    }
    public void smithingRecipe(RecipeOutput recipeOutput, ItemLike smithingTemplate, Ingredient base, Ingredient addition, RecipeCategory category, Item result) {
        this.smithingRecipe(recipeOutput, Ingredient.of(smithingTemplate), base, addition, category, result);
    }
    public void smithingRecipe(RecipeOutput recipeOutput, ItemLike smithingTemplate, ItemLike base, ItemLike addition, RecipeCategory category, Item result) {
        this.smithingRecipe(recipeOutput, Ingredient.of(smithingTemplate), Ingredient.of(base), Ingredient.of(addition), category, result);
    }
    public void smithingRecipe(RecipeOutput recipeOutput, ItemLike smithingTemplate, ItemLike base, TagKey<Item> addition, RecipeCategory category, Item result) {
        this.smithingRecipe(recipeOutput, Ingredient.of(smithingTemplate), Ingredient.of(base), Ingredient.of(addition), category, result);
    }
    public void nineCraftingRecipe(RecipeOutput recipeOutput, RecipeCategory category, Item result, int resultCount, String group, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(category, result, resultCount).group(group)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(recipeOutput, SimpleResourceLocation.location(this.getModId(), getItemName(result) + "_from_" + getItemName(ingredient)));
    }
    public void eightCraftingRecipe(RecipeOutput recipeOutput, RecipeCategory category, Item result, int resultCount, String group, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(category, result, resultCount).group(group)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(recipeOutput, SimpleResourceLocation.location(this.getModId(), getItemName(result) + "_from_" + getItemName(ingredient)));
    }
    public void fourCraftingRecipe(RecipeOutput recipeOutput, RecipeCategory category, Item result, int resultCount, String group, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(category, result, resultCount).group(group)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(recipeOutput, SimpleResourceLocation.location(this.getModId(), getItemName(result) + "_from_" + getItemName(ingredient)));
    }
    public void shapelessCraftingRecipe(RecipeOutput recipeOutput, RecipeCategory category, Item result, int resultCount, String group, ItemLike requiredItem) {
        ShapelessRecipeBuilder.shapeless(category, result, resultCount).group(group)
                .requires(requiredItem, 1)
                .unlockedBy("has_" + getItemName(requiredItem), has(requiredItem))
                .save(recipeOutput, SimpleResourceLocation.location(this.modId, getItemName(result) + "_from_" + getItemName(requiredItem)));
    }
    public void cookingOreSmelting(RecipeOutput recipeOutput, RecipeCategory category, Ingredient ingredient, ItemLike result, float experience, int time, String group) {
        Item firstBaseItem = Arrays.stream(ingredient.getItems()).toList().getFirst().getItem();
        SimpleCookingRecipeBuilder.smelting(ingredient, category, result, experience, time)
                .group(group).unlockedBy(getHasName(firstBaseItem), has(firstBaseItem))
                .save(recipeOutput, SimpleResourceLocation.location(this.getModId(), getItemName(result) + "_from_smelting_" + getItemName(firstBaseItem)));
    }
    public void cookingOreBlasting(RecipeOutput recipeOutput, RecipeCategory category, Ingredient ingredient, ItemLike result, float experience, int time, String group) {
        Item firstBaseItem = Arrays.stream(ingredient.getItems()).toList().getFirst().getItem();
        SimpleCookingRecipeBuilder.blasting(ingredient, category, result, experience, time)
                .group(group).unlockedBy(getHasName(firstBaseItem), has(firstBaseItem))
                .save(recipeOutput, SimpleResourceLocation.location(this.getModId(), getItemName(result) + "_from_blasting_" + getItemName(firstBaseItem)));
    }
}
