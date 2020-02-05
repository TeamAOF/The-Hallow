package io.github.alloffabric.thehallow.world.biome;

import io.github.alloffabric.thehallow.registry.HallowedBlocks;
import io.github.alloffabric.thehallow.registry.HallowedFeatures;
import io.github.alloffabric.thehallow.world.feature.HallowedBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.ColumnPlacer;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;

public class GhastlyDesert extends HallowedBaseBiome {
	public static final RandomPatchFeatureConfig RESTLESS_CACTUS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleStateProvider(HallowedBlocks.RESTLESS_CACTUS.getDefaultState()), new ColumnPlacer(1, 2))).tries(10).cannotProject().build();

	public GhastlyDesert() {
		super(new Settings().surfaceBuilder(DESERT_SURFACE_BUILDER).precipitation(Precipitation.NONE).category(Category.DESERT).precipitation(Precipitation.NONE).category(Category.DESERT).depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.0F).waterColor(0x3F76E4).waterFogColor(0x050533));
		
		this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));
		
		this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, HallowedBiomeFeatures.configureFeature(HallowedFeatures.DEADER_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(2)));
		this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(RESTLESS_CACTUS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(10))));
		//this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, HallowedBiomeFeatures.configureFeature(HallowedFeatures.RESTLESS_CACTUS, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(10)));
	}
}
