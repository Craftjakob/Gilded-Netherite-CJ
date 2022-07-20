package craftjakob.gildednetherite;

import craftjakob.gildednetherite.init.ModBlocks;
import craftjakob.gildednetherite.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GildedNetherite.MODID)
public class GildedNetherite {
    public static final String MODID = "gildednetherite";

    private static final Logger LOGGER = LogManager.getLogger();

    public GildedNetherite() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    
    private void setup(final FMLCommonSetupEvent event) {

        LOGGER.info("Gilded Netherite is loaded!");
    }
}
//https://www.youtube.com/watch?v=PXkroUXxprI
