package fulcrum.api.blocks;

import fulcrum.api.items.ItemType;

public class BlockBushBase extends BlockBase {
	public BlockBushBase(String registryName) {
		super(registryName);
		setType(BlockType.BUSH);
		setModel(BlockModel.CROSS);
		setItemBlockType(ItemType.BASIC);
		setFullCube(false);
		setOpaqueCube(false);
		setHardness(0.0F);
		setResistance(0.0F);
	}
}
