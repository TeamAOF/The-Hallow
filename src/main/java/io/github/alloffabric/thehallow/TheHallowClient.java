package io.github.alloffabric.thehallow;

import io.github.alloffabric.thehallow.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class TheHallowClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HallowedBlockEntityRenderers.init();
		HallowedRenderLayers.init();
		HallowedClientNetworking.init();
		HallowedColors.init();
		HallowedEntityRenderers.init();

		ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new FluidResourceLoader());
	}
}
