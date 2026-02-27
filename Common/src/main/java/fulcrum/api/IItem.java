package fulcrum.api;

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

	default boolean isSimpleItem() {
		return true;
	}
}
