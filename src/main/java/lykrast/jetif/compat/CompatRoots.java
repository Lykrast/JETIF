package lykrast.jetif.compat;

import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 04/06/2019 / 00:23
 * Class: CompatRoots
 * Project: JETIF
 **************************************************/

public class CompatRoots extends JETIFCompat {

    public CompatRoots()
    {
        super("roots");
    }

    @Override
    public void addRecipes(List<JETIFWrapper> list)
    {
        //Elemental Soil to Magmatic Soil
        list.add(new JETIFWrapper(new FluidStack(FluidRegistry.LAVA, 1000), "jetif.roots.magmatic_soil",
                getModdedItem("roots:magmatic_soil"), getModdedItem("roots:elemental_soil")));
        //Elemental Soil to Aqueous Soil
        list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), "jetif.roots.aqueous_soil",
                getModdedItem("roots:aqueous_soil"), getModdedItem("roots:elemental_soil")));
    }
}
