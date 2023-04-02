package craftjakob.gildednetherite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import craftjakob.gildednetherite.core.ModCreativeModeTabs;
import craftjakob.gildednetherite.core.init.ModItems;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GildedNetherite.MODID)
public class GildedNetherite {
    public static final String MODID = "gildednetherite";
    private static final Logger LOGGER = LogManager.getLogger();

    public GildedNetherite() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        
        eventBus.addListener(this::commensetup);
        eventBus.addListener(this::addCreative);
    }
    private void commensetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Gilded Netherite is detected!");
    }
    
    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.GILDED_NETHERITE_TAB) {
            event.accept(ModItems.GILDED_NETHERITE_HELMET);
            event.accept(ModItems.GILDED_NETHERITE_CHESTPLATE);
            event.accept(ModItems.GILDED_NETHERITE_LEGGINGS);
            event.accept(ModItems.GILDED_NETHERITE_BOOTS);
            event.accept(ModItems.GILDED_NETHERITE_SWORD);
            event.accept(ModItems.GILDED_NETHERITE_PICKAXE);
            event.accept(ModItems.GILDED_NETHERITE_AXE);
            event.accept(ModItems.GILDED_NETHERITE_SHOVEL);
            event.accept(ModItems.GILDED_NETHERITE_HOE);
            event.accept(ModItems.GOLDEN_CORE);
        }
    }
}   