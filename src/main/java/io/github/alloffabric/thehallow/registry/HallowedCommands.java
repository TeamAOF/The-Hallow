package io.github.alloffabric.thehallow.registry;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.minecraft.server.command.ServerCommandSource;

public class HallowedCommands {
	private HallowedCommands() {
		// NO-OP
	}

	public static void init() {
		CommandRegistry.INSTANCE.register(false, HallowedCommands::register);
	}

	private static void register(CommandDispatcher<ServerCommandSource> dispatcher) {

	}
}
