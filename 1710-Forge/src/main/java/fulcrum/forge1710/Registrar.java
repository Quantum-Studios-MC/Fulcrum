package fulcrum.forge1710;

import cpw.mods.fml.common.registry.GameRegistry;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBase;
import fulcrum.api.Registry;
import fulcrum.api.items.ItemType;
import fulcrum.forge1710.game.MCBlockBase;
import fulcrum.forge1710.game.MCItemBase;
import fulcrum.forge1710.game.MCMappings;

import java.util.*;

public class Registrar {
	public static final List<MCItemBase> ITEMS = new ArrayList<>();
	public static final List<MCBlockBase> BLOCKS = new ArrayList<>();

	public static void registerItems() {
		Collection<IItem> list = Registry.getItems();
		for(IItem item : list) {
			if(item instanceof ItemBase) {
				registerItem(new MCItemBase(item));
			}
		}
	}

	public static void registerBlocks() {
		Collection<IBlock> list = Registry.getBlocks();
		for(IBlock item : list) {
			if(item instanceof BlockBase) {
				registerBlock(new MCBlockBase(item));
			}
		}
	}

	public static void registerItem(MCItemBase item) {
		ITEMS.add(item);
	}

	public static void registerBlock(MCBlockBase item) {
		BLOCKS.add(item);
	}

	public static void registerItem() {
		Registrar.registerItems();
		for(MCItemBase item : ITEMS) {
			GameRegistry.registerItem(item, item.getItem().getRegistryName());
		}
	}

	public static void registerBlock() {
		MCMappings.loadMaterialMappings();
		Registrar.registerBlocks();
		for(MCBlockBase block : BLOCKS) {
			IItemBlock iItemBlock = block.getBlock().getItemBlock();
			if(iItemBlock.getType() == ItemType.BLOCK) {
				GameRegistry.registerBlock(block, block.getBlock().getRegistryName());
			}
		}
	}
}
