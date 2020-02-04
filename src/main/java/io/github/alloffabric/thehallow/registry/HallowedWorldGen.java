package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.world.biome.HallowedBiomeGroup;
import io.github.alloffabric.thehallow.world.layer.AddHallowedEdgeLayer;
import io.github.alloffabric.thehallow.world.layer.AddHallowedShoreLayer;
import io.github.alloffabric.thehallow.world.layer.AddSubBiomesLayer;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.world.biome.Biome;

public class HallowedWorldGen {
	public static final HallowedBiomeGroup HALLOW = new HallowedBiomeGroup(0)
		.addBiome(HallowedBiomes.HALLOWED_FOREST, 1);

	public static final HallowedBiomeGroup SEA_ISLANDS = new HallowedBiomeGroup(1)
		.addBiome(HallowedBiomes.HALLOWED_SEA, 1);

	private HallowedWorldGen() {
		// NO-OP
	}

	public static void init() {
		addHillsSubBiome(HallowedBiomes.HALLOWED_FOREST, HallowedBiomes.HALLOWED_FOREST_HILLS);

		// Islands
		addSmallSubBiome(HallowedBiomes.HALLOWED_SEA, HallowedBiomes.HALLOWED_FOREST, 0.22f);

		// Rivers
		setRiverBiome(HallowedBiomes.HALLOWED_SEA, null);
		setRiverBiome(HallowedBiomes.HALLOWED_SHORE, HallowedBiomes.HALLOWED_SEA);

		// Make HALLOWED more common by adding twice
		addBiomeGroups(HALLOW, HALLOW, SEA_ISLANDS);
	}

	public static void addBiomeGroups(HallowedBiomeGroup... biomeGroups) {
		for (HallowedBiomeGroup group : biomeGroups) {
			HallowedBiomeGroup.addBiomeGroup(group);
		}
	}

	public static void addLargeSubBiome(Biome parent, Biome subBiome, double chance) {
		AddSubBiomesLayer.LARGE.addSubBiome(parent, subBiome, chance);
	}

	public static void addSmallSubBiome(Biome parent, Biome subBiome, double chance) {
		AddSubBiomesLayer.SMALL.addSubBiome(parent, subBiome, chance);
	}

	public static void addHillsSubBiome(Biome parent, Biome hillsBiome) {
		AddSubBiomesLayer.HILLS.addSubBiome(parent, hillsBiome, 0.3f);
	}

	public static void setRiverBiome(Biome parent, Biome river) {
		OverworldBiomes.setRiverBiome(parent, river);
	}

	public static void setEdgeBiome(Biome parent, Biome edge) {
		AddHallowedEdgeLayer.INSTANCE.setEdgeBiome(parent, edge);
	}

	public static void setShoreBiome(Biome parent, Biome shore) {
		AddHallowedShoreLayer.DEFAULT.setEdgeBiome(parent, shore);
	}
}
