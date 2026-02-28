package fulcrum.forge1710;

import cpw.mods.fml.common.registry.GameRegistry;
import fulcrum.api.IItem;
import fulcrum.api.IRecipe;
import fulcrum.api.ItemBase;
import fulcrum.api.Registry;
import fulcrum.forge1710.game.MCItemBase;

import java.util.*;

public class Registrar {
	public static final List<MCItemBase> ITEMS = new ArrayList<>();

	public static void registerItems() {
		Collection<IItem> list = Registry.getItems();
		for(IItem item : list) {
			if(item instanceof ItemBase) {
				registerItem(new MCItemBase(item));
			}
		}
	}

	public static void registerItem(MCItemBase item) {
		ITEMS.add(item);
	}

	public static MCItemBase findMCItem(IItem item) {
		for (MCItemBase mc : ITEMS) {
			if (mc.getItem().getRegistryName().equals(item.getRegistryName())) {
				return mc;
			}
		}
		return null;
	}

	public static void register() {
		for(MCItemBase item : ITEMS) {
			GameRegistry.registerItem(item, item.getItem().getRegistryName());
		}
	}

	public static void registerRecipes() {
		for (IRecipe recipe : fulcrum.api.Registry.getRecipes()) {
			switch (recipe.getType()) {
				case SHAPED -> addShaped(recipe);
				case SHAPELESS -> addShapeless(recipe);
				case SMELTING -> addSmelting(recipe);
			}
		}
	}

	private static void addShaped(IRecipe recipe) {
		IItem[][] pattern = recipe.getPattern();
		Object[] params = buildPatternParams(pattern);
		GameRegistry.addRecipe(new net.minecraft.item.ItemStack(
			findMCItem(recipe.getOutput()), recipe.getOutputCount()), params);
	}

	private static void addShapeless(IRecipe recipe) {
		java.util.List<IItem> ing = recipe.getIngredients();
		net.minecraft.item.ItemStack output = new net.minecraft.item.ItemStack(
			findMCItem(recipe.getOutput()), recipe.getOutputCount());
		GameRegistry.addShapelessRecipe(output, ing.stream()
			.map(Registrar::toStack).toArray());
	}

	private static void addSmelting(IRecipe recipe) {
		net.minecraft.item.ItemStack in = toStack(recipe.getInput());
		net.minecraft.item.ItemStack out = new net.minecraft.item.ItemStack(
			findMCItem(recipe.getOutput()), recipe.getOutputCount());
		GameRegistry.addSmelting(in, out, 0.0f);
	}

	private static Object[] buildPatternParams(IItem[][] pattern) {
		char symbol = 'A';
		java.util.List<Object> list = new java.util.ArrayList<>();
		for (IItem[] row : pattern) {
			StringBuilder sb = new StringBuilder();
			for (IItem cell : row) {
				sb.append(cell == null ? ' ' : symbol);
				if (cell != null) {
					list.add(symbol);
					list.add(toStack(cell));
				}
				symbol++;
			}
			list.add(sb.toString());
		}
		return list.toArray();
	}

	private static net.minecraft.item.ItemStack toStack(IItem item) {
		MCItemBase mc = findMCItem(item);
		if (mc == null) return null;
		return new net.minecraft.item.ItemStack(mc);
	}
}
