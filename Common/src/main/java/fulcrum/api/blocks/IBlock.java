package fulcrum.api.blocks;

import fulcrum.api.IRegistryObject;
import fulcrum.api.creativetabs.ICreativeTab;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemType;

public interface IBlock extends IRegistryObject {
	IItemBlock getItemBlock();

	default int getMaxStackSize() {
		return 64;
	}

	default String getTextureName() {
		return "test";
	}

	default boolean hasModel() {
		return false;
	}

	default BlockType getType() {
		return BlockType.BASIC;
	}

	BlockModelType getModelType();

	ItemType getItemBlockType();

	IBlockMaterial getMaterial();

	IBlockSound getSound();

	ICreativeTab getCreativeTab();

	boolean isFullCube();

	boolean isOpaqueCube();

	float getHardness();

	float getResistance();
}
