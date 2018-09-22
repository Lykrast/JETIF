package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;

public class CompatAstralSorcery extends JETIFCompat {

	public CompatAstralSorcery() {
		super("astralsorcery");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(FluidRegistry.getFluidStack("astralsorcery.liquidstarlight", 1000), true, 
				getModdedItem("astralsorcery:blockcelestialcrystals"), 
				getModdedItem("astralsorcery:itemrockcrystalsimple"), getModdedItem("astralsorcery:itemcraftingcomponent", 1, 2)));
		list.add(new JETIFWrapper(FluidRegistry.getFluidStack("astralsorcery.liquidstarlight", 1000), false, 
				getModdedItem("astralsorcery:blockinfusedwood"), "logWood"));
	}

}
