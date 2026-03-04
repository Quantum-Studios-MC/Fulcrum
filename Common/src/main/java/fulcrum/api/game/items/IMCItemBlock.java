package fulcrum.api.game.items;

import fulcrum.api.blocks.IBlock;

public interface IMCItemBlock extends IMCItem {
	IBlock getParentBlock();
}
