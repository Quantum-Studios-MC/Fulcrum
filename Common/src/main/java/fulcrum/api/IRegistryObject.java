package fulcrum.api;

import com.author.examplemod.ModEntry;

public interface IRegistryObject {
	default String getModName() {
		return ModEntry.modid;
	}
	public String getRegistryName();
}
