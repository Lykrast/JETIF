package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatTeaTheStory extends JETIFCompat {

	public CompatTeaTheStory() {
		super("teastory");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), null, 
				getModdedItem("teastory:washed_rice"), getModdedItem("teastory:xian_rice")));
	}

}
