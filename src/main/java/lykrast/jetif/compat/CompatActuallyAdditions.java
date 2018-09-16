package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;

public class CompatActuallyAdditions extends JETIFCompat {

	public CompatActuallyAdditions() {
		super("actuallyadditions");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(FluidRegistry.getFluidStack("refinedcanolaoil", 1000), false, 
				FluidRegistry.getFluidStack("crystaloil", 1000), getModdedItem("actuallyadditions:item_misc", 1, 23)));
		list.add(new JETIFWrapper(FluidRegistry.getFluidStack("crystaloil", 1000), false, 
				FluidRegistry.getFluidStack("empoweredoil", 1000), getModdedItem("actuallyadditions:item_misc", 1, 24)));
	}

}
