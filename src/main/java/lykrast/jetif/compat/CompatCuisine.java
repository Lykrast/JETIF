package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.UniversalBucket;

public class CompatCuisine extends JETIFCompat {

	public CompatCuisine() {
		super("cuisine");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		if (FluidRegistry.isFluidRegistered("soy_milk"))
		{
			list.add(new JETIFWrapper(FluidRegistry.getFluidStack("soy_milk", Fluid.BUCKET_VOLUME), null, 
					getModdedItem("cuisine:tofu_block"), getModdedItem("cuisine:material", 1, 3)));
		}
	}

}
