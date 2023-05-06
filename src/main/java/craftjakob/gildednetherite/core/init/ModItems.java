package craftjakob.gildednetherite.core.init;

import craftjakob.gildednetherite.GildedNetherite;
import craftjakob.gildednetherite.common.item.GildedNetheriteArmor;
import craftjakob.gildednetherite.common.item.GoldenCore;
import craftjakob.gildednetherite.core.util.ModArmorMaterials;
import craftjakob.gildednetherite.core.util.ModTiers;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GildedNetherite.MODID);
    
    // Material
    public static final RegistryObject<Item> GOLDEN_CORE = ITEMS.register("golden_core",
            () -> new GoldenCore(new Item.Properties().rarity(Rarity.UNCOMMON)));
    
    // Armor
    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = ITEMS.register("gilded_netherite_helmet",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, Type.HELMET, new Item.Properties()
    				.fireResistant().rarity(Rarity.RARE)));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = ITEMS.register("gilded_netherite_chestplate",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, Type.CHESTPLATE, new Item.Properties()
    				.fireResistant().rarity(Rarity.RARE)));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = ITEMS.register("gilded_netherite_leggings",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, Type.LEGGINGS, new Item.Properties()
    				.fireResistant().rarity(Rarity.RARE)));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = ITEMS.register("gilded_netherite_boots",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE, Type.BOOTS, new Item.Properties()
    				.fireResistant().rarity(Rarity.RARE)));

    // Tools
    public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = ITEMS.register("gilded_netherite_sword",
            () -> new SwordItem(ModTiers.GILDED_NETHERITE, 3, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = ITEMS.register("gilded_netherite_pickaxe",
            () -> new PickaxeItem(ModTiers.GILDED_NETHERITE, 1, -2.8f,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GILDED_NETHERITE_AXE = ITEMS.register("gilded_netherite_axe",
            () -> new AxeItem(ModTiers.GILDED_NETHERITE, 5f, -3f,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = ITEMS.register("gilded_netherite_shovel",
            () -> new ShovelItem(ModTiers.GILDED_NETHERITE, 1.5f, -3f,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GILDED_NETHERITE_HOE = ITEMS.register("gilded_netherite_hoe",
            () -> new HoeItem(ModTiers.GILDED_NETHERITE, -5, 0f,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));
}

