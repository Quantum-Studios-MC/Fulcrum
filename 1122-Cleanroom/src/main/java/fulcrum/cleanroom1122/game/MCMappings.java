package fulcrum.cleanroom1122.game;

import fulcrum.api.blocks.BlockMaterial;
import net.minecraft.block.material.Material;

import java.util.HashMap;
import java.util.Map;

public class MCMappings {
	public static Map<BlockMaterial, Material> materialMap = new HashMap<>();

	public static void loadMappings() {
		materialMap.put(BlockMaterial.ROCK, Material.ROCK);
	}

	public static Material getMaterial(BlockMaterial material) {
		return materialMap.get(material);
	}
}
