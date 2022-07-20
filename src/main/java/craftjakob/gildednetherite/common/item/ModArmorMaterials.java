package craftjakob.gildednetherite.common.item;

import craftjakob.gildednetherite.GildedNetherite;
import craftjakob.gildednetherite.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum ModArmorMaterials implements ArmorMaterial {
	   GILDED_NETHERITE_INGOT("gilded_netherite_ingot", 40, new int[]{4, 7, 9, 4}, 20,
			   SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, () -> {
		      return Ingredient.of(ModItems.GILDED_NETHERITE_INGOT.get());
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
		   
		   public int getDurabilityForSlot(EquipmentSlot getDurabilityForSlot) {
		      return HEALTH_PER_SLOT[getDurabilityForSlot.getIndex()] * this.durabilityMultiplier;
		   }

		   public int getDefenseForSlot(EquipmentSlot getDefenseForSlot) {
		      return this.slotProtections[getDefenseForSlot.getIndex()];
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