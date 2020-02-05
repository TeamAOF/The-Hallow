package io.github.alloffabric.thehallow;

import io.github.alloffabric.thehallow.registry.*;
import io.github.alloffabric.thehallow.world.HallowedChunkGeneratorType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TheHallow implements ModInitializer {
	public static final String MOD_ID = "thehallow";
	public static final Logger LOGGER = LogManager.getLogger("The Hallow");
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(HallowedItems.REAPERS_SCYTHE));
	public static final ItemGroup PUMPKINS = FabricItemGroupBuilder.build(id("pumpkins"), () -> new ItemStack(HallowedBlocks.WITCHED_PUMPKIN));
	public static final SignType DEADWOOD_SIGN_TYPE = new SignTypeAccess("thehallow:deadwood");

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		HallowedConfig.sync();
		HallowedEntities.init();
		HallowedBlocks.init();
		HallowedItems.init();
		HallowedRecipes.init();
		HallowedBlockEntities.init();
		HallowedEnchantments.init();
		HallowedCommands.init();
		HallowedFeatures.init();
		HallowedBiomes.init();
		HallowedWorldGen.init();
		HallowedChunkGeneratorType.init();
		HallowedDimensions.init();
		HallowedEvents.init();
		HallowedSounds.init();
		HallowedFluids.init();
		HallowedTags.init();
		HallowedNetworking.init();
		HallowedEvents.init();
	}

	private static class SignTypeAccess extends SignType {
		public SignTypeAccess(String name) {
			super(name);
		}
	}
}
