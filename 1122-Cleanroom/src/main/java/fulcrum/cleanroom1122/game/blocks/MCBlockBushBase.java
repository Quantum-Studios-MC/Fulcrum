package fulcrum.cleanroom1122.game.blocks;

import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.entities.player.IMCPlayer;
import fulcrum.api.game.world.IMCWorld;
import fulcrum.cleanroom1122.util.MCDirection;
import fulcrum.cleanroom1122.util.MCMappings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return block.$onBlockActivated((IMCWorld) worldIn, pos.getX(), pos.getY(), pos.getZ(), (IMCPlayer) playerIn, hitX, hitY, hitZ, MCDirection.getDirection(facing));
	}

	@Override
	public IBlock getParentBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}
}
