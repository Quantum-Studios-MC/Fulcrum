package fulcrum.forge1710.mixins;

import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.game.util.IMCPos;
import fulcrum.api.game.world.IMCWorld;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class MixinWorld implements IMCWorld {
	@Shadow
	public abstract boolean setBlock(int x, int y, int z, Block blockIn, int metadataIn, int flags);
	@Shadow
	public abstract TileEntity getTileEntity(int x, int y, int z);
	@Shadow
	public abstract Block getBlock(int p_147439_1_, int p_147439_2_, int p_147439_3_);

	@Override
	public boolean setBlock$(IMCPos pos, IMCBlock block) {
		return setBlock(pos.getX$(), pos.getY$(), pos.getZ$(), (Block) block, 0, 2);
	}

	@Override
	public boolean setBlock$(int x, int y, int z, IMCBlock block) {
		return setBlock(x, y, z, (Block) block, 0, 2);
	}

	@Override
	public IMCTile getTile$(int x, int y, int z) {
		return (IMCTile) getTileEntity(x, y, z);
	}

	@Override
	public IMCTile getTile$(IMCPos pos) {
		return (IMCTile) getTileEntity(pos.getX$(), pos.getY$(), pos.getZ$());
	}

	@Override
	public IMCBlock getBlock$(int x, int y, int z) {
		return (IMCBlock) getBlock(x, y, z);
	}

	@Override
	public IMCBlock getBlock$(IMCPos pos) {
		return (IMCBlock) getBlock(pos.getX$(), pos.getY$(), pos.getZ$());
	}
}
