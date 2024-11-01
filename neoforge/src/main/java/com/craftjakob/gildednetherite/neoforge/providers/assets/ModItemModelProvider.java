package com.craftjakob.gildednetherite.neoforge.providers.assets;

import com.craftjakob.configapi.api.SimpleResourceLocation;
import com.craftjakob.gildednetherite.GildedNetherite;
import com.craftjakob.gildednetherite.core.init.ModItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
	public static final ResourceKey<TrimMaterial> ENDERITE = ResourceKey.create(Registries.TRIM_MATERIAL, SimpleResourceLocation.location("enderite", "enderite_darker"));

    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(ENDERITE, 0.7891011F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
	public ModItemModelProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, GildedNetherite.MOD_ID, helper);
	}
	@Override
	protected void registerModels() {
		this.basicItem(ModItems.GOLDEN_CORE.get());

		this.handHeldItem(ModItems.GILDED_NETHERITE_SWORD);
		this.handHeldItem(ModItems.GILDED_NETHERITE_PICKAXE);
		this.handHeldItem(ModItems.GILDED_NETHERITE_AXE);
		this.handHeldItem(ModItems.GILDED_NETHERITE_SHOVEL);
		this.handHeldItem(ModItems.GILDED_NETHERITE_HOE);

		this.trimmedArmorItem(ModItems.GILDED_NETHERITE_HELMET);
		this.trimmedArmorItem(ModItems.GILDED_NETHERITE_CHESTPLATE);
		this.trimmedArmorItem(ModItems.GILDED_NETHERITE_LEGGINGS);
		this.trimmedArmorItem(ModItems.GILDED_NETHERITE_BOOTS);
	}
	public void handHeldItem(RegistrySupplier<Item> item) {
		this.withExistingParent(item.getId().getPath(),
				SimpleResourceLocation.location("item/handheld")).texture("layer0",
				SimpleResourceLocation.location(item.getId().getNamespace(), "item/" + item.getId().getPath()));
	}
	public void trimmedArmorItem(RegistrySupplier<Item> item) {
		if (item.get() instanceof ArmorItem armorItem) {
			String armorType = switch (armorItem.getEquipmentSlot()) {
				case HEAD -> "helmet";
				case CHEST -> "chestplate";
				case LEGS -> "leggings";
				case FEET -> "boots";
				default -> "";
			};
			trimMaterials.forEach((trimMaterial, value) -> {
				String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
				String trimName = "item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(armorItem).getPath() + "_" + trimMaterial.location().getPath() + "_trim";
				ResourceLocation trimResLoc = SimpleResourceLocation.location(trimPath);

				existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures"); // making the ExistingFileHelper acknowledge that this texture exist, this will avoid an IllegalArgumentException

				this.getBuilder(trimName)
						.parent(new ModelFile.UncheckedModelFile("item/generated"))
						.texture("layer0", this.modLoc("item/" + BuiltInRegistries.ITEM.getKey(armorItem).getPath()))
						.texture("layer1", trimResLoc);
			});
			this.withExistingParent(item.getId().getPath(), SimpleResourceLocation.location("item/generated")).texture("layer0", SimpleResourceLocation.location(item.getId().getNamespace(), "item/" + item.getId().getPath()))
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_quartz_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.1F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_iron_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.2F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_netherite_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.3F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_redstone_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.4F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_copper_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.5F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_gold_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.6F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_emerald_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.7F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_diamond_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.8F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_lapis_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 0.9F).end()
					.override().model(this.getExistingFile(this.modLoc("item/trim/" + armorType + "/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath() + "_amethyst_trim"))).predicate(SimpleResourceLocation.location("trim_type"), 1.0F).end();
		}
	}
}
