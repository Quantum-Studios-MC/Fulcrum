package fulcrum.api.game.blocks;

import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.game.world.IMCWorld;

public interface IMCBlockTile extends IMCBlock {
	IMCTile getTileInBlock$(IMCWorld world, int x, int y, int z);
}
