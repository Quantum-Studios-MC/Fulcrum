package fulcrum.api;

import com.author.examplemod.ModEntry;

public class FulcrumHooks {
	public static void generateItems() {
		new ModEntry();
		ModEntry.generateItems();
	}

	public static void generateRecipes() {
		new ModEntry();
		ModEntry.generateRecipes();
	}
}
