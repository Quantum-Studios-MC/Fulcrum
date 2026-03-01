package fulcrum.cleanroom1122;

import com.author.examplemod.ModEntry;
import fulcrum.api.game.MCRegistryType;
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
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModEntry.modid)
public class Registrar {
	public static final MCRegistryType<MCItemBase> ITEMS = new MCRegistryType<>();
	public static final MCRegistryType<MCItemBlockBase> ITEM_BLOCKS = new MCRegistryType<>();
	public static final MCRegistryType<MCBlockBase> BLOCKS = new MCRegistryType<>();

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
		ITEMS.register(item);
	}

	public static void registerBlock(MCBlockBase item) {
		BLOCKS.register(item);
	}

	public static void registerItemBlock(MCItemBlockBase item) {
		ITEM_BLOCKS.register(item);
	}

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		Registrar.registerItems();
		Registrar.registerBlocks();

		CleanroomModEntry.LOGGER.info("Registered items:");
		CleanroomModEntry.LOGGER.info(Registry.getItemsList());

		IForgeRegistry<Item> reg = event.getRegistry();
		reg.registerAll(ITEMS.values().toArray(new Item[0]));
		reg.registerAll(ITEM_BLOCKS.values().toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event) {
		MCMappings.loadMappings();
		Registrar.registerBlocks();

		CleanroomModEntry.LOGGER.info("Registered blocks:");
		CleanroomModEntry.LOGGER.info(Registry.getBlocksList());

		IForgeRegistry<Block> reg = event.getRegistry();
		reg.registerAll(BLOCKS.values().toArray(new Block[0]));
	}
}
