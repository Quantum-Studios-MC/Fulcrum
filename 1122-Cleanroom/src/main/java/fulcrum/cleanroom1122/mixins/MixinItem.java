package fulcrum.cleanroom1122.mixins;

import fulcrum.api.game.items.IMCItem;
import fulcrum.api.items.IItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Item.class)
public abstract class MixinItem implements IMCItem {
	@Override
	public IItem getParentItem() {
		return null;
	}
}
