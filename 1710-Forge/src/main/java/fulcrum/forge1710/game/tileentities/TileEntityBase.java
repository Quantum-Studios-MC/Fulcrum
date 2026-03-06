package fulcrum.forge1710.game.tileentities;

import fulcrum.api.game.nbt.IMCTagCompound;
import fulcrum.api.game.tileentities.IMCTile;
import fulcrum.api.tileentities.ITile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBase extends TileEntity implements IMCTile {
	public final ITile parentTile;
	public TileEntityBase(ITile tile) {
		this.parentTile = tile;
	}

	@Override
	public void updateEntity() {
		parentTile.tick();
	}

	@Override
	public boolean canUpdate() {
		return parentTile.isTickable();
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		parentTile.read((IMCTagCompound) compound);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		parentTile.write((IMCTagCompound) compound);
	}
}
