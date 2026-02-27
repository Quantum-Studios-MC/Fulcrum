package fulcrum.api;

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

	public ItemBase setTexture(String textureName) {
		this.textureName = textureName;
		return this;
	}
}
