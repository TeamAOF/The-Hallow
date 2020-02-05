package io.github.alloffabric.thehallow.world.dimension;

import com.github.draylar.worldtraveler.api.dimension.utils.SkyAngleCalculator;
import net.minecraft.util.math.MathHelper;

public class HallowedSkyAngleCalculator implements SkyAngleCalculator {
	// Day fraction function created using https://www.desmos.com/calculator/h5zvtx8jj6
	// and also https://minecraft.gamepedia.com/Day
	static final int cycleStart = 12567;
	static final float cycleStartDayFraction = cycleStart / 24000f;
	static final int cycleEnd = 22900;
	static final float cycleEndDayFraction = cycleEnd / 24000f;
	static final float cycleLength = cycleEnd - cycleStart;

	protected float repeatThisVee(long ticks) {
		return Math.abs(ticks / 24000f - cycleStartDayFraction) + cycleStartDayFraction;
	}

	protected float zigzagDayFunction(long ticks) {
		return repeatThisVee((long) ((ticks - cycleLength - cycleStart) % (2 * cycleLength)));
	}

	protected float waveDayFunction(long ticks) {
		return (
			(float) Math.sin(
				((double) (
					(2 * ticks - cycleStart - cycleEnd) / (2 * cycleLength)
				)) * Math.PI
			)
		) / ((2f * 24000f) / cycleLength) + (cycleStart + cycleEnd) / (2f * 24000f);
	}

	@Override //combination of wave and zigzag day functions
	public float calculate(long ticks, float v) {
		double double_1 = MathHelper.fractionalPart((double) ticks / 24000.0D - 0.25D);
		double double_2 = 0.5D - Math.cos(double_1 * 3.141592653589793D) / 2.0D;
		return (float) (double_1 * 2.0D + double_2) / 3.0F;
	}
}
