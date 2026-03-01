package fulcrum.cleanroom1122;

import fulcrum.cleanroom1122.game.MCItemBase;
import fulcrum.cleanroom1122.game.MCItemBlockBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegistrar {
	public void registerItemBlockModels() {
		for(MCItemBlockBase item : Registrar.ITEM_BLOCKS.values()) {
			generateItemResource(item);
		}
	}

	public void registerItemModels() {
		for(MCItemBase item : Registrar.ITEMS.values()) {
			generateItemResource(item);
		}
	}

	public static void generateItemResource(Item item) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			0,
			new ModelResourceLocation(
				item.getRegistryName().toString(),
				"inventory"
			)
		);
	}
}
