package fulcrum.cleanroom1122.gen;

import fulcrum.cleanroom1122.CleanroomModEntry;
import fulcrum.cleanroom1122.gen.RecipeRegistrar;

public class Generator {
	public static void main(String[] args) {
		CleanroomModEntry cleanroomModEntry = new CleanroomModEntry();

		ModelRegistrar.registerModels();
		RecipeRegistrar.generateJsons();
	}
}
