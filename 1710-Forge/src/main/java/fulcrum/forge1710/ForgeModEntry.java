package fulcrum.forge1710;

import com.author.examplemod.ModEntry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.*;
import fulcrum.api.PluginHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModEntry.modid, version = "1.0.0", name = ModEntry.modname, acceptedMinecraftVersions = "[1.7.10]")
public class ForgeModEntry {
	public static final Logger LOGGER = LogManager.getLogger(ModEntry.modid);

	public ForgeModEntry() {
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
		Registrar.registerBlock();
		Registrar.registerItem();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		RecipeRegistrar.registerRecipes();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@Mod.EventHandler
	public void completeInit(FMLLoadCompleteEvent event) {
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
	}
}
