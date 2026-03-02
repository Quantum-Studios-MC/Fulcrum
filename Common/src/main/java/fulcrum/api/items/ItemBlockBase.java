package fulcrum.api.items;

import fulcrum.api.blocks.IBlock;
import fulcrum.api.creativetabs.CreativeTab;
import fulcrum.api.creativetabs.ICreativeTab;

public class ItemBlockBase implements IItemBlock {
	private final IBlock block;

	public ItemBlockBase(IBlock block) {
		this.block = block;
	}

	@Override
	public String getRegistryName() {
		return block.getRegistryName();
	}

	@Override
	public ItemType getType() {
		if(block.getItemBlockType() != null) return block.getItemBlockType();
		return ItemType.BLOCK;
	}

	@Override
	public ICreativeTab getCreativeTab() {

		return getCreativeTab();
	}

	@Override
	public String getTextureName() {
		return block.getTextureName();
	}

	@Override
	public IBlock getBlock() {
		return block;
	}
}
