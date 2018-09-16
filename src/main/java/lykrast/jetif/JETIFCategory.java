package lykrast.jetif;

import java.util.List;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class JETIFCategory implements IRecipeCategory<JETIFWrapper> {
	public static final ResourceLocation BACKGROUND = new ResourceLocation(JETIF.MODID, "textures/gui/jei.png");
	public static final ResourceLocation ICON = new ResourceLocation(JETIF.MODID, "textures/gui/icon.png");
	private IDrawable background, icon;
	
	public JETIFCategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(BACKGROUND, 0, 0, 140, 32).addPadding(0, 12, 0, 0).build();
		icon = guiHelper.drawableBuilder(ICON, 0, 0, 16, 16).setTextureSize(16, 16).build();
	}
	
	@Override
	public String getUid() {
		return JETIF.MODID;
	}

	@Override
	public String getTitle() {
		return I18n.format(JETIF.MODID + ".category");
	}

	@Override
	public String getModName() {
		return JETIF.MODID;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, JETIFWrapper recipeWrapper, IIngredients ingredients) {
		List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
		List<List<FluidStack>> outputFluid = ingredients.getOutputs(VanillaTypes.FLUID);
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		IGuiFluidStackGroup guiFluidStacks = recipeLayout.getFluidStacks();
		
		//Fluid to throw stuff in
		guiFluidStacks.init(0, true, 67, 15, 16, 16, 1000, false, null);
	
		//Output
		if (outputFluid.size() > 0) guiFluidStacks.init(1, false, 123, 15, 16, 16, 1000, false, null);
		guiItemStacks.init(0, false, 122, 14);
		
		//Input
		int offset = inputs.size() - 1;
		for (int i = 0; i <= offset; i++) guiItemStacks.init(i + 1, true, 36 - (offset - i) * 18, 14);
		
		guiItemStacks.set(ingredients);
		guiFluidStacks.set(ingredients);
	}
}
