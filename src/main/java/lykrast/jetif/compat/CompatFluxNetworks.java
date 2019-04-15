package lykrast.jetif.compat;

import java.lang.reflect.Field;
import java.util.List;

import lykrast.jetif.JETIF;
import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

//TODO: find the way forge wants to be used
@SuppressWarnings("deprecation")
public class CompatFluxNetworks extends JETIFCompat {

	public CompatFluxNetworks() {
		super("fluxnetworks");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		if (shouldRegister()) {
			list.add(new JETIFWrapper(new FluidStack(FluidRegistry.LAVA, 1000), "jetif.fluxnetworks.fire", 
					getModdedItem("fluxnetworks:flux"), new ItemStack(Items.REDSTONE)));
		}
	}
	
	private boolean shouldRegister() {
		//Register if config is not found or if it is found and it's active
		try {
			Class<?> config = ReflectionHelper.getClass(getClass().getClassLoader(), "sonar.flux.FluxConfig");
			Field field = ReflectionHelper.findField(config, "enableFluxRecipe");
			return (Boolean)field.get(null);
		} catch (Exception e) {
			JETIF.logger.warn("Couldn't load config field for Flux Networks, report this issue on JETIF's GitHub");
			e.printStackTrace();
			return true;
		}
	}

}
