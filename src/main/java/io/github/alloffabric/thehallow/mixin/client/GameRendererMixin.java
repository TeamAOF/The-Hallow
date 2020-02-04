package io.github.alloffabric.thehallow.mixin.client;

import io.github.alloffabric.thehallow.HallowedConfig;
import io.github.alloffabric.thehallow.api.HallowedBiomeInfo;
import io.github.alloffabric.thehallow.registry.HallowedDimensions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
	@Inject(at = @At("RETURN"), method = "getViewDistance()F", cancellable = true)
	private void getHallowViewDistance(final CallbackInfoReturnable<Float> info) {
		final MinecraftClient client = MinecraftClient.getInstance();
		final World world = client.world;

		if (world.getDimension().getType() == HallowedDimensions.THE_HALLOW) {
			final PlayerEntity player = client.player;
			float totalIntensity = 0;
			int count = 0;
			final int radius = HallowedConfig.HallowedFog.fogSmoothingRadius;
			for (int x = 0; x < radius; x++) {
				for (int z = 0; z < radius; z++) {
					final BlockPos pos = player.getBlockPos().add(x - (radius / 2), 0, z - (radius / 2));

					if (world.getBiomeAccess().getBiome(pos) instanceof HallowedBiomeInfo) {
						final HallowedBiomeInfo biomeInfo = (HallowedBiomeInfo) world.getBiomeAccess().getBiome(pos);
						totalIntensity += biomeInfo.getFogIntensity();
						count++;
					}
				}
			}

			final float distance = totalIntensity / count;
			if (distance < info.getReturnValue()) {
				info.setReturnValue(distance);
			}
		}
	}
}
