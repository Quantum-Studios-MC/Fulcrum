package fulcrum.cleanroom1122.gen;

import com.author.examplemod.ModEntry;
import fulcrum.api.IItem;
import fulcrum.cleanroom1122.Registrar;
import fulcrum.cleanroom1122.game.MCItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegistrar {
	public static void registerModels() {
		for(MCItemBase item : Registrar.ITEMS) {
			IItem iitem = item.getItem();
			if(iitem.isSimpleItem()) {
				generateSimpleItemResource(item);
			}
		}
	}

	public static void generateSimpleItemResource(MCItemBase item) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			0,
			new ModelResourceLocation(
				ModEntry.modid + ":" + item.getItem().getTextureName(),
				"inventory"
			)
		);
	}
}
