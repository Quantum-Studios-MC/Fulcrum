package fulcrum.api.game.tileentities;

import fulcrum.api.game.nbt.IMCTagCompound;

public interface IMCTile {
	void read$(IMCTagCompound tag);
	void write$(IMCTagCompound tag);
}
