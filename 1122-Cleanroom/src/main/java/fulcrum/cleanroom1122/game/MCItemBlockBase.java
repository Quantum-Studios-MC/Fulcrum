package fulcrum.cleanroom1122.game;

import fulcrum.api.game.IMCBlock;
import fulcrum.api.game.IMCItem;
import fulcrum.api.game.IMCItemBlock;
import fulcrum.api.game.IMCRegistryObject;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class MCItemBlockBase extends ItemBlock implements IMCItemBlock {
	public final IBlock parentBlock;
	public MCItemBlockBase(IMCBlock block) {
		super((Block) block);
		this.parentBlock = block.getBlock();
		setRegistryName(block.getBlock().getRegistryName());
		setMaxStackSize(block.getBlock().getMaxStackSize());
		setCreativeTab(MCMappings.getCreativeTab(block.getBlock().getCreativeTab()));
	}

	public IBlock getParentBlock() {
		return parentBlock;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return parentBlock;
	}

	@Override
	public IItem getItem() {
		return parentBlock.getItemBlock();
	}
}
