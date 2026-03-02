package fulcrum.api.game;

import fulcrum.api.blocks.IBlock;

public interface IMCItemBlock extends IMCItem {
	IBlock getParentBlock();
}
