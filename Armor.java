package game;

public class Armor extends Item {

	private final int defense;

	public Armor(String name, int price, int defense){
		super(name, price, false, ItemType.ARMOR, true);
		this.defense = defense;
	}

	public int getDefense(){
		return this.defense;
	}
}
