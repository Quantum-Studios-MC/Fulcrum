package fulcrum.api.tileentities;

import fulcrum.api.blocks.IBlockTile;
import fulcrum.api.game.nbt.IMCTagCompound;

public interface ITile {
	IBlockTile getTileBlock();
	boolean isTickable();
	void setTickable(boolean tickable);
	void setTileBlock(IBlockTile tile);
	void tick();
	void read(IMCTagCompound tag);
	void write(IMCTagCompound tag);
}
