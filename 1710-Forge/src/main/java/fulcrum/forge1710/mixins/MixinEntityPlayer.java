package fulcrum.forge1710.mixins;

import fulcrum.api.game.entities.player.IMCPlayer;
import fulcrum.api.game.items.IMCItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityPlayer.class)
public abstract class MixinEntityPlayer implements IMCPlayer {
	@Shadow
	public abstract ItemStack getHeldItem();

	@Override
	public IMCItemStack getHeldItem$() {
		return ((IMCItemStack)(Object) getHeldItem());
	}
}
