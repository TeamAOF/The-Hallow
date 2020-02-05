package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import io.github.alloffabric.thehallow.entity.CrowEntity;
import io.github.alloffabric.thehallow.entity.PumpcownEntity;
import io.github.alloffabric.thehallow.entity.RestlessCactusEntity;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class HallowedEntities {
	public static final EntityType<PumpcownEntity> PUMPCOWN = register("pumpcown", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, PumpcownEntity::new).size(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<CrowEntity> CROW = register("crow", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, CrowEntity::new).size(EntityDimensions.fixed(0.5F, 0.9F)).build());
	public static final EntityType<RestlessCactusEntity> RESTLESS_CACTUS = register("restless_cactus", FabricEntityTypeBuilder.create(EntityCategory.MISC, RestlessCactusEntity::new).size(EntityDimensions.changing(0.9F, 1.0F)).build());

	private HallowedEntities() {
		// NO-OP
	}

	public static void init() {

	}

	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
		return Registry.register(Registry.ENTITY_TYPE, TheHallow.id(name), entity);
	}
}
