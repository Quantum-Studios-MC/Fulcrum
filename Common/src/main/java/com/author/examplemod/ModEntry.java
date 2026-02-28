package com.author.examplemod;

import fulcrum.api.IItem;
import fulcrum.api.ItemBase;
import fulcrum.api.RecipeBase;
import fulcrum.api.Registry;

public class ModEntry {
	public static final String modid = "examplemod";
	public static final String modname = "ExampleMod";

	public static void initialize() {
	}

	public static void generateItems() {
		IItem itemTest = new ItemBase("test").setTexture("test");
		Registry.registerItem(itemTest);
	}

	public static void generateRecipes() {
		Registry.registerRecipe(
			RecipeBase.shaped(
				new ItemBase("test").setTexture("test"),
				new IItem[][]{{
					Registry.getItems().iterator().next(),
					null,
					null
				}}
			)
		);
	}
}
