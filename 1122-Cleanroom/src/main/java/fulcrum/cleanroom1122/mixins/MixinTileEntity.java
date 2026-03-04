package fulcrum.cleanroom1122.mixins;

import fulcrum.api.game.nbt.IMCTagCompound;
import fulcrum.api.game.tileentities.IMCTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TileEntity.class)
public abstract class MixinTileEntity implements IMCTile {
	@Shadow
	public abstract void readFromNBT(NBTTagCompound compound);
	@Shadow
	public abstract NBTTagCompound writeToNBT(NBTTagCompound compound);

	@Override
	public void read$(IMCTagCompound tag) {
		readFromNBT((NBTTagCompound) tag);
	}

	@Override
	public void write$(IMCTagCompound tag) {
		writeToNBT((NBTTagCompound) tag);
	}
}
