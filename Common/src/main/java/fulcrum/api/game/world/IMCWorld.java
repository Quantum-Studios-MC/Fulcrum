package fulcrum.api.game.world;

import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.game.util.IMCPos;

public interface IMCWorld {
	boolean setBlock$(IMCPos pos, IMCBlock block);
	boolean setBlock$(int x, int y, int z, IMCBlock block);
	IMCTile getTile$(int x, int y, int z);
}
