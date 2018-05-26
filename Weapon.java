package game;

public class Weapon extends Item {

	private int damage;


	public Weapon(String name, int price, int damage) {
		super(name, price, false, ItemType.WEAPON, true);
		this.damage = damage;
	}

	public int getDamage(){
		return this.damage;
	}
}
