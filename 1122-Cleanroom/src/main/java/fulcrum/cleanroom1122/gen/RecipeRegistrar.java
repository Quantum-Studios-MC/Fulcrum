package fulcrum.cleanroom1122.gen;

import com.author.examplemod.ModEntry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fulcrum.api.IRecipe;
import fulcrum.api.IItem;
import fulcrum.cleanroom1122.Registrar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeRegistrar {
	public static void generateJsons() {
		Collection<IRecipe> recipes = fulcrum.api.Registry.getRecipes();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		for (IRecipe recipe : recipes) {
			try {
				writeRecipe(recipe, gson);
			} catch (IOException ignored) {
			}
		}
	}

	private static void writeRecipe(IRecipe recipe, Gson gson) throws IOException {
		Map<String, Object> json = new HashMap<>();
		switch (recipe.getType()) {
			case SHAPED:
				json.put("type", "crafting_shaped");
				var pattern = recipe.getPattern();
				json.put("pattern", buildPattern(pattern));
				json.put("key", buildKey(pattern));
				json.put("result", buildResult(recipe));
				break;
			case SHAPELESS:
				json.put("type", "crafting_shapeless");
				json.put("ingredients", buildIngredients(recipe.getIngredients()));
				json.put("result", buildResult(recipe));
				break;
			case SMELTING:
				json.put("type", "smelting");
				json.put("ingredient", buildIngredient(recipe.getInput()));
				json.put("result", buildResult(recipe));
				break;
		}

		File output = new File("src/main/resources/assets/" + ModEntry.modid + "/recipes/" + recipe.getOutput().getRegistryName() + ".json");
		output.getParentFile().mkdirs();
		try (FileWriter writer = new FileWriter(output)) {
			gson.toJson(json, writer);
		}
	}

	private static List<String> buildPattern(IItem[][] pattern) {
		if (pattern == null) return List.of();
		char symbol = 'a';
		java.util.List<String> rows = new java.util.ArrayList<>();
		for (IItem[] row : pattern) {
			StringBuilder sb = new StringBuilder();
			for (IItem cell : row) {
				sb.append(cell == null ? ' ' : symbol);
				symbol++;
			}
			rows.add(sb.toString());
		}
		return rows;
	}

	private static Map<String, Object> buildKey(IItem[][] pattern) {
		Map<String, Object> map = new HashMap<>();
		char symbol = 'a';
		for (IItem[] row : pattern) {
			for (IItem cell : row) {
				if (cell != null) {
					map.put(String.valueOf(symbol), buildIngredient(cell));
				}
				symbol++;
			}
		}
		return map;
	}

	private static Object buildIngredients(List<IItem> ingredients) {
		return ingredients;
	}

	private static Map<String, Object> buildResult(IRecipe recipe) {
		Map<String, Object> r = new HashMap<>();
		r.put("item", ModEntry.modid + ":" + recipe.getOutput().getRegistryName());
		r.put("count", recipe.getOutputCount());
		return r;
	}

	private static Map<String, Object> buildIngredient(IItem item) {
		Map<String, Object> m = new HashMap<>();
		m.put("item", ModEntry.modid + ":" + item.getRegistryName());
		return m;
	}

}
