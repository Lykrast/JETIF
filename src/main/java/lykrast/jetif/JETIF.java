package lykrast.jetif;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = JETIF.MODID, 
	name = JETIF.NAME, 
	version = JETIF.VERSION, 
	acceptedMinecraftVersions = "[1.12, 1.13)")
public class JETIF
{
    public static final String MODID = "jetif";
    public static final String NAME = "Just Enough Throwing In Fluids";
    public static final String VERSION = "@VERSION@";

	public static Logger logger = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
