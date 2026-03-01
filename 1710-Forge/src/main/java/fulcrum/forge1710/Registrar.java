package fulcrum.forge1710;

import cpw.mods.fml.common.registry.GameRegistry;
import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.game.MCRegistryType;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemType;
import fulcrum.forge1710.game.MCBlockBase;
import fulcrum.forge1710.game.MCItemBase;
import fulcrum.forge1710.game.MCMappings;

import java.util.*;

public class Registrar {
	public static final MCRegistryType<MCItemBase> ITEMS = new MCRegistryType<>();
	public static final MCRegistryType<MCBlockBase> BLOCKS = new MCRegistryType<>();

	public static void registerItems() {
		Collection<IItem> list = ItemRegistry.getItems();
		for(IItem item : list) {
			if(item instanceof ItemBase) {
				registerItem(new MCItemBase(item));
			}
		}
	}

	public static void registerBlocks() {
		Collection<IBlock> list = BlockRegistry.getList();
		for(IBlock item : list) {
			if(item instanceof BlockBase) {
				registerBlock(new MCBlockBase(item));
			}
		}
	}

	public static void registerItem(MCItemBase item) {
		ITEMS.register(item);
	}

	public static void registerBlock(MCBlockBase item) {
		BLOCKS.register(item);
	}

	public static void registerItem() {
		Registrar.registerItems();
		for(MCItemBase item : ITEMS.values()) {
			GameRegistry.registerItem(item, item.getItem().getRegistryName());
		}
	}

	public static void registerBlock() {
		MCMappings.loadMappings();
		Registrar.registerBlocks();
		for(MCBlockBase block : BLOCKS.values()) {
			IItemBlock iItemBlock = block.getBlock().getItemBlock();
			if(iItemBlock.getType() == ItemType.BLOCK) {
				GameRegistry.registerBlock(block, block.getBlock().getRegistryName());
			}
		}
	}
}
