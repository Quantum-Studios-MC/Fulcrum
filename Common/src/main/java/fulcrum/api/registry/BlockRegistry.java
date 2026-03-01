package fulcrum.api.registry;

import fulcrum.api.RegistryType;
import fulcrum.api.blocks.IBlock;

import java.util.Collection;

public class BlockRegistry {
	private static final RegistryType<IBlock> BLOCKS_REGISTRY = new RegistryType<>();
	private static final BlockRegistry REGISTRY = new BlockRegistry();

	private BlockRegistry() {}

	public static BlockRegistry getInstance() {
		return REGISTRY;
	}

	public void registerBlock(IBlock block) {
		BLOCKS_REGISTRY.register(block);
	}

	public static Collection<IBlock> getList() {
		return BLOCKS_REGISTRY.values();
	}

	public static String getListText() {
		return BLOCKS_REGISTRY.toString();
	}
}
