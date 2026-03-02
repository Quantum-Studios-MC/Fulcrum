package fulcrum.forge1710;

import cpw.mods.fml.common.registry.GameRegistry;
import fulcrum.api.blocks.BlockBushBase;
import fulcrum.api.blocks.BlockType;
import fulcrum.api.game.IMCBlock;
import fulcrum.api.game.IMCItem;
import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.game.MCRegistryType;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemType;
import fulcrum.forge1710.game.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.*;

public class Registrar {
	public static final MCRegistryType<IMCItem> ITEMS = new MCRegistryType<>();
	public static final MCRegistryType<IMCBlock> BLOCKS = new MCRegistryType<>();

	public static void registerItems() {
		Collection<IItem> list = ItemRegistry.getItems();
		for(IItem item : list) {
			if(item.getType() == ItemType.BASIC) {
				registerItem(new MCItemBase(item));
			}
		}
	}

	public static void registerBlocks() {
		Collection<IBlock> list = BlockRegistry.getList();
		for(IBlock item : list) {
			IMCBlock block = null;
			if(item.getType() == BlockType.BASIC) {
				block = new MCBlockBase(item);
			}
			if(item.getType() == BlockType.BUSH) {
				block = new MCBlockBushBase(item);
			}
			if(block != null) {
				registerBlock(block);
			}
		}
	}

	public static void registerItem(IMCItem item) {
		ITEMS.register(item);
	}

	public static void registerBlock(IMCBlock item) {
		BLOCKS.register(item);
	}

	public static void registerItem() {
		Registrar.registerItems();
		for(IMCItem item : ITEMS.values()) {
			GameRegistry.registerItem((Item) item, item.getItem().getRegistryName());
		}
	}

	public static void registerBlock() {
		MCMappings.loadMappings();
		Registrar.registerBlocks();
		for(IMCBlock block : BLOCKS.values()) {
			if(block.getBlock().getItemBlockType() == ItemType.BASIC) {
				GameRegistry.registerBlock((Block) block, MCItemBlockBase.class, block.getBlock().getRegistryName());
			}
			if(block.getBlock().getItemBlockType() == ItemType.BLOCK) {
				GameRegistry.registerBlock((Block) block, block.getBlock().getRegistryName());
			}
		}
	}
}
