package fulcrum.cleanroom1122.game;

import fulcrum.api.game.IMCRegistryObject;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import net.minecraft.block.Block;

public class MCBlockBase extends Block implements IMCRegistryObject {
	private final IBlock block;
	public MCBlockBase(IBlock block) {
		super(MCMappings.getMaterial(block.getMaterial()));
		this.block = block;
		setRegistryName(block.getRegistryName());
		setTranslationKey(block.getModName() + "." + block.getRegistryName());
		setSoundType(MCMappings.getSound(block.getSound()));
		setResistance(block.getResistance());
		setHardness(block.getHardness());
	}

	public IBlock getBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}
}
