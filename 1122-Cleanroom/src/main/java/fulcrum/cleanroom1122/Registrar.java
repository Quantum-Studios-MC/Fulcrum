package fulcrum.cleanroom1122;

import com.author.examplemod.ModEntry;
import fulcrum.api.blocks.BlockBase;
import fulcrum.api.blocks.IBlock;
import fulcrum.api.items.IItem;
import fulcrum.api.items.IItemBlock;
import fulcrum.api.items.ItemBase;
import fulcrum.api.Registry;
import fulcrum.api.items.ItemType;
import fulcrum.cleanroom1122.game.MCBlockBase;
import fulcrum.cleanroom1122.game.MCItemBase;
import fulcrum.cleanroom1122.game.MCItemBlockBase;
import fulcrum.cleanroom1122.game.MCMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModEntry.modid)
public class Registrar {
	public static final List<MCItemBase> ITEMS = new ArrayList<>();
	public static final List<String> ITEM_NAMES = new ArrayList<>();
	public static final List<MCItemBlockBase> ITEM_BLOCKS = new ArrayList<>();
	public static final List<String> ITEM_BLOCK_NAMES = new ArrayList<>();
	public static final List<MCBlockBase> BLOCKS = new ArrayList<>();
	public static final List<String> BLOCK_NAMES = new ArrayList<>();

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
		if(!ITEM_NAMES.contains(item.getItem().getRegistryName())) {
			ITEMS.add(item);
			ITEM_NAMES.add(item.getItem().getRegistryName());
		}
	}

	public static void registerBlock(MCBlockBase item) {
		if(!BLOCK_NAMES.contains(item.getBlock().getRegistryName())) {
			BLOCKS.add(item);
			BLOCK_NAMES.add(item.getBlock().getRegistryName());
		}
	}

	public static void registerItemBlock(MCItemBlockBase item) {
		if(!ITEM_BLOCK_NAMES.contains(item.getParentBlock().getRegistryName())) {
			ITEM_BLOCKS.add(item);
			ITEM_BLOCK_NAMES.add(item.getParentBlock().getRegistryName());
		}
	}

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		Registrar.registerItems();
		Registrar.registerBlocks();

		CleanroomModEntry.LOGGER.info("Registered items:");
		CleanroomModEntry.LOGGER.info(Registry.getItemsList());
		event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
		event.getRegistry().registerAll(ITEM_BLOCKS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event) {
		MCMappings.loadMappings();
		Registrar.registerBlocks();

		CleanroomModEntry.LOGGER.info("Registered blocks:");
		CleanroomModEntry.LOGGER.info(Registry.getBlocksList());
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}
}
