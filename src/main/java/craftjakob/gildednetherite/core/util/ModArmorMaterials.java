package craftjakob.gildednetherite.core.util;

import java.util.function.Supplier;

import craftjakob.gildednetherite.GildedNetherite;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum ModArmorMaterials implements ArmorMaterial {
	   GILDED_NETHERITE("gilded_netherite", 40, new int[]{3, 6, 8, 3}, 20,
			   SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.2F, () -> {
		      return Ingredient.of(Items.NETHERITE_INGOT);
		   });

		   private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
		   private final String name;
		   private final int durabilityMultiplier;
		   private final int[] slotProtections;
		   private final int enchantmentValue;
		   private final SoundEvent sound;
		   private final float toughness;
		   private final float knockbackResistance;
		   private final LazyLoadedValue<Ingredient> repairIngredient;

		   private ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		      this.name = name;
		      this.durabilityMultiplier = durabilityMultiplier;
		      this.slotProtections = slotProtections;
		      this.enchantmentValue = enchantmentValue;
		      this.sound = sound;
		      this.toughness = toughness;
		      this.knockbackResistance = knockbackResistance;
		      this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
		   }
		   public int getDurabilityForType(Type type) {
		     return HEALTH_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
		   }
		   public int getDefenseForType(Type type) {
		     return this.slotProtections[type.getSlot().getIndex()];
		   }
		   public int getEnchantmentValue() {
		      return this.enchantmentValue;
		   }
		   public SoundEvent getEquipSound() {
		      return this.sound;
		   }
		   public Ingredient getRepairIngredient() {
		      return this.repairIngredient.get();
		   }
		   public String getName() {
		      return GildedNetherite.MODID + ":" + this.name;
		   }
		   public float getToughness() {
		      return this.toughness;
		   }
		   public float getKnockbackResistance() {
		      return this.knockbackResistance;
		   }
		}