package fulcrum.cleanroom1122.game.blocks;

import fulcrum.api.IRegistryObject;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.blocks.IBlockTile;
import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.blocks.IMCBlockTile;
import fulcrum.api.game.entities.player.IMCPlayer;
import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.game.world.IMCWorld;
import fulcrum.cleanroom1122.game.tileentities.TileEntityBase;
import fulcrum.cleanroom1122.game.tileentities.TileEntityTickableBase;
import fulcrum.cleanroom1122.util.MCDirection;
import fulcrum.cleanroom1122.util.MCMappings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MCBlockTileBase extends BlockContainer implements IMCBlockTile {
	private final IBlockTile block;
	public MCBlockTileBase(IBlockTile block) {
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
		return block.onBlockActivated((IMCWorld) worldIn, pos.getX(), pos.getY(), pos.getZ(), (IMCPlayer) playerIn, hitX, hitY, hitZ, MCDirection.getDirection(facing));
	}

	@Override
	public IBlock getParentBlock() {
		return block;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return block;
	}

	@Override
	public IMCTile getTileInBlock$(IMCWorld world, int x, int y, int z) {
		return (IMCTile) ((World) world).getTileEntity(new BlockPos(x, y, z));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if(block.getTile().isTickable()) {
			return new TileEntityTickableBase(block.getTile());
		}
		return new TileEntityBase(block.getTile());
	}
}
