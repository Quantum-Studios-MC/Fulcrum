package fulcrum.cleanroom1122.game;

import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.IMCBlock;
import fulcrum.api.game.IMCRegistryObject;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;

public class MCBlockBushBase extends BlockBush implements IMCBlock {
	private final IBlock block;
	public MCBlockBushBase(IBlock block) {
		super(MCMappings.getMaterial(block.getMaterial()));
		this.block = block;
		setRegistryName(block.getRegistryName());
		setTranslationKey(block.getModName() + "." + block.getRegistryName());
		setSoundType(MCMappings.getSound(block.getSound()));
		setResistance(block.getResistance());
		setHardness(block.getHardness());
		setCreativeTab(MCMappings.getCreativeTab(block.getCreativeTab()));
		this.fullBlock = block.isOpaqueCube();
		this.lightOpacity = block.isOpaqueCube() ? 255 : 0;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		if(block == null) return super.isFullCube(state);
		return block.isFullCube();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		if(block == null) return super.isOpaqueCube(state);
		return block.isOpaqueCube();
	}

	@Override
	public IBlock getBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}
}
