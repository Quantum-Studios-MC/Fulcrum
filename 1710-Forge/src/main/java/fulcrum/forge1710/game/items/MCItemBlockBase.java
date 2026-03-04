package fulcrum.forge1710.game.items;

import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.items.IMCItemBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

public class MCItemBlockBase extends ItemBlock implements IMCItemBlock {
	private IMCBlock block;
	public MCItemBlockBase(Block p_i45328_1_) {
		super(p_i45328_1_);
		block = (IMCBlock) p_i45328_1_;
	}

	@Override
	public int getSpriteNumber() {
		if(block.getParentBlock().getItemBlockType() == ItemType.BASIC) {
			return 0;
		}
		if(block.getParentBlock().getItemBlockType() == ItemType.BLOCK) {
			return 1;
		}
		return super.getSpriteNumber();
	}

	@Override
	public IIcon getIconFromDamage(int p_77617_1_) {
		return this.blockInstance.getBlockTextureFromSide(1);
	}

	@Override
	public IItem getParentItem() {
		return block.getParentBlock().getItemBlock();
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block.getParentBlock();
	}

	@Override
	public IBlock getParentBlock() {
		return block.getParentBlock();
	}
}
