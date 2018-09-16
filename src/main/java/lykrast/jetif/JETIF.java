package lykrast.jetif;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = JETIF.MODID, 
	name = JETIF.NAME, 
	version = JETIF.VERSION, 
	acceptedMinecraftVersions = "[1.12, 1.13)",
	dependencies = "required-after:jei@[4.12,)")
public class JETIF
{
    public static final String MODID = "jetif";
    public static final String NAME = "Just Enough Throwing In Fluids";
    public static final String VERSION = "@VERSION@";

	public static Logger logger = LogManager.getLogger(MODID);
}
