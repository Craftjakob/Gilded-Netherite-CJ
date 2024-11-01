package com.craftjakob.gildednetherite.common.item;

import java.util.List;

import com.craftjakob.gildednetherite.configs.ClientConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class GildedNetheriteArmor extends ArmorItem {
    public GildedNetheriteArmor(ArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);
    }
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
    	if (ClientConfig.ItemTooltips.getValue()) {
    		components.add(Component.translatable("tooltip.gildednetherite.gilded_netherite_armor").withStyle(ChatFormatting.BLUE));
    	} 
    	super.appendHoverText(stack, level, components, tooltipFlag);
    }
}