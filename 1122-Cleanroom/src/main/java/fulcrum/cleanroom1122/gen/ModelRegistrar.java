package fulcrum.cleanroom1122.gen;

import com.author.examplemod.ModEntry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fulcrum.api.IItem;
import fulcrum.cleanroom1122.Registrar;
import fulcrum.cleanroom1122.game.MCItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModelRegistrar {
	public static void registerModels() {
		for(MCItemBase item : Registrar.ITEMS) {
			try {
				generateJson(item.getItem());
			} catch (IOException ignored) {

			}
		}
	}

	public static void registerModelsPost() {
		for(MCItemBase item : Registrar.ITEMS) {
			generateResource(item);
		}
	}

	public static void generateResource(MCItemBase item) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			0,
			new ModelResourceLocation(
				ModEntry.modid + ":" + item.getItem().getTextureName(),
				"inventory"
			)
		);
	}

	public static void generateJson(IItem item) throws IOException {
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
