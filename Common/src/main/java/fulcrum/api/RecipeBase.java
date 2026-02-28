package fulcrum.api;

import java.util.Arrays;
import java.util.List;

public class RecipeBase implements IRecipe {
	private final Type type;
	private final IItem output;
	private final int outputCount;
	private IItem[][] pattern;
	private List<IItem> ingredients;
	private IItem input;

	private RecipeBase(Type type, IItem output, int count) {
		this.type = type;
		this.output = output;
		this.outputCount = count;
	}

	public static RecipeBase shaped(IItem output, IItem[][] pattern) {
		RecipeBase r = new RecipeBase(Type.SHAPED, output, 1);
		r.pattern = pattern;
		return r;
	}

	public static RecipeBase shaped(IItem output, int count, IItem[][] pattern) {
		RecipeBase r = new RecipeBase(Type.SHAPED, output, count);
		r.pattern = pattern;
		return r;
	}

	public static RecipeBase shapeless(IItem output, List<IItem> ingredients) {
		RecipeBase r = new RecipeBase(Type.SHAPELESS, output, 1);
		r.ingredients = ingredients;
		return r;
	}

	public static RecipeBase shapeless(IItem output, int count, List<IItem> ingredients) {
		RecipeBase r = new RecipeBase(Type.SHAPELESS, output, count);
		r.ingredients = ingredients;
		return r;
	}

	public static RecipeBase smelting(IItem input, IItem output) {
		RecipeBase r = new RecipeBase(Type.SMELTING, output, 1);
		r.input = input;
		return r;
	}

	public static RecipeBase smelting(IItem input, IItem output, int count) {
		RecipeBase r = new RecipeBase(Type.SMELTING, output, count);
		r.input = input;
		return r;
	}

	@Override
	public Type getType() { return type; }

	@Override
	public String getRegistryName() {
		return output.getRegistryName() + "_recipe";
	}

	@Override
	public IItem getOutput() { return output; }

	@Override
	public int getOutputCount() { return outputCount; }

	@Override
	public IItem[][] getPattern() { return pattern; }

	@Override
	public List<IItem> getIngredients() { return ingredients; }

	@Override
	public IItem getInput() { return input; }
}