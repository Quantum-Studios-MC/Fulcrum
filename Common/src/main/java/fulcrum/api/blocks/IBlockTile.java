package fulcrum.api.blocks;

import fulcrum.api.tileentities.ITile;

public interface IBlockTile extends IBlock {
	ITile getTile();
	boolean isTickable();
}
