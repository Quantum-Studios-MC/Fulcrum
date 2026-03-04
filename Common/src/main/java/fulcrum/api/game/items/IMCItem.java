package fulcrum.api.game.items;

import fulcrum.api.game.IMCRegistryObject;
import fulcrum.api.items.IItem;

public interface IMCItem extends IMCRegistryObject {
	IItem getParentItem();
}
