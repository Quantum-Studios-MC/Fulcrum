package fulcrum.cleanroom1122.game;

import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.ItemBlockBase;
import net.minecraft.item.ItemBlock;

public class MCItemBlockBase extends ItemBlock {
	public final IBlock parentBlock;
	public MCItemBlockBase(MCBlockBase block) {
		super(block);
		this.parentBlock = block.getBlock();
		setRegistryName(block.getRegistryName());
	}

	public IBlock getParentBlock() {
		return parentBlock;
	}
}
