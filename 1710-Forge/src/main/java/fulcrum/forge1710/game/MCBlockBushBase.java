package fulcrum.forge1710.game;

import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.BlockModelType;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.IMCBlock;
import fulcrum.api.game.IMCRegistryObject;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MCBlockBushBase extends BlockBush implements IMCBlock {
	private final IBlock block;

	public MCBlockBushBase(IBlock block) {
		super(MCMappings.getMaterial(block.getMaterial()));
		this.block = block;
		setUnlocalizedName(block.getModName() + "." + block.getRegistryName());
		setStepSound(MCMappings.getSound(block.getSound()));
		setResistance(block.getResistance());
		setHardness(block.getHardness());
		setCreativeTab(MCMappings.getCreativeTab(block.getCreativeTab()));
		this.fullBlock = this.isOpaqueCube();
		this.lightOpacity = this.isOpaqueCube() ? 255 : 0;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon(block.getModName() + ":" + block.getTextureName());
	}

	@Override
	public boolean isFullBlock() {
		if(block == null) return super.isFullBlock();
		return block.isFullCube();
	}

	@Override
	public boolean isOpaqueCube() {
		if(block == null) return super.isOpaqueCube();
		return block.isOpaqueCube();
	}

	@Override
	public int getRenderType() {
		if(block.getModelType() == BlockModelType.CUBE) {
			return 0;
		}
		if(block.getModelType() == BlockModelType.CROSS) {
			return 1;
		}
		return super.getRenderType();
	}

	public IBlock getBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}
}
