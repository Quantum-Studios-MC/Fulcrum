package fulcrum.cleanroom1122.gen;

import com.author.examplemod.ModEntry;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemType;
import fulcrum.cleanroom1122.Registrar;
import fulcrum.cleanroom1122.game.MCItemBase;
import fulcrum.cleanroom1122.game.MCItemBlockBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegistrar {
	public static void registerModels() {
		for(MCItemBase item : Registrar.ITEMS) {
			generateSimpleItemResource(item);
		}
		for(MCItemBlockBase item : Registrar.ITEM_BLOCKS) {
			//generateSimpleItemBlockResource(item);
		}
	}

	public static void generateSimpleItemResource(MCItemBase item) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			0,
			new ModelResourceLocation(
				item.getItem().getModName() + ":" + item.getItem().getRegistryName(),
				"inventory"
			)
		);
	}

	public static void generateSimpleItemBlockResource(MCItemBlockBase item) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			0,
			new ModelResourceLocation(
				item.getParentBlock().getModName() + ":" + item.getParentBlock().getRegistryName(),
				"inventory"
			)
		);
	}
}
