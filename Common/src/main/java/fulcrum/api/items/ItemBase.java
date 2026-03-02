package fulcrum.api.items;

import fulcrum.api.creativetabs.CreativeTab;
import fulcrum.api.creativetabs.ICreativeTab;

public class ItemBase implements IItem {
	private final String registryName;
	private String textureName;
	private ItemType type;
	private ICreativeTab creativeTab;

	public ItemBase(String registryName) {
		this.registryName = registryName;
		setType(ItemType.BASIC);
		setCreativeTab(CreativeTab.MISC);
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

	@Override
	public ICreativeTab getCreativeTab() {
		return creativeTab;
	}

	public ItemBase setTextureName(String textureName) {
		this.textureName = textureName;
		return this;
	}

	public ItemBase setCreativeTab(ICreativeTab creativeTab) {
		this.creativeTab = creativeTab;
		return this;
	}

	public ItemBase setType(ItemType type) {
		this.type = type;
		return this;
	}
}
