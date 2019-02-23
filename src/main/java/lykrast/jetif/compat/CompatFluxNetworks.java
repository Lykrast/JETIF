package lykrast.jetif.compat;

import java.io.File;
import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatFluxNetworks extends JETIFCompat {

	public CompatFluxNetworks() {
		super("fluxnetworks");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		Configuration config = new Configuration(new File("config/flux_networks.cfg"));
		config.load();
		boolean fluxEnabled = config.getBoolean("Disables Flux Recipe (from fire)", "flux_recipe", true, "enables Redstone being turned into Flux when dropped in fire");
		if(fluxEnabled) {
			list.add(new JETIFWrapper(new FluidStack(FluidRegistry.LAVA, 1000), "jetif.fluxnetworks.fire",
					getModdedItem("fluxnetworks:flux"), new ItemStack(Items.REDSTONE)));
		}
	}

}
