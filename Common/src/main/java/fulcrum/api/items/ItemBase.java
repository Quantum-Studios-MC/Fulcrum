package fulcrum.api.items;

public class ItemBase implements IItem {
	private final String registryName;
	private String textureName;

	public ItemBase(String registryName) {
		this.registryName = registryName;
	}

	@Override
	public String getRegistryName() {
		return registryName;
	}

	@Override
	public String getTextureName() {
		return textureName;
	}

	public ItemBase setTextureName(String textureName) {
		this.textureName = textureName;
		return this;
	}
}
