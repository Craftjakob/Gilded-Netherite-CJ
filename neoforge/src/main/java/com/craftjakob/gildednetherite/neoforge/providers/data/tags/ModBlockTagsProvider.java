package com.craftjakob.gildednetherite.neoforge.providers.data.tags;

import com.craftjakob.gildednetherite.GildedNetherite;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
	public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
		super(output, registries, GildedNetherite.MOD_ID, helper);
	}
	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {

	}
}
