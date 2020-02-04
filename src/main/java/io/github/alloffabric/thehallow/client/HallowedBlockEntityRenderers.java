package io.github.alloffabric.thehallow.client;

import io.github.alloffabric.thehallow.client.render.TinyPumpkinRenderer;
import io.github.alloffabric.thehallow.registry.HallowedBlockEntities;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class HallowedBlockEntityRenderers {
	public static void init() {
		BlockEntityRendererRegistry.INSTANCE.register(HallowedBlockEntities.TINY_PUMPKIN, TinyPumpkinRenderer::new);
	}
}
