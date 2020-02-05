package io.github.alloffabric.thehallow.client;

import io.github.alloffabric.thehallow.client.render.CrowEntityRenderer;
import io.github.alloffabric.thehallow.client.render.HallowedCactusEntityRenderer;
import io.github.alloffabric.thehallow.client.render.PumpcownEntityRenderer;
import io.github.alloffabric.thehallow.registry.HallowedEntities;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class HallowedEntityRenderers {
	public static void init() {
		EntityRendererRegistry.INSTANCE.register(HallowedEntities.PUMPCOWN, (dispatcher, context) -> new PumpcownEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(HallowedEntities.CROW, (dispatcher, context) -> new CrowEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(HallowedEntities.RESTLESS_CACTUS, (dispatcher, context) -> new HallowedCactusEntityRenderer(dispatcher));
	}
}
