package fulcrum.cleanroom1122.gen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fulcrum.api.IItem;
import fulcrum.cleanroom1122.Registrar;
import fulcrum.cleanroom1122.game.MCItemBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModelGenerator {
	public static void registerModels() {
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
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Build JSON structure
		var json = new java.util.HashMap<String, Object>();
		json.put("parent", "item/generated");
		var textures = new java.util.HashMap<String, String>();
		textures.put("layer0", "examplemod:items/" + item.getTextureName());
		json.put("textures", textures);

		// Write JSON file
		File output = new File("src/main/resources/assets/examplemod/models/item/" + item.getTextureName() + ".json");
		output.getParentFile().mkdirs();
		try (FileWriter writer = new FileWriter(output)) {
			gson.toJson(json, writer);
		}
	}
}
