package fulcrum.cleanroom1122.mixins;

import fulcrum.api.game.items.IMCItem;
import fulcrum.api.game.items.IMCItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class MixinItemStack implements IMCItemStack {
	@Shadow
	public abstract Item getItem();
	@Shadow
	public int stackSize;

	@Override
	public IMCItem getItem$() {
		return (IMCItem) getItem();
	}

	@Override
	public int getAmount$() {
		return stackSize;
	}
}
