package lykrast.jetif.compat;

import lykrast.jetif.JETIF;
import lykrast.jetif.JETIFCompat;
import lykrast.jetif.JETIFWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.List;

public class CompatAppliedEnergistics2 extends JETIFCompat {

    public CompatAppliedEnergistics2() {
        super("appliedenergistics2");
    }

    @Override
    public void addRecipes(List<JETIFWrapper> list) {
        boolean doFluix = false, doPurify = false;
        try {
            Class<?> config = Class.forName("appeng.core.AEConfig", false, getClass().getClassLoader());
            Object instance = ObfuscationReflectionHelper.findMethod(config, "instance", config).invoke(null);
            Field featureSet = ObfuscationReflectionHelper.findField(config, "featureFlags");

            Class<?> featureEnum = Class.forName("appeng.core.features.AEFeature", false, getClass().getClassLoader());
            Method featureKey = ObfuscationReflectionHelper.findMethod(featureEnum, "key", String.class);
            //Object[] features = featureEnum.getEnumConstants();

            EnumSet<?> featureFlags = (EnumSet<?>) featureSet.get(instance);

            for (Object f : featureFlags) {
                if (!doFluix && (featureKey.invoke(f)).equals("InWorldFluix")) {
                    doFluix = true;
                }

                if (!doPurify && (featureKey.invoke(f)).equals("InWorldPurification")) {
                    doPurify = true;
                }
            }
        } catch (Exception e) {
            JETIF.logger.warn("Couldn't load config field(s) for AE2, report this issue on JETIF's GitHub");
            e.printStackTrace();
        }

        JETIF.logger.debug("AE2 Integration - Fluix: {}, Purification: {}", doFluix, doPurify);
        if (doFluix) {
            list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), null,
                    getModdedItem("appliedenergistics2:material", 2, 7),
                    getModdedItem("appliedenergistics2:material", 1, 1), new ItemStack(Items.QUARTZ), new ItemStack(Items.REDSTONE)));
        }
        if (doPurify) {
            list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), null,
                    getModdedItem("appliedenergistics2:material", 1, 10), getModdedItem("appliedenergistics2:crystal_seed", 1, 0)));
            list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), null,
                    getModdedItem("appliedenergistics2:material", 1, 11), getModdedItem("appliedenergistics2:crystal_seed", 1, 600)));
            list.add(new JETIFWrapper(new FluidStack(FluidRegistry.WATER, 1000), null,
                    getModdedItem("appliedenergistics2:material", 1, 12), getModdedItem("appliedenergistics2:crystal_seed", 1, 1200)));
        }
    }

}
