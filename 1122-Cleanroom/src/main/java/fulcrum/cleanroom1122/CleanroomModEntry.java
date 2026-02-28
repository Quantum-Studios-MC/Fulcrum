package fulcrum.cleanroom1122;

import com.author.examplemod.ExampleMod;
import com.author.examplemod.ModEntry;
import fulcrum.api.FulcrumHooks;
import fulcrum.cleanroom1122.gen.ModelRegistrar;
import fulcrum.cleanroom1122.gen.RecipeRegistrar;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModEntry.modid)
public class CleanroomModEntry {
	public static final Logger LOGGER = LogManager.getLogger(ModEntry.modid);

	public CleanroomModEntry() {
		FulcrumHooks.generateItems();
		FulcrumHooks.generateRecipes();
		Registrar.registerItems();
	}


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Side side = FMLCommonHandler.instance().getSide();
		if(side.isClient()) {
			ModelRegistrar.registerModelsPost();
		}
		RecipeRegistrar.generateJsons();
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		ExampleMod.LOGGER.info("Hello from Forge!");
	}

}
