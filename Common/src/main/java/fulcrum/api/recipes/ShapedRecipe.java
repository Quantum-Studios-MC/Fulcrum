package fulcrum.api.recipes;

import fulcrum.api.IItemStack;

public class ShapedRecipe implements IShapedRecipe {
	private final IItemStack output;
	private final IItemStack[][] ingredients;
	private String registryName;

	public ShapedRecipe(String registryName, IItemStack output, IItemStack[][] ingredients) {
		this.registryName = registryName;
		this.output = output;
		this.ingredients = ingredients;
	}

	@Override
	public IItemStack getOutput() {
		return output;
	}

	@Override
	public IItemStack[][] getIngredients() {
		return ingredients;
	}

	@Override
	public String getRegistryName() {
		return registryName;
	}
}
