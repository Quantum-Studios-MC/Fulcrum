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
	public static final RegistryType<IItem> itemRegistry = new RegistryType<>();
	private static final RegistryType<IBlock> blockRegistry = new RegistryType<>();
	private static final RegistryType<IRecipe> recipeRegistry = new RegistryType<>();

	public static void registerItem(IItem item) {
		itemRegistry.register(item);
	}

	public static Collection<IItem> getItems() {
		return itemRegistry.values();
	}

	public static String getItemsList() {
		return itemRegistry.toString();
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

	public static void registerBlock(IBlock block) {
		blockRegistry.register(block);
	}

	public static Collection<IBlock> getBlocks() {
		return blockRegistry.values();
	}

	public static String getBlocksList() {
		return blockRegistry.toString();
	}

}
