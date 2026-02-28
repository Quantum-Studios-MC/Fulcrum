package fulcrum.api;

import java.util.List;

public interface IRecipe extends IRegistryObject {
	enum Type { SHAPED, SHAPELESS, SMELTING }

	Type getType();
	IItem getOutput();
	int getOutputCount();

	default IItem[][] getPattern() { return null; }
	default List<IItem> getIngredients() { return null; }
	default IItem getInput() { return null; }
}