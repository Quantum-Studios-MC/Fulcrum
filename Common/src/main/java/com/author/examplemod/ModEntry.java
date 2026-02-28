package com.author.examplemod;

import fulcrum.api.*;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemStackBase;

public class ModEntry {
	public static final String modid = "examplemod";
	public static final String modname = "ExampleMod";

	public static void initialize() {
	}

	public static final IItem itemTest = new ItemBase("test").setTexture("test");

	public static void generateItems() {
		Registry.registerItem(itemTest);
	}

	public static void generateRecipes() {
		Registry.registerShapelessRecipe(
			new ItemStackBase(itemTest, 5),
			new ItemStackBase(itemTest, 1)
		);
	}
}
