package io.github.alloffabric.thehallow.mixin.client;

import io.github.alloffabric.thehallow.block.HallowedSign;
import net.minecraft.block.Block;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlockEntityRenderer.class)
public class SignBlockEntityRendererMixin {
	@Inject(method = "getModelTexture(Lnet/minecraft/block/Block;)Lnet/minecraft/client/util/SpriteIdentifier;", at = @At("HEAD"), cancellable = true)
	private static void getModelTexture(Block block, CallbackInfoReturnable<SpriteIdentifier> info) {
		if (block instanceof HallowedSign) {
			info.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ((HallowedSign) block).getTexture()));
		}
	}
}
