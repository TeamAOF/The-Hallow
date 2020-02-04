package io.github.alloffabric.thehallow.world.biome;

import io.github.alloffabric.thehallow.world.feature.HallowedBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;

// TODO
public class HallowedRiverBiome extends HallowedBaseBiome {
	public HallowedRiverBiome() {
		super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(Precipitation.NONE).category(Category.RIVER).depth(-0.5f).scale(0.1f).temperature(0.7f).downfall(0.8f).waterColor(0x3F76E4).waterFogColor(0x050533));

		this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));

		HallowedBiomeFeatures.addGrass(this);
		HallowedBiomeFeatures.addLakes(this);
		HallowedBiomeFeatures.addDefaultHallowedTrees(this);
	}
}
