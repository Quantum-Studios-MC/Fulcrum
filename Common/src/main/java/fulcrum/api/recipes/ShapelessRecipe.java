package fulcrum.api.recipes;

import fulcrum.api.items.IItemStack;

import java.util.List;

public class ShapelessRecipe implements IShapelessRecipe {
	private final IItemStack output;
	private final List<IItemStack> ingredients;
	private String registryName;

	public ShapelessRecipe(String registryName, IItemStack output, List<IItemStack> ingredients) {
		this.registryName = registryName;
		this.output = output;
		this.ingredients = ingredients;
	}

	@Override
	public IItemStack getOutput() {
		return output;
	}

	@Override
	public List<IItemStack> getIngredients() {
		return ingredients;
	}

	@Override
	public String getRegistryName() {
		return registryName;
	}
}
