package fulcrum.cleanroom1122;

import com.author.examplemod.ModEntry;
import fulcrum.api.IItem;
import fulcrum.api.ItemBase;
import fulcrum.api.Registry;
import fulcrum.cleanroom1122.game.MCItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModEntry.modid)
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

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
	}
}
