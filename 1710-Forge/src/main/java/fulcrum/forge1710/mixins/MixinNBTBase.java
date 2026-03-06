package fulcrum.forge1710.mixins;

import fulcrum.api.game.nbt.IMCTagBase;
import net.minecraft.nbt.NBTBase;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NBTBase.class)
public class MixinNBTBase implements IMCTagBase {
}
