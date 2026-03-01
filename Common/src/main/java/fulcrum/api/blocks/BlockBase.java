package fulcrum.api.blocks;

import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBlockBase;

public class BlockBase implements IBlock {
	private final String registryName;
	private String textureName;
	private final IItemBlock itemBlock;

	public BlockBase(String registryName) {
		this.registryName = registryName;
		this.itemBlock = new ItemBlockBase(this);
	}

	@Override
	public IItemBlock getItemBlock() {
		return itemBlock;
	}

	@Override
	public String getRegistryName() {
		return registryName;
	}

	@Override
	public String getTextureName() {
		return textureName;
	}

	public BlockBase setTextureName(String textureName) {
		this.textureName = textureName;
		return this;
	}
}
