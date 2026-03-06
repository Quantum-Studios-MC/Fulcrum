package fulcrum.cleanroom1122.mixins;

import fulcrum.api.blocks.IBlock;
import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.game.util.IMCPos;
import fulcrum.api.game.world.IMCWorld;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class MixinWorld implements IMCWorld {
	@Shadow
	public abstract boolean setBlockState(BlockPos pos, IBlockState newState, int flags);
	@Shadow
	public abstract TileEntity getTileEntity(BlockPos pos);
	@Shadow
	public abstract IBlockState getBlockState(BlockPos pos);

	@Override
	public boolean setBlock$(IMCPos pos, IMCBlock block) {
		return setBlockState((BlockPos) pos, ((Block) block).getDefaultState(), 2);
	}

	@Override
	public boolean setBlock$(int x, int y, int z, IMCBlock block) {
		return setBlockState(new BlockPos(x, y, z), ((Block) block).getDefaultState(), 2);
	}

	@Override
	public IMCTile getTile$(int x, int y, int z) {
		return (IMCTile) getTileEntity(new BlockPos(x, y, z));
	}

	@Override
	public IMCTile getTile$(IMCPos pos) {
		return (IMCTile) getTileEntity((BlockPos) pos);
	}

	@Override
	public IMCBlock getBlock$(int x, int y, int z) {
		return (IMCBlock) getBlockState(new BlockPos(x, y, z)).getBlock();
	}

	@Override
	public IMCBlock getBlock$(IMCPos pos) {
		return (IMCBlock) getBlockState((BlockPos) pos).getBlock();
	}
}
