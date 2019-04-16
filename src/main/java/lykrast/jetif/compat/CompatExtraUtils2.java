package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatExtraUtils2 extends JETIFCompat {

	public CompatExtraUtils2() {
		super("extrautils2");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.LAVA, 1000), "jetif.extrautils2.well", 
				getModdedItem("extrautils2:ingredients", 1, 11), new ItemStack(Items.GOLD_INGOT)));
	}

}
