package fulcrum.cleanroom1122;

import com.author.examplemod.ModEntry;
import fulcrum.cleanroom1122.game.MCItemBase;
import fulcrum.cleanroom1122.game.MCItemBlockBase;
import fulcrum.cleanroom1122.game.MCMappings;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ModelRegistrar {
	public static void registerItemBlockModels() {
		for(MCItemBlockBase item : Registrar.ITEM_BLOCKS.values()) {
			generateItemResource(item);
		}
	}

	public static void registerItemModels() {
		for(MCItemBase item : Registrar.ITEMS.values()) {
			generateItemResource(item);
		}
	}

	public static void generateItemResource(Item item) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			0,
			new ModelResourceLocation(
				new ResourceLocation(item.getRegistryName().toString()),
				"inventory"
			)
		);
	}

	public static void registerModels(ModelRegistryEvent event) {
		ModelRegistrar.registerItemBlockModels();
		ModelRegistrar.registerItemModels();
	}
}
