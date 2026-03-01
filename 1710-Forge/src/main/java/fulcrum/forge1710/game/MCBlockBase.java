package fulcrum.forge1710.game;

import fulcrum.api.game.IMCRegistryObject;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MCBlockBase extends Block implements IMCRegistryObject {
	private final IBlock block;

	public MCBlockBase(IBlock block) {
		super(MCMappings.getMaterial(block.getMaterial()));
		this.block = block;
		setUnlocalizedName(block.getModName() + "." + block.getRegistryName());
		setStepSound(MCMappings.getSound(block.getSound()));
		setResistance(block.getResistance());
		setHardness(block.getHardness());
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon(block.getModName() + ":" + block.getTextureName());
	}

	public IBlock getBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}
}
