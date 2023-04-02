package craftjakob.gildednetherite.common.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class GoldenCore extends Item {
    public GoldenCore(Properties Properties) {
		super(Properties);
	}
	@Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
    	{
    		components.add(Component.translatable("tooltip.gildednetherite.golden_core.description").withStyle(ChatFormatting.GRAY));
    	} 
    	super.appendHoverText(stack, level, components, tooltipFlag);
    }
}

