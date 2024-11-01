package com.craftjakob.gildednetherite.common.item;

import java.util.List;

import com.craftjakob.gildednetherite.configs.ClientConfig;
import com.craftjakob.gildednetherite.configs.CommonConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class GoldenCore extends Item {
    public GoldenCore(Properties Properties) {
		super(Properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipList, TooltipFlag flag) {
		if (ClientConfig.ItemTooltips.getValue()) {
			if (ClientConfig.GoldenCoreTooltip.getValue()) {
				if (CommonConfig.TradeWithPiglinsForGoldenCore.getValue()) {
					tooltipList.add(Component.translatable("tooltip.gildednetherite.golden_core_from_piglin").withStyle(ChatFormatting.GRAY));
				}
				if (CommonConfig.GoldenCoreInBastionTreasureChest.getValue() || CommonConfig.GoldenCoreInBastionBridgeChest.getValue() || CommonConfig.GoldenCoreInBastionHoglinStableChest.getValue() || CommonConfig.GoldenCoreInBastionOtherChest.getValue() || CommonConfig.GoldenCoreInNetherBridgeChest.getValue()) {
					tooltipList.add(Component.translatable("tooltip.gildednetherite.golden_core_from_nether_chests").withStyle(ChatFormatting.GRAY));
				}
			}
		}
		super.appendHoverText(stack, context, tooltipList, flag);
	}
}