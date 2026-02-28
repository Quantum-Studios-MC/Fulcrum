package fulcrum.api.recipes;

import fulcrum.api.items.IItemStack;

import java.util.List;

public interface IShapelessRecipe extends IRecipe {
	IItemStack getOutput();
	default List<IItemStack> getIngredients() { return null; }
}
