package fulcrum.fabric1710;

import com.author.examplemod.ModEntry;
import fulcrum.api.PluginHooks;
import net.fabricmc.api.ModInitializer;

public class FabricModEntry implements ModInitializer {

	public void onInitialize() {
		PluginHooks.initialize();
	}
}
