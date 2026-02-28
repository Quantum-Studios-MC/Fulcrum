package fulcrum.cleanroom1122.gen;

import com.author.examplemod.ModEntry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSONUtils {
	public static Gson GSON;

	public static Gson getGson() {
		if(GSON == null) {
			GSON = new GsonBuilder().setPrettyPrinting().create();
		}
		return GSON;
	}

	public static File getAssetsFile() {
		File output = new File("src/main/resources/assets/" + ModEntry.modid);
		output.getParentFile().mkdirs();
		return output;
	}

	public static File createAssetsJSON(String string) {
		File output = new File(getAssetsFile(), string + ".json");
		return output;
	}

	public static void writeFile(File file, Map<String, Object> json) {
		Gson gson = getGson();
		file.getParentFile().mkdirs();

		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(json, writer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
