package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;

public class CompatEvilCraft extends JETIFCompat {

	public CompatEvilCraft() {
		super("evilcraft");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(FluidRegistry.getFluidStack("evilcraftblood", 5000), true, 
				getModdedItem("evilcraft:dark_power_gem"), getModdedItem("evilcraft:dark_gem")));
	}

}
