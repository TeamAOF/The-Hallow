package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class HallowedSounds {
	private HallowedSounds() {
		// NO-OP
	}

	public static void init() {
		// NO-OP
	}

	private static SoundEvent register(String name) {
		return Registry.register(Registry.SOUND_EVENT, TheHallow.id(name), new SoundEvent(TheHallow.id(name)));
	}
}
