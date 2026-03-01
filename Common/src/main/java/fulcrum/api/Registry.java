package fulcrum.api;

import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemStack;
import fulcrum.api.recipes.IRecipe;
import fulcrum.api.recipes.ShapedRecipe;
import fulcrum.api.recipes.ShapelessRecipe;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Registry {
	public static final RegistryType<IItem> ITEMS_REGISTRY = new RegistryType<>();
	private static final RegistryType<IBlock> BLOCKS_REGISTRY = new RegistryType<>();
	private static final RegistryType<IRecipe> RECIPES_REGISTRY = new RegistryType<>();

	public static void registerItem(IItem item) {
		ITEMS_REGISTRY.register(item);
	}

	public static Collection<IItem> getItems() {
		return ITEMS_REGISTRY.values();
	}

	public static String getItemsList() {
		return ITEMS_REGISTRY.toString();
	}

	public static void registerRecipe(IRecipe recipe) {
		RECIPES_REGISTRY.register(recipe);
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
		return RECIPES_REGISTRY.values();
	}

	public static int getRecipesSize() {
		return RECIPES_REGISTRY.size();
	}

	public static void registerBlock(IBlock block) {
		BLOCKS_REGISTRY.register(block);
	}

	public static Collection<IBlock> getBlocks() {
		return BLOCKS_REGISTRY.values();
	}

	public static String getBlocksList() {
		return BLOCKS_REGISTRY.toString();
	}

}
