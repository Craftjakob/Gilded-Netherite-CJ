package craftjakob.gildednetherite.init;

import craftjakob.gildednetherite.GildedNetherite;
import craftjakob.gildednetherite.ModCreativeModeTab;
import craftjakob.gildednetherite.common.item.GildedNetheriteArmor;
import craftjakob.gildednetherite.common.item.ModArmorMaterials;
import craftjakob.gildednetherite.common.item.ModTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GildedNetherite.MODID);
    
    
    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = ITEMS.register("gilded_netherite_helmet",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE_INGOT, EquipmentSlot.HEAD, new Item.Properties()
    				.tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = ITEMS.register("gilded_netherite_chestplate",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE_INGOT, EquipmentSlot.CHEST, new Item.Properties()
    				.tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = ITEMS.register("gilded_netherite_leggings",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE_INGOT, EquipmentSlot.LEGS, new Item.Properties()
    				.tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = ITEMS.register("gilded_netherite_boots",
    		() -> new GildedNetheriteArmor(ModArmorMaterials.GILDED_NETHERITE_INGOT, EquipmentSlot.FEET, new Item.Properties()
    				.tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));

    
    public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = ITEMS.register("gilded_netherite_sword",
            () -> new SwordItem(ModTiers.GILDED, 3, -2.4F,
                    new Item.Properties().tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = ITEMS.register("gilded_netherite_pickaxe",
            () -> new PickaxeItem(ModTiers.GILDED, 1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_AXE = ITEMS.register("gilded_netherite_axe",
            () -> new AxeItem(ModTiers.GILDED, 5f, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = ITEMS.register("gilded_netherite_shovel",
            () -> new ShovelItem(ModTiers.GILDED, 1.5f, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_HOE = ITEMS.register("gilded_netherite_hoe",
            () -> new HoeItem(ModTiers.GILDED, -5, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
   
    
    public static final RegistryObject<Item> GILDED_NETHERITE_INGOT = ITEMS.register("gilded_netherite_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.GILDED_NETHERITE_TAB).fireResistant()));
    
    
    public static void register(IEventBus eventBus) {
	ITEMS.register(eventBus);
	}

}

