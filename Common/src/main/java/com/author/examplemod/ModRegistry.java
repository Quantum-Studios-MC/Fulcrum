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
	public static final IItem itemTest = new ItemBase("test")
		.setTextureName("test");
	public static final IItem itemTest2 = new ItemBase("test2")
		.setTextureName("test2");

	@Plugin.Registry.Item()
	public void generateItems(ItemRegistry registry) {
		registry.registerItem(itemTest);
		registry.registerItem(itemTest2);
	}

	public static final IBlock blockTest = new BlockBase("test_solid_block")
		.setMaterial(BlockMaterial.ROCK)
		.setTextureName("test_solid_block");
	public static final IBlock blockBush = new BlockBushBase("test_bush")
		.setMaterial(BlockMaterial.GROUND).setSound(BlockSound.PLANT)
		.setTextureName("test_bush");

	@Plugin.Registry.Block()
	public void generateBlocks(BlockRegistry registry) {
		registry.registerBlock(blockTest);
		registry.registerBlock(blockBush);
	}

	@Plugin.Registry.Recipe()
	public void generateRecipes(RecipeRegistry registry) {
		registry.registerShapelessRecipe(
			new ItemStackBase(itemTest, 5),
			new ItemStackBase(itemTest, 1)
		);
	}
}
