package fulcrum.api.recipes;

import fulcrum.api.IItemStack;

public class FurnaceRecipe implements IFurnaceRecipe {
	private final IItemStack input;
	private final IItemStack output;

	public FurnaceRecipe(IItemStack output, IItemStack input) {
		this.input = input;
		this.output = output;
	}

	@Override
	public IItemStack getOutput() {
		return output;
	}

	@Override
	public IItemStack getInput() {
		return input;
	}

	@Override
	public String getRegistryName() {
		return "smelting_" + output.getItemName() + "_" + input.getItemName();
	}
}
