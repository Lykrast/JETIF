package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatFluxNetworks extends JETIFCompat {

	public CompatFluxNetworks() {
		super("fluxnetworks");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		//TODO: find a way to make fire render
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.LAVA, 1000), "jetif.fluxnetworks.fire", 
				getModdedItem("fluxnetworks:flux"), new ItemStack(Items.REDSTONE)));
	}

}
