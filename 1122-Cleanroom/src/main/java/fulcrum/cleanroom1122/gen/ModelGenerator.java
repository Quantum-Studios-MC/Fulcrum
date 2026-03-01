package fulcrum.cleanroom1122.gen;

import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.blocks.BlockType;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelGenerator {
	public static void generateModelsJSON() {
		generateItemsModelsJSON();
		generateBlocksModelsJSON();
	}

	public static void generateItemsModelsJSON() {
		for(IItem iitem : ItemRegistry.getItems()) {
			try {
				if(iitem.getType() == ItemType.BASIC) {
					generateSimpleItemJson(iitem);
				}
			} catch (IOException ignored) {

			}
		}
	}

	public static void generateBlocksModelsJSON() {
		for(IBlock iblock : BlockRegistry.getList()) {
			try {
				IItemBlock iitemBlock = iblock.getItemBlock();
				if(iblock.getType() == BlockType.BASIC) {
					generateSimpleBlockJson(iblock);
				}
				if(iitemBlock.getType() == ItemType.BLOCK) {
					generateSimpleItemBlockJson(iitemBlock);
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

	public static void generateSimpleBlockJson(IBlock block) throws IOException {
		String modid = block.getModName();
		String name = block.getRegistryName();
		String texture = block.getTextureName();

		Map<String, Object> blockstate = new HashMap<>();
		Map<String, Object> variants = new HashMap<>();
		variants.put("normal", Map.of("model", modid + ":" + name));
		variants.put("inventory", Map.of("model", modid + ":" + name + "#in_inventory"));
		blockstate.put("variants", variants);

		File blockstateFile = JSONUtils.createAssetsJSON("blockstates/" + name);
		JSONUtils.writeFile(blockstateFile, blockstate);

		Map<String, Object> blockModel = new HashMap<>();
		blockModel.put("parent", "block/cube_all");

		Map<String, String> blockTextures = new HashMap<>();
		blockTextures.put("all", modid + ":blocks/" + texture);
		blockModel.put("textures", blockTextures);

		File blockModelFile = JSONUtils.createAssetsJSON("models/block/" + name);
		JSONUtils.writeFile(blockModelFile, blockModel);
	}

	public static void generateSimpleItemBlockJson(IItemBlock itemBlock) throws IOException {
		String modid = itemBlock.getModName();
		String name = itemBlock.getRegistryName();

		Map<String, Object> itemModel = new HashMap<>();
		itemModel.put("parent", modid + ":block/" + name);

		File itemModelFile = JSONUtils.createAssetsJSON("models/item/" + name);
		JSONUtils.writeFile(itemModelFile, itemModel);
	}
}
