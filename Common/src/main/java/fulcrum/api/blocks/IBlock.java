package fulcrum.api.blocks;

import fulcrum.api.IRegistryObject;
import fulcrum.api.creativetabs.ICreativeTab;
import fulcrum.api.game.entities.player.IMCPlayer;
import fulcrum.api.game.world.IMCWorld;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemType;
import fulcrum.api.util.Direction;

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

	default boolean onBlockActivated(IMCWorld world, int x, int y, int z, IMCPlayer player, float subX, float subY, float subZ, Direction side) { return false; };
}
