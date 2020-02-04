package io.github.alloffabric.thehallow.registry;

import io.github.alloffabric.thehallow.recipe.fluid.FluidRecipe;
import io.github.alloffabric.thehallow.recipe.fluid.FluidRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.Registry;

public class HallowedRecipes {
	public static final RecipeSerializer<FluidRecipe> BLOOD_RECIPE_SERIALIZER = Registry.register(
		Registry.RECIPE_SERIALIZER,
		FluidRecipeSerializer.BLOOD.id,
		FluidRecipeSerializer.BLOOD
	);

	public static final RecipeType<FluidRecipe> BLOOD_RECIPE = Registry.register(
		Registry.RECIPE_TYPE,
		FluidRecipeSerializer.BLOOD.id,
		FluidRecipe.Type.BLOOD
	);

	public static final RecipeSerializer<FluidRecipe> WITCH_WATER_RECIPE_SERIALIZER = Registry.register(
		Registry.RECIPE_SERIALIZER,
		FluidRecipeSerializer.WITCH_WATER.id,
		FluidRecipeSerializer.WITCH_WATER
	);

	public static final RecipeType<FluidRecipe> WITCH_WATER_RECIPE = Registry.register(
		Registry.RECIPE_TYPE,
		FluidRecipeSerializer.WITCH_WATER.id,
		FluidRecipe.Type.WITCH_WATER
	);

	public static void init() {
		// NO-OP
	}

	private HallowedRecipes() {
		// NO-OP
	}
}
