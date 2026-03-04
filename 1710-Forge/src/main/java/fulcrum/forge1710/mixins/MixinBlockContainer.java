package fulcrum.forge1710.mixins;

import fulcrum.api.game.blocks.IMCBlockTile;
import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.game.world.IMCWorld;
import net.minecraft.block.BlockContainer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockContainer.class)
public abstract class MixinBlockContainer implements IMCBlockTile {
	@Override
	public IMCTile getTileInBlock$(IMCWorld world, int x, int y, int z) {
		return world.getTile$(x, y, z);
	}
}
