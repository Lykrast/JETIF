package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatAppliedEnergistics2 extends JETIFCompat {

	public CompatAppliedEnergistics2() {
		super("appliedenergistics2");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				getModdedItem("appliedenergistics2:material", 2, 7), 
				getModdedItem("appliedenergistics2:material", 1, 1), new ItemStack(Items.QUARTZ), new ItemStack(Items.REDSTONE)));
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				getModdedItem("appliedenergistics2:material", 1, 10), getModdedItem("appliedenergistics2:crystal_seed", 1, 0)));
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				getModdedItem("appliedenergistics2:material", 1, 11), getModdedItem("appliedenergistics2:crystal_seed", 1, 600)));
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				getModdedItem("appliedenergistics2:material", 1, 12), getModdedItem("appliedenergistics2:crystal_seed", 1, 1200)));
	}

}
