package io.github.alloffabric.thehallow.world.biome;

import com.google.common.collect.ImmutableSet;
import io.github.alloffabric.thehallow.world.layer.HallowedBiomeLayers;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

public class HallowedBiomeSource extends BiomeSource {

	public final BiomeLayerSampler biomeSampler;

	public HallowedBiomeSource(long seed) {
		super(ImmutableSet.of(
			Biomes.FOREST));

		biomeSampler = HallowedBiomeLayers.build(seed);
	}

	@Override
	public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) { // these represent sub chunk values, not xyz
		return biomeSampler.sample(biomeX, biomeZ);
	}
}
