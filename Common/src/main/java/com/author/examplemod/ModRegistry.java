package com.author.examplemod;

import fulcrum.api.Plugin;
import fulcrum.api.Registry;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemStackBase;

public class ModRegistry {
	public static final IItem itemTest = new ItemBase("test").setTexture("test");

	@Plugin.Registry.Item()
	public void generateItems() {
		Registry.registerItem(itemTest);
	}

	public static final IBlock blockTest = new BlockBase("test_block").setTexture("test_block");

	@Plugin.Registry.Block()
	public void generateBlocks() {
		Registry.registerBlock(blockTest);
	}

	@Plugin.Registry.Recipe()
	public void generateRecipes() {
		Registry.registerShapelessRecipe(
			new ItemStackBase(itemTest, 5),
			new ItemStackBase(itemTest, 1)
		);
	}
}
