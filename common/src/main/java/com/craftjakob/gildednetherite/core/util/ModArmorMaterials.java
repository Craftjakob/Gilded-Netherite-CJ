package com.craftjakob.gildednetherite.core.util;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.craftjakob.gildednetherite.GildedNetherite;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum ModArmorMaterials implements StringRepresentable, ArmorMaterial {
	GILDED_NETHERITE("gilded_netherite", 37, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> {
		return Ingredient.of(Items.NETHERITE_INGOT);
	});
	private static final EnumMap<Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(Type.class), map -> {
		map.put(Type.BOOTS, 13);
		map.put(Type.LEGGINGS, 15);
		map.put(Type.CHESTPLATE, 16);
		map.put(Type.HELMET, 11);
	});
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final Ingredient repairIngredient;
	
	private ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionFunctionForType = protectionFunctionForType;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient.get();
	}
	@Override
	public int getDurabilityForType(Type type) {
		return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
	}
	@Override
	public int getDefenseForType(Type type) {
	      return this.protectionFunctionForType.get(type);
	}
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	@Override
	public @NotNull SoundEvent getEquipSound() {
		return this.sound;
	}
	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
	@Override
	public @NotNull String getName() {
		return GildedNetherite.MOD_ID + ":" + this.name;
	}
	@Override
	public float getToughness() {
		return this.toughness;
	}
	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	@Override
	public @NotNull String getSerializedName() {
		return this.name;
	}
}