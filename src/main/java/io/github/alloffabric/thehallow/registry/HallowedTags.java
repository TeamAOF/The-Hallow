package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

public class HallowedTags {
	public static class Fluids {
		public static final Tag<Fluid> WITCH_WATER = register("witch_water");
		public static final Tag<Fluid> BLOOD = register("blood");

		public static Tag<Fluid> register(String name) {
			return TagRegistry.fluid(TheHallow.id(name));
		}

		protected static void init() {
			// NO-OP
		}
	}

	public static class Items {
		public static Tag<Item> register(String name) {
			return TagRegistry.item(TheHallow.id(name));
		}

		protected static void init() {
			// NO-OP
		}
	}

	public static class Blocks {
		public static Tag<Block> register(String name) {
			return TagRegistry.block(TheHallow.id(name));
		}

		protected static void init() {
			// NO-OP
		}
	}

	private HallowedTags() {
		// NO-OP
	}

	public static void init() {
		Fluids.init();
		Items.init();
		Blocks.init();
	}
}
