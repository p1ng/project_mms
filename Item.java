package game;

public abstract class Item {

	private final String name;
	private final int price;
	private final boolean usable;
	private boolean used;
	private final ItemType type;
	private final boolean equipable;

	public Item(String name, int price, boolean usable, ItemType type, boolean equipable) {
		this.name = name;
		this.price = price;
		this.usable = usable;
		this.used = false;
		this.type = type;
		this.equipable = equipable;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isUsable() {
		return usable;
	}

	public boolean wasUsed() {
		return used;
	}

	public boolean isEquipable() {
		return equipable;
	}

	public ItemType getType() {
		return type;
	}

	public boolean useItem(Item item){
		if(item.usable) {
			this.used = true;
			return true;
		} else {
			return false;
		}
	}
}
