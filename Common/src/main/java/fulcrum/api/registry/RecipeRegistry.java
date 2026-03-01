package fulcrum.api.registry;

import fulcrum.api.RegistryType;
import fulcrum.api.items.IItemStack;
import fulcrum.api.recipes.IRecipe;
import fulcrum.api.recipes.ShapedRecipe;
import fulcrum.api.recipes.ShapelessRecipe;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RecipeRegistry {
	private static final RegistryType<IRecipe> RECIPES_REGISTRY = new RegistryType<>();
	private static final RecipeRegistry REGISTRY = new RecipeRegistry();

	private RecipeRegistry() {}

	public static RecipeRegistry getInstance() {
		return REGISTRY;
	}

	public void registerRecipe(IRecipe recipe) {
		RECIPES_REGISTRY.register(recipe);
	}

	public void registerShapedRecipe(IItemStack output, IItemStack[][] ingredients) {
		if(output == null || ingredients == null) {
			throw new RuntimeException("Cannot make a shaped recipe with a null argument");
		}
		registerRecipe(new ShapedRecipe("shaped_recipe_" + getRecipesSize(), output, ingredients));
	}

	public void registerShapelessRecipe(IItemStack output, IItemStack... ingredients) {
		if(output == null || ingredients == null) {
			throw new RuntimeException("Cannot make a shapeless recipe with a null argument");
		}
		List<IItemStack> list = Arrays.asList(ingredients);
		registerRecipe(new ShapelessRecipe("shapeless_recipe_" + getRecipesSize(), output, list));
	}

	public static Collection<IRecipe> getRecipes() {
		return RECIPES_REGISTRY.values();
	}

	public static int getRecipesSize() {
		return RECIPES_REGISTRY.size();
	}
}
