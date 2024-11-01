package com.craftjakob.gildednetherite.neoforge.providers.data;

import com.craftjakob.configapi.api.SimpleResourceLocation;
import com.craftjakob.gildednetherite.GildedNetherite;
import com.craftjakob.gildednetherite.core.init.ModItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
	public static AdvancementHolder OBTAIN_GOLDEN_CORE;
	public static AdvancementHolder OBTAIN_GILDED_NETHERITE_ARMOR;
	public static AdvancementHolder OBTAIN_GILDED_NETHERITE_HOE;

	public ModAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries, ExistingFileHelper helper) {
		super(output, registries, helper, List.of(new ModAdvancementsGenerator()));
	}
	public static class ModAdvancementsGenerator implements AdvancementGenerator {
		@Override
		public void generate(@NotNull Provider provider, @NotNull Consumer<AdvancementHolder> consumer, @NotNull ExistingFileHelper helper) {
			OBTAIN_GOLDEN_CORE = Advancement.Builder.advancement()
					.parent(SimpleResourceLocation.location("minecraft", "nether/distract_piglin"))
					.display(ModItems.GOLDEN_CORE.get(),
							Component.translatable("advancement.nether.gildednetherite.obtain_golden_core.title"),
							Component.translatable("advancement.nether.gildednetherite.obtain_golden_core.description"),
							null, AdvancementType.CHALLENGE, true, true, false)
					.rewards(AdvancementRewards.Builder.experience(200))
					.requirements(AdvancementRequirements.Strategy.OR)
					.addCriterion("has_" + ModItems.GOLDEN_CORE.get().toString(), hasOneOfTheItems(ModItems.GOLDEN_CORE.get()))
					.save(consumer, GildedNetherite.MOD_ID + ":husbandry/obtain_golden_core");
			OBTAIN_GILDED_NETHERITE_ARMOR = Advancement.Builder.advancement()
					.parent(SimpleResourceLocation.location("minecraft", "nether/netherite_armor"))
					.display(ModItems.GILDED_NETHERITE_CHESTPLATE.get(),
							Component.translatable("advancement.nether.gildednetherite.gilded_netherite_armor.title"),
							Component.translatable("advancement.nether.gildednetherite.gilded_netherite_armor.description"),
							null, AdvancementType.CHALLENGE, true, true, false)
					.rewards(AdvancementRewards.Builder.experience(250))
					.addCriterion("has_helmet", hasOneOfTheItems(ModItems.GILDED_NETHERITE_HELMET.get()))
					.addCriterion("has_chestplate", hasOneOfTheItems(ModItems.GILDED_NETHERITE_CHESTPLATE.get()))
					.addCriterion("has_leggings", hasOneOfTheItems(ModItems.GILDED_NETHERITE_LEGGINGS.get()))
					.addCriterion("has_boots", hasOneOfTheItems(ModItems.GILDED_NETHERITE_BOOTS.get()))
					.save(consumer, String.valueOf(SimpleResourceLocation.location(GildedNetherite.MOD_ID, "nether/obtain_gilded_netherite_armor")));
			OBTAIN_GILDED_NETHERITE_HOE = Advancement.Builder.advancement()
					.parent(SimpleResourceLocation.location("minecraft", "husbandry/obtain_netherite_hoe"))
					.display(ModItems.GILDED_NETHERITE_HOE.get(),
							Component.translatable("advancement.husbandry.gildednetherite.obtain_gilded_netherite_hoe.title"),
							Component.translatable("advancement.husbandry.gildednetherite.obtain_gilded_netherite_hoe.description"),
							null, AdvancementType.CHALLENGE, true, true, false)
					.rewards(AdvancementRewards.Builder.experience(200))
					.requirements(AdvancementRequirements.Strategy.OR)
					.addCriterion("has_" + ModItems.GILDED_NETHERITE_HOE.get().toString(), hasOneOfTheItems(ModItems.GILDED_NETHERITE_HOE.get()))
					.save(consumer, GildedNetherite.MOD_ID + ":husbandry/obtain_gilded_netherite_hoe");
		}
	}
	public static Criterion<InventoryChangeTrigger.TriggerInstance> hasOneOfTheItems(ItemLike... itemlike) {
		ItemPredicate[] itempredicate = new ItemPredicate[1];
		List<Holder.Reference<Item>> itemHolders = new ArrayList<>();
        for (ItemLike itemLike : itemlike) {
            itemHolders.add(itemLike.asItem().builtInRegistryHolder());
        }
		itempredicate[0] = new ItemPredicate(Optional.of(HolderSet.direct(itemHolders)), MinMaxBounds.Ints.ANY, DataComponentPredicate.EMPTY, Map.of());
		return InventoryChangeTrigger.TriggerInstance.hasItems(itempredicate);
	}
}
