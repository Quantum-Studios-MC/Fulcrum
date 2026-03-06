package fulcrum.api.blocks;

import fulcrum.api.tileentities.ITile;

public class BlockTileBase extends BlockBase implements IBlockTile {
	public final ITile tile;
	public BlockTileBase(String registryName, ITile tile) {
		super(registryName);
		this.tile = tile;
		this.tile.setTileBlock(this);
	}

	@Override
	public boolean isTickable() {
		return tile.isTickable();
	}

	public BlockTileBase setTickable(boolean isTickable) {
		this.tile.setTickable(isTickable);
		return this;
	}

	@Override
	public ITile getTile() {
		return tile;
	}
}
