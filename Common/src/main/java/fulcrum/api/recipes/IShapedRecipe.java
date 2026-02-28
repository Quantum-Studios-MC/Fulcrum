package fulcrum.api.recipes;

import fulcrum.api.items.IItemStack;

public interface IShapedRecipe extends IRecipe {
	IItemStack getOutput();
	IItemStack[][] getIngredients();
}
