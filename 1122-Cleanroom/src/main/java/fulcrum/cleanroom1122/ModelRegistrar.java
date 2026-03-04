package fulcrum.cleanroom1122;

import fulcrum.api.game.items.IMCItem;
import fulcrum.api.game.items.IMCItemBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegistrar {
	public static void registerItemBlockModels() {
		for(IMCItemBlock item : Registrar.ITEM_BLOCKS.values()) {
			generateItemResource(item);
		}
	}

	public static void registerItemModels() {
		for(IMCItem item : Registrar.ITEMS.values()) {
			generateItemResource(item);
		}
	}

	public static void generateItemResource(IMCItem item) {
		ModelLoader.setCustomModelResourceLocation(
			(Item) item,
			0,
			new ModelResourceLocation(
				new ResourceLocation(item.getParentItem().getModName() + ":" + item.getParentItem().getRegistryName().toString()),
				"inventory"
			)
		);
	}

	public static void registerModels(ModelRegistryEvent event) {
		ModelRegistrar.registerItemBlockModels();
		ModelRegistrar.registerItemModels();
	}
}
