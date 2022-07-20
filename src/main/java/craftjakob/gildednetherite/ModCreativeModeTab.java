package craftjakob.gildednetherite;

import craftjakob.gildednetherite.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public ModCreativeModeTab(String string) {
	}

	public static final CreativeModeTab GILDED_NETHERITE_TAB = new CreativeModeTab("gilded_netherite_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GILDED_NETHERITE_INGOT.get());
        }
    };
}