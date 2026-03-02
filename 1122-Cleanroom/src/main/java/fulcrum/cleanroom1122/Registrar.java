package fulcrum.cleanroom1122;

import fulcrum.api.blocks.BlockBushBase;
import fulcrum.api.blocks.BlockType;
import fulcrum.api.game.IMCBlock;
import fulcrum.api.game.IMCItem;
import fulcrum.api.game.IMCItemBlock;
import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.game.MCRegistryType;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemType;
import fulcrum.cleanroom1122.game.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collection;

public class Registrar {
	public static final MCRegistryType<IMCItem> ITEMS = new MCRegistryType<>();
	public static final MCRegistryType<IMCItemBlock> ITEM_BLOCKS = new MCRegistryType<>();
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
				registerItemBlock(new MCItemBlockBase(block));
			}
		}
	}

	public static void registerItem(IMCItem item) {
		ITEMS.register(item);
	}

	public static void registerBlock(IMCBlock item) {
		BLOCKS.register(item);
	}

	public static void registerItemBlock(IMCItemBlock item) {
		ITEM_BLOCKS.register(item);
	}

	public static void registerItem(RegistryEvent.Register<Item> event) {
		Registrar.registerBlocks();
		Registrar.registerItems();

		CleanroomModEntry.LOGGER.info("Registered items:");
		CleanroomModEntry.LOGGER.info(ItemRegistry.getItemsList());

		IForgeRegistry<Item> reg = event.getRegistry();
		reg.registerAll(ITEM_BLOCKS.values().toArray(new Item[0]));
		reg.registerAll(ITEMS.values().toArray(new Item[0]));
	}

	public static void registerBlock(RegistryEvent.Register<Block> event) {
		MCMappings.loadMappings();
		Registrar.registerBlocks();

		CleanroomModEntry.LOGGER.info("Registered blocks:");
		CleanroomModEntry.LOGGER.info(BlockRegistry.getListText());

		IForgeRegistry<Block> reg = event.getRegistry();
		reg.registerAll(BLOCKS.values().toArray(new Block[0]));
	}
}
