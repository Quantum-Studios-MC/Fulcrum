package fulcrum.cleanroom1122.mixins;

import fulcrum.api.game.tileentities.IMCTile;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TileEntity.class)
public class MixinTileEntity implements IMCTile {

}
