package fulcrum.forge1710;

import com.author.examplemod.ModEntry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.*;
import fulcrum.api.FulcrumHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModEntry.modid, version = "1.0.0", name = ModEntry.modname, acceptedMinecraftVersions = "[1.7.10]")
public class ForgeModEntry {
	public static final Logger LOGGER = LogManager.getLogger(ModEntry.modid);

	public ForgeModEntry() {
		FulcrumHooks.generateItems();
		Registrar.registerItems();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Registrar.register();
		Registrar.registerRecipes();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
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
