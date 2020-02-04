package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class HallowedEntities {
	private HallowedEntities() {
		// NO-OP
	}

	public static void init() {

	}

	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
		return Registry.register(Registry.ENTITY_TYPE, TheHallow.id(name), entity);
	}
}
