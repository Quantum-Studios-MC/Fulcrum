package fulcrum.api.recipes;

import fulcrum.api.items.IItemStack;

public interface IFurnaceRecipe extends IRecipe {
	IItemStack getOutput();
	IItemStack getInput();
}
