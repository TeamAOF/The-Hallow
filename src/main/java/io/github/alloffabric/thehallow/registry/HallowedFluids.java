package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import io.github.alloffabric.thehallow.fluid.BloodFluid;
import io.github.alloffabric.thehallow.fluid.WitchWaterFluid;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

public class HallowedFluids {
	public static final BaseFluid WITCH_WATER = register("witch_water", new WitchWaterFluid.Still());
	public static final BaseFluid FLOWING_WITCH_WATER = register("witch_water_flowing", new WitchWaterFluid.Flowing());

	public static final BaseFluid BLOOD = register("blood", new BloodFluid.Still());
	public static final BaseFluid FLOWING_BLOOD = register("blood_flowing", new BloodFluid.Flowing());

	private HallowedFluids() {
		// NO-OP
	}

	public static void init() {
		// NO-OP
	}

	static <T extends Fluid> T register(String name, T fluid) {
		T b = Registry.register(Registry.FLUID, TheHallow.id(name), fluid);
		return b;
	}
}
