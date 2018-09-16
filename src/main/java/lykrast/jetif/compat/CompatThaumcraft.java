package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatThaumcraft extends JETIFCompat {

	public CompatThaumcraft() {
		super("thaumcraft");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				FluidRegistry.getFluidStack("purifying_fluid", 1000), getModdedItem("thaumcraft:bath_salts")));
	}

}
