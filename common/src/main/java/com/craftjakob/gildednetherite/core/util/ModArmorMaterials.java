package com.craftjakob.gildednetherite.core.util;

import java.util.EnumMap;
import java.util.List;

import com.craftjakob.configapi.api.SimpleResourceLocation;
import com.craftjakob.gildednetherite.GildedNetherite;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ModArmorMaterials {
	public static Holder<ArmorMaterial> GILDED_NETHERITE;

	static {
		GILDED_NETHERITE = register(GildedNetherite.MOD_ID, "gilded_netherite", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
			enumMap.put(Type.BOOTS, 3);
			enumMap.put(Type.LEGGINGS, 6);
			enumMap.put(Type.CHESTPLATE, 8);
			enumMap.put(Type.HELMET, 3);
			enumMap.put(Type.BODY, 11);
		}), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, Ingredient.of(Items.NETHERITE_INGOT));
	}
	public static Holder<ArmorMaterial> register(String modId, String name, EnumMap<ArmorItem.Type, Integer> enumMap, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Ingredient ingredient) {
		List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(SimpleResourceLocation.location(modId, name)));
		return register(modId, name, enumMap, enchantmentValue, equipSound, toughness, knockbackResistance, ingredient, layers);
	}
	public static Holder<ArmorMaterial> register(String modId, String name, EnumMap<ArmorItem.Type, Integer> enumMap, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Ingredient ingredient, List<ArmorMaterial.Layer> layers) {
		EnumMap<ArmorItem.Type, Integer> defenseEnumMap = new EnumMap<>(ArmorItem.Type.class);
		ArmorItem.Type[] types = ArmorItem.Type.values();
		for (ArmorItem.Type type : types) {
			defenseEnumMap.put(type, enumMap.get(type));
		}
		return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, SimpleResourceLocation.location(modId, name), new ArmorMaterial(defenseEnumMap, enchantmentValue, equipSound, () -> ingredient, layers, toughness, knockbackResistance));
	}
}