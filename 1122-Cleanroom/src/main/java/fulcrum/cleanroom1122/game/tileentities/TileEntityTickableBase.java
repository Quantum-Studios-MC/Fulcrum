package fulcrum.cleanroom1122.game.tileentities;

import fulcrum.api.tileentities.ITile;

public class TileEntityTickableBase extends TileEntityBase implements net.minecraft.util.ITickable {
	public TileEntityTickableBase(ITile tile) {
		super(tile);
	}

	@Override
	public void update() {
		this.parentTile.tick();
	}
}
