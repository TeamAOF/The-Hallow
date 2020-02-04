package io.github.alloffabric.thehallow.world.layer;

import io.github.alloffabric.thehallow.world.biome.HallowedBiomeGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.type.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public enum AddBiomesLayer implements IdentitySamplingLayer {
	INSTANCE;

	@Override
	public int sample(LayerRandomnessSource rand, int groupId) {
		HallowedBiomeGroup group = HallowedBiomeGroup.getById(groupId);

		return Registry.BIOME.getRawId(group.pickBiome(rand));
	}
}
