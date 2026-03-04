package fulcrum.forge1710.game.items;

import fulcrum.api.game.items.IMCItem;
import fulcrum.api.IRegistryObject;
import fulcrum.api.items.IItem;
import fulcrum.forge1710.util.MCMappings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class MCItemBase extends Item implements IMCItem {
	private final IItem item;

	public MCItemBase(IItem item) {
		this.item = item;
		setMaxStackSize(item.getMaxStackSize());
		setUnlocalizedName(item.getModName() + "." + item.getRegistryName());
		setCreativeTab(MCMappings.getCreativeTab(item.getCreativeTab()));
	}

	@Override
	public IItem getParentItem() {
		return item;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon(item.getModName() + ":" + item.getTextureName());
	}

	@Override
	public IRegistryObject getDelegateRegistryObject$fulcrum() {
		return item;
	}
}
