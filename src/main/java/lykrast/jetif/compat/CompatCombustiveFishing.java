package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatCombustiveFishing extends JETIFCompat {

	public CompatCombustiveFishing() {
		super("combustfish");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				getModdedItem("combustfish:cooled_cod"), getModdedItem("combustfish:combustive_cod")));
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				getModdedItem("combustfish:tempered_swordfish"), getModdedItem("combustfish:searing_swordfish")));
	}

}
