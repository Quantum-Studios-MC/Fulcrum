package com.author.examplemod;

import fulcrum.api.blocks.*;
import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.Plugin;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemStackBase;
import fulcrum.api.registry.RecipeRegistry;

public class ModRegistry {
	public static final IItem ITEM_TEST = new ItemBase("test")
		.setTextureName("test");
	public static final IItem ITEM_TEST_2 = new ItemBase("test2")
		.setTextureName("test2");

	@Plugin.Registry.Item()
	public void generateItems(ItemRegistry registry) {
		registry.registerItem(ITEM_TEST);
		registry.registerItem(ITEM_TEST_2);
	}

	public static final IBlock TEST_SOLID_BLOCK = new BlockBase("test_solid_block")
		.setMaterial(BlockMaterial.ROCK)
		.setTextureName("test_solid_block");
	public static final IBlock TEST_BUSH = new BlockBushBase("test_bush")
		.setMaterial(BlockMaterial.GROUND).setSound(BlockSound.PLANT)
		.setTextureName("test_bush");

	@Plugin.Registry.Block()
	public void generateBlocks(BlockRegistry registry) {
		registry.registerBlock(TEST_SOLID_BLOCK);
		registry.registerBlock(TEST_BUSH);
	}

	@Plugin.Registry.Recipe()
	public void generateRecipes(RecipeRegistry registry) {
		registry.registerShapelessRecipe(
			new ItemStackBase(ITEM_TEST, 5),
			new ItemStackBase(ITEM_TEST, 1)
		);
	}
}
