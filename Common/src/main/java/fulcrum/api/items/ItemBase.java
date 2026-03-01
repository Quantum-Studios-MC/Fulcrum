package fulcrum.api.items;

public class ItemBase implements IItem {
	private final String registryName;
	private String textureName;
	private ItemType type;

	public ItemBase(String registryName) {
		this.registryName = registryName;
		type = ItemType.BASIC;
	}

	@Override
	public String getRegistryName() {
		return registryName;
	}

	@Override
	public String getTextureName() {
		return textureName;
	}

	@Override
	public ItemType getType() {
		return type;
	}

	public ItemBase setTextureName(String textureName) {
		this.textureName = textureName;
		return this;
	}

	public ItemBase setType(ItemType type) {
		this.type = type;
		return this;
	}
}
