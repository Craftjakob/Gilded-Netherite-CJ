package craftjakob.gildednetherite.core;

import craftjakob.gildednetherite.GildedNetherite;
import craftjakob.gildednetherite.core.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

	@Mod.EventBusSubscriber(modid = GildedNetherite.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public class ModCreativeModeTabs {
		public static CreativeModeTab GILDED_NETHERITE_TAB;

		@SubscribeEvent
		public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
			GILDED_NETHERITE_TAB = event.registerCreativeModeTab(new ResourceLocation(GildedNetherite.MODID, "gilded_netherite_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.GILDED_NETHERITE_CHESTPLATE.get()))
					.title(Component.translatable("creativemodetab.gilded_netherite_tab")));
		}
}