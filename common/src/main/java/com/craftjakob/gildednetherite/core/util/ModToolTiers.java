package com.craftjakob.gildednetherite.core.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public enum ModToolTiers implements Tier {
	GILDED_NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2555, 9.5F, 4.5F, 20, Ingredient.of(Items.NETHERITE_INGOT));

	private final TagKey<Block> incorrectBlocksForDrops;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	ModToolTiers(TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float damage, int enchantmentValue, Ingredient repairIngredient) {
		this.incorrectBlocksForDrops = incorrectBlocksForDrops;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}
	@Override
	public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
		return this.incorrectBlocksForDrops;
	}
	@Override
	public int getUses() {
		return this.uses;
	}
	@Override
	public float getSpeed() {
		return this.speed;
	}
	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
}