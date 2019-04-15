package lykrast.jetif.compat;

import java.awt.Color;
import java.util.List;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class CompatAtum2 extends JETIFCompat {

	public CompatAtum2() {
		super("atum");
	}

	@Override
	public void addRecipes(List<JETIFWrapper> list) {
		//Luckily all the % are hardcoded
		FluidStack water = new FluidStack(FluidRegistry.WATER, 1000);
		
		//Coin
		//https://github.com/TeamMetallurgy/Atum2/blob/master/src/main/java/com/teammetallurgy/atum/items/ItemCoin.java
		double coinFailChance = 0.1;
		list.add(new WrapperNumbered(water, getModdedItem("atum:coin_gold"), (int)(100*(1-coinFailChance)), getModdedItem("atum:coin_dirty")));
		
		//Loot
		//https://github.com/TeamMetallurgy/Atum2/blob/master/src/main/java/com/teammetallurgy/atum/items/ItemLoot.java
		double lootFailChance = 0.1;
		String[] types = {"idol", "necklace", "ring", "broach", "scepter"};
		String[] qualities = {"silver", "gold", "sapphire", "ruby", "emerald", "diamond"};
		int[] weights = {48, 25, 20, 15, 10, 5};
		
		//Convert into chances
		double totalWeight = 0;
		for (int i = 0; i < weights.length; i++) totalWeight += weights[i];
		for (int i = 0; i < weights.length; i++) weights[i] = (int)(100 * (weights[i] / totalWeight) * (1 - lootFailChance));
		
		for (String s : types) {
			for (int i = 0; i < qualities.length; i++) {
				list.add(new WrapperNumbered(water, getModdedItem("atum:loot_" + qualities[i] + "_" + s), weights[i], getModdedItem("atum:loot_dirty_" + s)));
			}
		}
	}
	
	private static final String INFO = "jetif.atum.chance";
	
	private static class WrapperNumbered extends JETIFWrapper {
		private int chance;

		public WrapperNumbered(FluidStack fluid, ItemStack out, int chance, ItemStack... input) {
			super(fluid, INFO, out, input);
			this.chance = chance;
		}
		
		@Override
		public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
			if (info == null) return;
			
			String text = I18n.format(info, chance);
			
			int width = minecraft.fontRenderer.getStringWidth(text);
			int x = (recipeWidth - width) / 2;
			int y = 35;

			minecraft.fontRenderer.drawString(text, x, y, Color.GRAY.getRGB());
		}
	}

}
