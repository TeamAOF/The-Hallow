package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import io.github.alloffabric.thehallow.block.entity.TinyPumpkinBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class HallowedBlockEntities {
	public static final BlockEntityType<TinyPumpkinBlockEntity> TINY_PUMPKIN = register(
		"tiny_pumpkin",
		TinyPumpkinBlockEntity::new,
		HallowedBlocks.TINY_PUMPKIN,
		HallowedBlocks.TINY_WITCHED_PUMPKIN
	);

	private HallowedBlockEntities() {
		// NO-OP
	}

	public static void init() {
		// NO-OP
	}

	private static <B extends BlockEntity> BlockEntityType<B> register(String name, Supplier<B> supplier, Block... supportedBlocks) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, TheHallow.id(name), BlockEntityType.Builder.create(supplier, supportedBlocks).build(null));
	}
}
