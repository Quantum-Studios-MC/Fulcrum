package fulcrum.api;

import fulcrum.impl.ItemRegistry;

import java.util.Collection;

public class Registry {
	public static final ItemRegistry itemRegistry = new ItemRegistry();

	public static void registerItem(IItem item) {
		itemRegistry.register(item);
	}

	public static Collection<IItem> getItems() {
		return itemRegistry.values();
	}

}
