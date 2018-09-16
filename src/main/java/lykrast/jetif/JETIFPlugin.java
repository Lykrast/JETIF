package lykrast.jetif;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lykrast.jetif.compat.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JETIFPlugin implements IModPlugin {
	@Override
	public void register(IModRegistry registry) {
		List<JETIFWrapper> list = new ArrayList<>();
		List<JETIFCompat> compats = new ArrayList<>();
		
		compats.add(new CompatCombustiveFishing());
		
		//Sort them alphabetically
		Collections.sort(compats);
		
		for (JETIFCompat com : compats) if (com.shouldLoad()) com.addRecipes(list);
		registry.addRecipes(list, JETIF.MODID);
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new JETIFCategory(registry.getJeiHelpers().getGuiHelper()));
	}
}
