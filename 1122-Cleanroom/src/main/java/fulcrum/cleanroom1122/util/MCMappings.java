package fulcrum.cleanroom1122.util;

import fulcrum.api.blocks.BlockMaterial;
import fulcrum.api.blocks.BlockSound;
import fulcrum.api.blocks.IBlockMaterial;
import fulcrum.api.blocks.IBlockSound;
import fulcrum.api.creativetabs.CreativeTab;
import fulcrum.api.creativetabs.ICreativeTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.HashMap;
import java.util.Map;

public class MCMappings {
	public static Map<IBlockMaterial, Material> materialMap = new HashMap<>();
	public static Map<IBlockSound, SoundType> soundMap = new HashMap<>();
	public static Map<ICreativeTab, CreativeTabs> creativeTabMap = new HashMap<>();

	public static void loadMappings() {
		materialMap.put(BlockMaterial.ROCK, Material.ROCK);
		materialMap.put(BlockMaterial.WOOD, Material.WOOD);
		materialMap.put(BlockMaterial.GROUND, Material.GROUND);
		materialMap.put(BlockMaterial.CLOTH, Material.CLOTH);
		materialMap.put(BlockMaterial.SAND, Material.SAND);

		soundMap.put(BlockSound.STONE, SoundType.STONE);
		soundMap.put(BlockSound.WOOD, SoundType.WOOD);
		soundMap.put(BlockSound.GROUND, SoundType.GROUND);
		soundMap.put(BlockSound.PLANT, SoundType.PLANT);
		soundMap.put(BlockSound.METAL, SoundType.METAL);
		soundMap.put(BlockSound.SAND, SoundType.SAND);
		soundMap.put(BlockSound.CLOTH, SoundType.CLOTH);

		creativeTabMap.put(CreativeTab.BREWING, CreativeTabs.BREWING);
		creativeTabMap.put(CreativeTab.COMBAT, CreativeTabs.COMBAT);
		creativeTabMap.put(CreativeTab.FOOD, CreativeTabs.FOOD);
		creativeTabMap.put(CreativeTab.MISC, CreativeTabs.MISC);
		creativeTabMap.put(CreativeTab.DECORATION, CreativeTabs.DECORATIONS);
		creativeTabMap.put(CreativeTab.MATERIALS, CreativeTabs.MATERIALS);
		creativeTabMap.put(CreativeTab.REDSTONE, CreativeTabs.REDSTONE);
		creativeTabMap.put(CreativeTab.TOOLS, CreativeTabs.TOOLS);
		creativeTabMap.put(CreativeTab.TRANSPORT, CreativeTabs.TRANSPORTATION);
	}

	public static Material getMaterial(IBlockMaterial material) {
		return materialMap.get(material);
	}

	public static SoundType getSound(IBlockSound sound) {
		return soundMap.get(sound);
	}

	public static CreativeTabs getCreativeTab(ICreativeTab tab) {
		return creativeTabMap.get(tab);
	}
}
