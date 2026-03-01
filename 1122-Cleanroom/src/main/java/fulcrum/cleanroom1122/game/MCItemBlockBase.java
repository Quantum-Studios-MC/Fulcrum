package fulcrum.cleanroom1122.game;

import fulcrum.api.game.IMCRegistryObject;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import net.minecraft.item.ItemBlock;

public class MCItemBlockBase extends ItemBlock implements IMCRegistryObject {
	public final IBlock parentBlock;
	public MCItemBlockBase(MCBlockBase block) {
		super(block);
		this.parentBlock = block.getBlock();
		setRegistryName(block.getRegistryName());
	}

	public IBlock getParentBlock() {
		return parentBlock;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return parentBlock;
	}
}
