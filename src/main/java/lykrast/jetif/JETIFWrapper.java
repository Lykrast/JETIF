package lykrast.jetif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreIngredient;

public class JETIFWrapper implements IRecipeWrapper {
	protected List<List<ItemStack>> in;
	protected FluidStack fluid;
	protected ItemStack outItem;
	protected FluidStack outFluid;
	protected boolean consumes;
	
	private JETIFWrapper(FluidStack fluid, boolean consumes, ItemStack... input) {
		this.fluid = fluid;
		this.consumes = consumes;
		in = new ArrayList<>();
		for (ItemStack stack : input) in.add(Collections.singletonList(stack));
	}
	
	//Items in, item out
	public JETIFWrapper(FluidStack fluid, boolean consumeFluid, ItemStack out, ItemStack... input) {
		this(fluid, consumeFluid, input);
		this.outItem = out;
		this.outFluid = null;
	}
	
	//Items in, fluid out
	public JETIFWrapper(FluidStack fluid, boolean consumeFluid, FluidStack out, ItemStack... input) {
		this(fluid, consumeFluid, input);
		this.outFluid = out;
		this.outItem = ItemStack.EMPTY;
	}
	
	//Oredict in, item out, thanks Astral Sorcery for needing that
	public JETIFWrapper(FluidStack fluid, boolean consumeFluid, ItemStack out, String input) {
		this.fluid = fluid;
		this.consumes = consumeFluid;
		in = Collections.singletonList(Arrays.asList(new OreIngredient(input).getMatchingStacks()));
		this.outItem = out;
		this.outFluid = null;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(VanillaTypes.FLUID, Collections.singletonList(fluid));
		if (outFluid != null) ingredients.setOutput(VanillaTypes.FLUID, outFluid);
		ingredients.setOutput(VanillaTypes.ITEM, outItem);
		ingredients.setInputLists(VanillaTypes.ITEM, in);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		if (!consumes) return;
		
		String text;
		if (outFluid == null) text = I18n.format("jetif.consume.fluid");
		else text = I18n.format("jetif.consume.item");
		
		int width = minecraft.fontRenderer.getStringWidth(text);
		int x = recipeWidth - 2 - width;
		int y = 35;

		minecraft.fontRenderer.drawString(text, x, y, 0xFFFF6060);
	}
}
