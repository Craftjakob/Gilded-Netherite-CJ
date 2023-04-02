package craftjakob.gildednetherite.core.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers { //Harvest Level, Durability, Efficiency, Attack Damage, Enchantability 
    public static final ForgeTier GILDED_NETHERITE = new ForgeTier(5, 2555, 10.0F, 5.0F, 20, 
    		BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));
}