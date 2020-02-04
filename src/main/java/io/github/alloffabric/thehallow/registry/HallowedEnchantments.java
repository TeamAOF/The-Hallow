package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.TheHallow;
import io.github.alloffabric.thehallow.enchantment.BeheadingEnchantment;
import io.github.alloffabric.thehallow.enchantment.LifestealEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class HallowedEnchantments {
	public static final Enchantment BEHEADING = register("beheading", new BeheadingEnchantment(Enchantment.Weight.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
	public static final Enchantment LIFESTEAL = register("lifesteal", new LifestealEnchantment(Enchantment.Weight.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

	private HallowedEnchantments() {
		// NO-OP
	}

	public static void init() {
		// NO-OP
	}

	protected static <T extends Enchantment> T register(String name, T enchantment) {
		return Registry.register(Registry.ENCHANTMENT, TheHallow.id(name), enchantment);
	}
}
