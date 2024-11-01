package com.craftjakob.gildednetherite.core.util;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum ModToolTiers implements Tier { //Harvest Level, Durability, Efficiency, Attack Damage, Enchantability
	/*public static final ForgeTier GILDED_NETHERITE = new ForgeTier(5, 2555, 9.5F, 4.5F, 20, Tags.Blocks.NEEDS_NETHERITE_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));*/
	GILDED_NETHERITE(5, 2555, 9.5F, 4.5F, 20, Ingredient.of(Items.NETHERITE_INGOT));

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	ModToolTiers(int level, int uses, float speed, float damage, int enchantmentValue, Ingredient ingredient) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = ingredient;
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
	public int getLevel() {
		return this.level;
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