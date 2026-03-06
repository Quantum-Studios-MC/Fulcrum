package fulcrum.api.tileentities;

import fulcrum.api.blocks.IBlockTile;
import fulcrum.api.game.nbt.IMCTagCompound;

public class TileBase implements ITile {
	public IBlockTile blockTile;
	public boolean isTickable;

	@Override
	public IBlockTile getTileBlock() {
		return blockTile;
	}

	@Override
	public boolean isTickable() {
		return isTickable;
	}

	@Override
	public void setTickable(boolean tickable) {
		this.isTickable = tickable;
	}

	@Override
	public void setTileBlock(IBlockTile tile) {
		this.blockTile = tile;
	}

	@Override
	public void tick() {
	}

	@Override
	public void read(IMCTagCompound tag) {

	}

	@Override
	public void write(IMCTagCompound tag) {

	}
}
