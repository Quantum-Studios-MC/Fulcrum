package fulcrum.api;

import fulcrum.impl.ItemRegistry;

import java.util.Collection;

public class Registry {
	public static final ItemRegistry itemRegistry = new ItemRegistry();
	private static final fulcrum.impl.Registry<IRecipe> recipeRegistry = new fulcrum.impl.Registry<>();

	public static void registerItem(IItem item) {
		itemRegistry.register(item);
	}

	public static Collection<IItem> getItems() {
		return itemRegistry.values();
	}

	public static void registerRecipe(IRecipe recipe) {
		recipeRegistry.register(recipe);
	}

	public static Collection<IRecipe> getRecipes() {
		return recipeRegistry.values();
	}
}
