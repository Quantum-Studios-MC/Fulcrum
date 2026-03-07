package fulcrum.api.game.tileentities;

import fulcrum.api.game.nbt.IMCTagCompound;

public interface IMCTile {
	default void read$(IMCTagCompound tag) {};
	default void write$(IMCTagCompound tag) {};
}
