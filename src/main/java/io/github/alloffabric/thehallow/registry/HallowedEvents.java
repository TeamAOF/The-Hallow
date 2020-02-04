package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.event.WitchTickCallback;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.ActionResult;

public class HallowedEvents {
	public static void init() {
		WitchTickCallback.EVENT.register((witch) -> {
			if (!witch.hasStatusEffect(StatusEffects.WATER_BREATHING)) {
				if (witch.getEntityWorld().hasRain(witch.getBlockPos().up())) {
					witch.damage(DamageSource.DROWN, 4.0F);
				} else if (witch.checkWaterState() && !witch.updateMovementInFluid(HallowedTags.Fluids.WITCH_WATER)) {
					witch.damage(DamageSource.DROWN, 4.0F);
				}
			}
			return ActionResult.PASS;
		});
	}
}
