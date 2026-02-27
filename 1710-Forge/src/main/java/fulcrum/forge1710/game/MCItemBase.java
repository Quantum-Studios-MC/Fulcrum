package fulcrum.forge1710.game;

import com.author.examplemod.ModEntry;
import fulcrum.api.IItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class MCItemBase extends Item {
	private final IItem item;
	private IIcon icon;

	public MCItemBase(IItem item) {
		this.item = item;
		setMaxStackSize(item.getMaxStackSize());
	}

	public IItem getItem() {
		return item;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon(ModEntry.modid + ":" + item.getTextureName());
	}
}
