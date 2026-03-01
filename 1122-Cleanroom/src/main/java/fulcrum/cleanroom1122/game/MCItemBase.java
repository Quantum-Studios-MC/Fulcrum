package fulcrum.cleanroom1122.game;

import fulcrum.api.game.IMCRegistryObject;
import fulcrum.api.IRegistryObject;
import fulcrum.api.items.IItem;
import net.minecraft.item.Item;

public class MCItemBase extends Item implements IMCRegistryObject {
	private final IItem item;

	public MCItemBase(IItem item) {
		this.item = item;
		setRegistryName(item.getRegistryName());
		setMaxStackSize(item.getMaxStackSize());
	}

	public IItem getItem() {
		return item;
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return item;
	}
}
