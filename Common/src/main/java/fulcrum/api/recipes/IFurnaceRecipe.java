package fulcrum.api.recipes;

import fulcrum.api.IItemStack;

public interface IFurnaceRecipe extends IRecipe {
	IItemStack getOutput();
	IItemStack getInput();
}
