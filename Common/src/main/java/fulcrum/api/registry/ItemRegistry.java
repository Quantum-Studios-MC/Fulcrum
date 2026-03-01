package fulcrum.api.registry;

import fulcrum.api.RegistryType;
import fulcrum.api.items.IItem;

import java.util.Collection;

public class ItemRegistry {
	public static final RegistryType<IItem> ITEMS_REGISTRY = new RegistryType<>();
	private static final ItemRegistry REGISTRY = new ItemRegistry();

	private ItemRegistry() {}

	public static ItemRegistry getInstance() {
		return REGISTRY;
	}

	public void registerItem(IItem item) {
		ITEMS_REGISTRY.register(item);
	}

	public static Collection<IItem> getItems() {
		return ITEMS_REGISTRY.values();
	}

	public static String getItemsList() {
		return ITEMS_REGISTRY.toString();
	}
}
