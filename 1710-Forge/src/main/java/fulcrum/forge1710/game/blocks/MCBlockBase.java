package fulcrum.forge1710.game.blocks;

import fulcrum.api.blocks.BlockModelType;
import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.entities.player.IMCPlayer;
import fulcrum.api.game.world.IMCWorld;
import fulcrum.forge1710.util.MCDirection;
import fulcrum.forge1710.util.MCMappings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MCBlockBase extends Block implements IMCBlock {
	private final IBlock block;

	public MCBlockBase(IBlock block) {
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
	public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ) {
		return block.onBlockActivated$((IMCWorld) worldIn, x, y, z, (IMCPlayer) player, subX, subY, subZ, MCDirection.getDirection(side));
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

	public IBlock getParentBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}
}
