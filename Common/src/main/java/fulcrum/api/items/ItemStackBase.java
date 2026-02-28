package fulcrum.api.items;

public class ItemStackBase implements IItemStack {
	IItem item;
	int amount;

	public ItemStackBase(IItem item, int amount) {
		this.item = item;
		this.amount = amount;
	}

	@Override
	public IItem getItem() {
		return item;
	}

	@Override
	public String getItemName() {
		return item.getRegistryName();
	}

	@Override
	public int getAmount() {
		return amount;
	}
}
