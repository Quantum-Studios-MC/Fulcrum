package fulcrum.forge1710;

import cpw.mods.fml.common.registry.GameRegistry;
import fulcrum.api.IItem;
import fulcrum.api.ItemBase;
import fulcrum.api.Registry;
import fulcrum.forge1710.game.MCItemBase;

import java.util.*;

public class Registrar {
	public static final List<MCItemBase> ITEMS = new ArrayList<>();

	public static void registerItems() {
		Collection<IItem> list = Registry.getItems();
		for(IItem item : list) {
			if(item instanceof ItemBase) {
				registerItem(new MCItemBase(item));
			}
		}
	}

	public static void registerItem(MCItemBase item) {
		ITEMS.add(item);
	}


	public static void register() {
		for(MCItemBase item : ITEMS) {
			GameRegistry.registerItem(item, item.getItem().getRegistryName());
		}
	}
}
