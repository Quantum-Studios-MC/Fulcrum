package fulcrum.forge1710.game;

import fulcrum.api.blocks.BlockMaterial;
import fulcrum.api.blocks.BlockSound;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.HashMap;
import java.util.Map;

public class MCMappings {
	public static Map<BlockMaterial, Material> materialMap = new HashMap<>();
	public static Map<BlockSound, Block.SoundType> soundMap = new HashMap<>();

	public static void loadMappings() {
		materialMap.put(BlockMaterial.ROCK, Material.rock);
		materialMap.put(BlockMaterial.WOOD, Material.wood);
		materialMap.put(BlockMaterial.GROUND, Material.ground);
		materialMap.put(BlockMaterial.CLOTH, Material.cloth);
		materialMap.put(BlockMaterial.SAND, Material.sand);

		soundMap.put(BlockSound.STONE, Block.soundTypeStone);
		soundMap.put(BlockSound.WOOD, Block.soundTypeWood);
		soundMap.put(BlockSound.GROUND, Block.soundTypeGrass);
		soundMap.put(BlockSound.PLANT, Block.soundTypeGrass);
		soundMap.put(BlockSound.METAL, Block.soundTypeMetal);
		soundMap.put(BlockSound.SAND, Block.soundTypeSand);
		soundMap.put(BlockSound.CLOTH, Block.soundTypeCloth);
	}

	public static Material getMaterial(BlockMaterial material) {
		return materialMap.get(material);
	}

	public static Block.SoundType getSound(BlockSound sound) {
		return soundMap.get(sound);
	}
}
