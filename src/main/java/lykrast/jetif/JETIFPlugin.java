package lykrast.jetif;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

@JEIPlugin
public class JETIFPlugin implements IModPlugin {
	@Override
	public void register(IModRegistry registry) {
		List<JETIFWrapper> list = new ArrayList<>();
		
		//Placeholder
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), true, 
				new ItemStack(Blocks.OBSIDIAN), new ItemStack(Items.BLAZE_POWDER)));
		
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), false, 
				new ItemStack(Blocks.OBSIDIAN), new ItemStack(Items.MAGMA_CREAM)));
		
		list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), true, 
				new FluidStack(FluidRegistry.LAVA, 2000), new ItemStack(Items.MAGMA_CREAM), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.LAVA_BUCKET)));
		
		registry.addRecipes(list, JETIF.MODID);
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new JETIFCategory(registry.getJeiHelpers().getGuiHelper()));
	}
}
