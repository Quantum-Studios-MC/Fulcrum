package fulcrum.forge1710.game;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.IMCBlock;
import fulcrum.api.game.IMCItem;
import fulcrum.api.game.IMCItemBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemType;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
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
		if(block.getBlock().getItemBlockType() == ItemType.BASIC) {
			return 0;
		}
		if(block.getBlock().getItemBlockType() == ItemType.BLOCK) {
			return 1;
		}
		return super.getSpriteNumber();
	}

	@Override
	public IIcon getIconFromDamage(int p_77617_1_) {
		return this.blockInstance.getBlockTextureFromSide(1);
	}

	@Override
	public IItem getItem() {
		return block.getBlock().getItemBlock();
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block.getBlock();
	}

	@Override
	public IBlock getParentBlock() {
		return block.getBlock();
	}
}
