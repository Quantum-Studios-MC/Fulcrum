package fulcrum.cleanroom1122.gen;

import fulcrum.api.items.IItem;
import fulcrum.cleanroom1122.Registrar;
import fulcrum.cleanroom1122.game.MCItemBase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelGenerator {
	public static void generateModelsJSON() {
		for(MCItemBase item : Registrar.ITEMS) {
			try {
				IItem iitem = item.getItem();
				if(iitem.isSimpleItem()) {
					generateSimpleItemJson(item.getItem());
				}
			} catch (IOException ignored) {

			}
		}
	}

	public static void generateSimpleItemJson(IItem item) throws IOException {
		Map<String, Object> json = new HashMap<>();

		json.put("parent", "item/generated");
		var textures = new java.util.HashMap<String, String>();
		textures.put("layer0", "examplemod:items/" + item.getTextureName());
		json.put("textures", textures);

		File output = JSONUtils.createAssetsJSON("models/item/" + item.getTextureName());
		JSONUtils.writeFile(output, json);
	}
}
