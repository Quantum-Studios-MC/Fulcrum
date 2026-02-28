package fulcrum.api.recipes;

import fulcrum.api.IItem;
import fulcrum.api.IItemStack;

public interface IShapedRecipe extends IRecipe {
	IItemStack getOutput();
	IItemStack[][] getIngredients();
}
