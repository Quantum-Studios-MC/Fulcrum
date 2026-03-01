package fulcrum.api.items;

import fulcrum.api.blocks.IBlock;

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
		return ItemType.BLOCK;
	}

	@Override
	public IBlock getBlock() {
		return block;
	}
}
