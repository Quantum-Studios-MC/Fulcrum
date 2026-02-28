package fulcrum.api.items;

public interface IItemStack {
	IItem getItem();
	String getItemName();
	int getAmount();
}
