package fulcrum.api.game.blocks;

import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.IMCRegistryObject;

public interface IMCBlock extends IMCRegistryObject {
	IBlock getParentBlock();
}
