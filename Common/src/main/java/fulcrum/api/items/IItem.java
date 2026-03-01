package fulcrum.api.items;

import fulcrum.api.IRegistryObject;

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

	default ItemType getType() {
		return ItemType.BASIC;
	}
}
