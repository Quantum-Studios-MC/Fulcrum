package fulcrum.cleanroom1122;

import fulcrum.api.blocks.BlockType;
import fulcrum.api.game.blocks.IMCBlock;
import fulcrum.api.game.items.IMCItem;
import fulcrum.api.game.items.IMCItemBlock;
import fulcrum.api.registry.BlockRegistry;
import fulcrum.api.registry.ItemRegistry;
import fulcrum.api.game.MCRegistryType;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.ItemType;
import fulcrum.cleanroom1122.game.blocks.MCBlockBase;
import fulcrum.cleanroom1122.game.blocks.MCBlockBushBase;
import fulcrum.cleanroom1122.game.items.MCItemBase;
import fulcrum.cleanroom1122.game.items.MCItemBlockBase;
import fulcrum.cleanroom1122.util.MCMappings;
import net.minecraft.block.Block;
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
