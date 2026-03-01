package fulcrum.cleanroom1122;

import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.game.MCRegistryType;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBase;
import fulcrum.api.items.ItemType;
import fulcrum.cleanroom1122.game.MCBlockBase;
import fulcrum.cleanroom1122.game.MCItemBase;
import fulcrum.cleanroom1122.game.MCItemBlockBase;
import fulcrum.cleanroom1122.game.MCMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collection;

public class Registrar {
	public static final MCRegistryType<MCItemBase> ITEMS = new MCRegistryType<>();
	public static final MCRegistryType<MCItemBlockBase> ITEM_BLOCKS = new MCRegistryType<>();
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
				MCBlockBase block = new MCBlockBase(item);
				registerBlock(block);
				IItemBlock itemBlock = item.getItemBlock();
				if(itemBlock.getType() == ItemType.BLOCK) {
					registerItemBlock(new MCItemBlockBase(block));
				}
			}
		}
	}

	public static void registerItem(MCItemBase item) {
		ITEMS.register(item);
	}

	public static void registerBlock(MCBlockBase item) {
		BLOCKS.register(item);
	}

	public static void registerItemBlock(MCItemBlockBase item) {
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
