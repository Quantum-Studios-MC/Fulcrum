package fulcrum.forge1710.game;

import fulcrum.api.blocks.BlockMaterial;
import fulcrum.api.blocks.BlockSound;
import fulcrum.api.blocks.IBlockMaterial;
import fulcrum.api.blocks.IBlockSound;
import fulcrum.api.creativetabs.CreativeTab;
import fulcrum.api.creativetabs.ICreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.HashMap;
import java.util.Map;

public class MCMappings {
	public static Map<IBlockMaterial, Material> materialMap = new HashMap<>();
	public static Map<IBlockSound, Block.SoundType> soundMap = new HashMap<>();
	public static Map<ICreativeTab, CreativeTabs> creativeTabMap = new HashMap<>();

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

		creativeTabMap.put(CreativeTab.BREWING, CreativeTabs.tabBrewing);
		creativeTabMap.put(CreativeTab.COMBAT, CreativeTabs.tabCombat);
		creativeTabMap.put(CreativeTab.FOOD, CreativeTabs.tabFood);
		creativeTabMap.put(CreativeTab.MISC, CreativeTabs.tabMisc);
		creativeTabMap.put(CreativeTab.DECORATION, CreativeTabs.tabDecorations);
		creativeTabMap.put(CreativeTab.MATERIALS, CreativeTabs.tabMaterials);
		creativeTabMap.put(CreativeTab.REDSTONE, CreativeTabs.tabRedstone);
		creativeTabMap.put(CreativeTab.TOOLS, CreativeTabs.tabTools);
		creativeTabMap.put(CreativeTab.TRANSPORT, CreativeTabs.tabTransport);
	}

	public static Material getMaterial(IBlockMaterial material) {
		return materialMap.get(material);
	}

	public static Block.SoundType getSound(IBlockSound sound) {
		return soundMap.get(sound);
	}

	public static CreativeTabs getCreativeTab(ICreativeTab tab) {
		return creativeTabMap.get(tab);
	}
}
