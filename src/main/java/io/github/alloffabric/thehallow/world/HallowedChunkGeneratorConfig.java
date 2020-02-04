package io.github.alloffabric.thehallow.world;

import io.github.alloffabric.thehallow.registry.HallowedBlocks;
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig;

public class HallowedChunkGeneratorConfig extends OverworldChunkGeneratorConfig {
	public HallowedChunkGeneratorConfig() {
		defaultBlock = HallowedBlocks.TAINTED_STONE.getDefaultState();
		defaultFluid = HallowedBlocks.WITCH_WATER_BLOCK.getDefaultState();
	}
}
