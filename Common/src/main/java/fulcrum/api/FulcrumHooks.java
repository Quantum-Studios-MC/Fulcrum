package fulcrum.api;

import com.author.examplemod.ModEntry;

public class FulcrumHooks {
	public static void generateItems() {
		ModEntry.generateItems();
	}

	public static void generateRecipes() {
		ModEntry.generateRecipes();
	}
}
