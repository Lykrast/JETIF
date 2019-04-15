package lykrast.jetif.compat;

import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatDeepMobLearning extends JETIFCompat {

	public CompatDeepMobLearning() {
		super("deepmoblearning");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), null, 
				getModdedItem("deepmoblearning:glitch_infused_ingot"), 
				getModdedItem("deepmoblearning:glitch_fragment"), new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()), new ItemStack(Items.GOLD_INGOT)));
	}

}
