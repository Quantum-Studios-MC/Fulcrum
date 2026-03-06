package fulcrum.cleanroom1122.game.tileentities;

import fulcrum.api.tileentities.ITile;
import net.minecraft.client.renderer.texture.ITickable;

public class TileEntityTickableBase extends TileEntityBase implements ITickable {
	public TileEntityTickableBase(ITile tile) {
		super(tile);
	}

	@Override
	public void tick() {
		this.parentTile.tick();
	}
}
