package fulcrum.forge1710;

import com.author.examplemod.ModEntry;
import cpw.mods.fml.common.registry.GameRegistry;
import fulcrum.api.IItem;
import fulcrum.api.IItemStack;
import fulcrum.api.Registry;
import fulcrum.api.recipes.IFurnaceRecipe;
import fulcrum.api.recipes.IRecipe;
import fulcrum.api.recipes.IShapedRecipe;
import fulcrum.api.recipes.IShapelessRecipe;
import fulcrum.forge1710.game.MCItemBase;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipeRegistrar {
	public static void registerRecipes() {
		for (IRecipe recipe : Registry.getRecipes()) {
			if(recipe instanceof IShapelessRecipe shapelessRecipe) {
				addShapeless(shapelessRecipe);
			}
			if(recipe instanceof IShapedRecipe shapedRecipe) {
				addShaped(shapedRecipe);
			}
			if(recipe instanceof IFurnaceRecipe furnaceRecipe) {
				addSmelting(furnaceRecipe);
			}
		}
	}

	private static void addShaped(IShapedRecipe recipe) {
		IItemStack[][] pattern = recipe.getIngredients();
		ItemStack output = toStack(recipe.getOutput());
		Object[] params = buildPatternParams(pattern);
		GameRegistry.addRecipe(output, params);
	}

	private static void addShapeless(IShapelessRecipe recipe) {
		List<IItemStack> ing = recipe.getIngredients();
		ItemStack output = toStack(recipe.getOutput());
		GameRegistry.addShapelessRecipe(output, ing.stream()
			.map(RecipeRegistrar::toStack).toArray());
	}

	private static void addSmelting(IFurnaceRecipe recipe) {
		ItemStack in = toStack(recipe.getInput());
		ItemStack out = toStack(recipe.getOutput());
		GameRegistry.addSmelting(in, out, 0.0f);
	}

	private static Object[] buildPatternParams(IItemStack[][] pattern) {
		List<String> rows = new ArrayList<String>();
		List<Object> mappings = new ArrayList<Object>();
		char symbol = 'A';

		for (IItemStack[] row : pattern) {
			StringBuilder sb = new StringBuilder();
			for (IItemStack cell : row) {
				if(cell == null) {
					sb.append(' ');
				} else {
					sb.append(symbol);
					mappings.add(symbol);
					mappings.add(toStack(cell));
					symbol++;
				}
			}
			rows.add(sb.toString());
		}

		List<Object> result = new ArrayList<Object>();
		result.addAll(rows);
		result.addAll(mappings);
		return result.toArray();
	}


	public static MCItemBase findMCItem(IItem item) {
		return (MCItemBase) GameRegistry.findItem(ModEntry.modid, item.getRegistryName());
	}

	private static ItemStack toStack(IItemStack item) {
		return new ItemStack(findMCItem(item.getItem()), item.getAmount());
	}
}
