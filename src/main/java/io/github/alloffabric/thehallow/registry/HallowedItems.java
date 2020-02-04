package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import io.github.alloffabric.thehallow.item.tool.HallowedMaterial;
import io.github.alloffabric.thehallow.item.tool.ScytheItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class HallowedItems {
	public static final BucketItem WITCH_WATER_BUCKET = register("witch_water_bucket", new BucketItem(HallowedFluids.WITCH_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).group(TheHallow.GROUP).maxCount(1)));
	public static final BucketItem BLOOD_BUCKET = register("blood_bucket", new BucketItem(HallowedFluids.BLOOD, new Item.Settings().recipeRemainder(Items.BUCKET).group(TheHallow.GROUP).maxCount(1)));

	public static final ToolMaterial HALLOWED = new HallowedMaterial();

	public static final Item HALLOWED_INGOT = register("hallowed_ingot", new Item(newSettings().rarity(Rarity.EPIC)));
	public static final Item HALLOWED_NUGGET = register("hallowed_nugget", new Item(newSettings().rarity(Rarity.EPIC)));
	public static final Item REAPERS_SCYTHE = register("reapers_scythe", new ScytheItem(HALLOWED, 3, -2.0F, newSettings().maxCount(1).rarity(Rarity.EPIC)));
	public static final Item SOUL_BOTTLE = register("soul_bottle", new Item(newSettings()));

	public static final Item OLD_CLOTH = register("old_cloth", new Item(newSettings()));

	private HallowedItems() {
		// NO-OP
	}

	static Item.Settings newSettings() {
		return new Item.Settings().group(TheHallow.GROUP);
	}

	public static void init() {

	}

	protected static <T extends Item> T register(String name, T item) {
		return Registry.register(Registry.ITEM, TheHallow.id(name), item);
	}
}
