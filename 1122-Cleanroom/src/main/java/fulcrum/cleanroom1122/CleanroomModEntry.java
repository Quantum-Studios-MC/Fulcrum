package fulcrum.cleanroom1122;

import com.author.examplemod.ExampleMod;
import com.author.examplemod.ModEntry;
import fulcrum.api.PluginHooks;
import fulcrum.api.Registry;
import fulcrum.cleanroom1122.game.MCMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModEntry.modid, name = ModEntry.modname)
@Mod.EventBusSubscriber(modid = ModEntry.modid)
public class CleanroomModEntry {
	public static final Logger LOGGER = LogManager.getLogger(ModEntry.modid);

	public CleanroomModEntry() {
		runMain();
	}

	public static void runMain() {
		PluginHooks.initialize();

		PluginHooks.generateBlocks();
		PluginHooks.generateItems();

		PluginHooks.generateRecipes();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		ExampleMod.LOGGER.info("Hello from Forge!");
	}

	@SubscribeEvent
	public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
		Registrar.registerBlock(event);
	}

	@SubscribeEvent
	public static void onRegisterItem(RegistryEvent.Register<Item> event) {
		Registrar.registerItem(event);
	}

	@SubscribeEvent
	public static void onRegisterModel(ModelRegistryEvent event) {
		ModelRegistrar.registerModels(event);
	}
}
