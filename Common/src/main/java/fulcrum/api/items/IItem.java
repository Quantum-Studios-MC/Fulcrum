package fulcrum.api.items;

import fulcrum.api.IRegistryObject;
import fulcrum.api.creativetabs.CreativeTab;
import fulcrum.api.creativetabs.ICreativeTab;

public interface IItem extends IRegistryObject {
	default int getMaxStackSize() {
		return 64;
	}

	default String getTextureName() {
		return "test";
	}

	default String getUnlocalizedName() {
		return "test";
	}

	default boolean hasModel() {
		return false;
	}

	default ICreativeTab getCreativeTab() {
		return CreativeTab.MISC;
	}

	default ItemType getType() {
		return ItemType.BASIC;
	}
}
