package fulcrum.cleanroom1122.gen;

import com.author.examplemod.ModEntry;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemStack;
import fulcrum.api.Registry;
import fulcrum.api.recipes.IFurnaceRecipe;
import fulcrum.api.recipes.IRecipe;
import fulcrum.api.recipes.IShapedRecipe;
import fulcrum.api.recipes.IShapelessRecipe;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RecipeGenerator {
	public static void generateRecipesJSON() {
		Collection<IRecipe> recipes = Registry.getRecipes();
		for (IRecipe recipe : recipes) {
			try {
				writeRecipe(recipe);
			} catch (IOException ignored) {
			}
		}
	}

	private static void writeRecipe(IRecipe recipe) throws IOException {
		Map<String, Object> json = new HashMap<>();
		String recipeFile = "";
		if(recipe instanceof IShapedRecipe shapedRecipe) {
			json.put("type", "minecraft:crafting_shaped");
			IItemStack[][] pattern = shapedRecipe.getIngredients();

			Map<IItemStack, Character> symbolMap = new HashMap<>();
			char symbol = 'a';
			List<String> patternList = new ArrayList<>();

			for(IItemStack[] row : pattern) {
				StringBuilder sb = new StringBuilder();
				for(IItemStack cell : row) {
					if(cell == null) {
						sb.append(' ');
					} else {
						if(!symbolMap.containsKey(cell)) symbolMap.put(cell, symbol++);
						sb.append(symbolMap.get(cell));
					}
				}
				patternList.add(sb.toString());
			}
			json.put("pattern", patternList);

			Map<String, Object> keyMap = new HashMap<>();
			for(Map.Entry<IItemStack, Character> entry : symbolMap.entrySet()) {
				keyMap.put(String.valueOf(entry.getValue()), buildIngredients(entry.getKey()));
			}
			json.put("key", keyMap);

			json.put("result", buildResult(shapedRecipe.getOutput()));
			recipeFile = shapedRecipe.getRegistryName();
		}
		if(recipe instanceof IShapelessRecipe shapelessRecipe) {
			json.put("type", "minecraft:crafting_shapeless");
			json.put("ingredients", buildIngredients(shapelessRecipe.getIngredients()));
			json.put("result", buildResult(shapelessRecipe.getOutput()));
			recipeFile = shapelessRecipe.getRegistryName();
		}
		if(recipe instanceof IFurnaceRecipe furnaceRecipe) {
			json.put("type", "minecraft:smelting");
			json.put("ingredient", buildIngredients(furnaceRecipe.getInput()));
			json.put("result", buildResult(furnaceRecipe.getOutput()));
			recipeFile = furnaceRecipe.getRegistryName();
		}

		File output = new File(JSONUtils.getAssetsFile(), "recipes/" + recipeFile + ".json");
		output.getParentFile().mkdirs();
		JSONUtils.writeFile(output, json);
	}

	private static List<String> buildPattern(IItemStack[][] pattern) {
		if(pattern == null) return List.of();
		char symbol = 'a';
		java.util.List<String> rows = new java.util.ArrayList<>();
		for(IItemStack[] row : pattern) {
			StringBuilder sb = new StringBuilder();
			for(IItemStack cell : row) {
				sb.append(cell == null ? ' ' : symbol);
				symbol++;
			}
			rows.add(sb.toString());
		}
		return rows;
	}

	private static Map<String, Object> buildKey(IItemStack[][] pattern) {
		Map<String, Object> map = new HashMap<>();
		char symbol = 'a';
		for(IItemStack[] row : pattern) {
			for(IItemStack cell : row) {
				if(cell != null) {
					map.put(String.valueOf(symbol), buildIngredients(cell));
				}
				symbol++;
			}
		}
		return map;
	}

	private static List<Map<String, Object>> buildIngredients(List<IItemStack> ingredients) {
		List<Map<String, Object>> list = new ArrayList<>();
		for(IItemStack stack : ingredients) {
			list.add(buildIngredients(stack));
		}
		return list;
	}

	private static Map<String, Object> buildResult(IItemStack itemStack) {
		return buildResult(itemStack.getItem(), itemStack.getAmount());
	}

	private static Map<String, Object> buildResult(IItem item, int count) {
		Map<String, Object> r = new HashMap<>();
		r.put("item", ModEntry.modid + ":" + item.getRegistryName());
		r.put("count", count);
		return r;
	}

	private static Map<String, Object> buildIngredients(IItemStack itemStack) {
		return buildIngredients(itemStack.getItem());
	}

	private static Map<String, Object> buildIngredients(IItem item) {
		Map<String, Object> m = new HashMap<>();
		m.put("item", ModEntry.modid + ":" + item.getRegistryName());
		return m;
	}
}
