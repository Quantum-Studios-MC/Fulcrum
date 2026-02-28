package fulcrum.api;

import fulcrum.api.recipes.IRecipe;
import fulcrum.api.recipes.ShapedRecipe;
import fulcrum.api.recipes.ShapelessRecipe;
import fulcrum.impl.RegistryType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Registry {
	public static final RegistryType<IItem> itemRegistry = new RegistryType<>();
	private static final RegistryType<IRecipe> recipeRegistry = new RegistryType<>();

	public static void registerItem(IItem item) {
		itemRegistry.register(item);
	}

	public static Collection<IItem> getItems() {
		return itemRegistry.values();
	}

	public static void registerRecipe(IRecipe recipe) {
		recipeRegistry.register(recipe);
	}

	public static void registerShapedRecipe(IItemStack output, IItemStack[][] ingredients) {
		if(output == null || ingredients == null) {
			throw new RuntimeException("Cannot make a shaped recipe with a null argument");
		}
		registerRecipe(new ShapedRecipe("shaped_recipe_" + getRecipesSize(), output, ingredients));
	}

	public static void registerShapelessRecipe(IItemStack output, IItemStack... ingredients) {
		if(output == null || ingredients == null) {
			throw new RuntimeException("Cannot make a shapeless recipe with a null argument");
		}
		List<IItemStack> list = Arrays.asList(ingredients);
		registerRecipe(new ShapelessRecipe("shapeless_recipe_" + getRecipesSize(), output, list));
	}

	public static Collection<IRecipe> getRecipes() {
		return recipeRegistry.values();
	}

	public static int getRecipesSize() {
		return recipeRegistry.size();
	}

}
