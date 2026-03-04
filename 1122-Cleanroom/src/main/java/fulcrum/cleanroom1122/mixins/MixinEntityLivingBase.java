package fulcrum.cleanroom1122.mixins;

import fulcrum.api.game.entities.player.IMCPlayer;
import fulcrum.api.game.items.IMCItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBase implements IMCPlayer {
	@Shadow
	public abstract ItemStack getHeldItemMainhand();

	@Override
	public IMCItemStack getHeldItem$() {
		return (IMCItemStack) (Object) getHeldItemMainhand();
	}
}
