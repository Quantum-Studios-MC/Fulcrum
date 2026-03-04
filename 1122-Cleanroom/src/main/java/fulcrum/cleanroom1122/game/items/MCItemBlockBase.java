package fulcrum.cleanroom1122.game.items;

import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.items.IMCItemBlock;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.cleanroom1122.util.MCMappings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class MCItemBlockBase extends ItemBlock implements IMCItemBlock {
	public final IBlock parentBlock;
	public MCItemBlockBase(IMCBlock block) {
		super((Block) block);
		this.parentBlock = block.getParentBlock();
		setRegistryName(block.getParentBlock().getRegistryName());
		setMaxStackSize(block.getParentBlock().getMaxStackSize());
		setCreativeTab(MCMappings.getCreativeTab(block.getParentBlock().getCreativeTab()));
	}

	public IBlock getParentBlock() {
		return parentBlock;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return parentBlock;
	}

	@Override
	public IItem getParentItem() {
		return parentBlock.getItemBlock();
	}
}
