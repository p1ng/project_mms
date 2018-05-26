package game;

public abstract class Enemy {

	private final String name;
	private int hp;
	private final int maxHp;
	private final int defense;
	private final int damage;
	private final Item[] inventory = new Item[1];

	public Enemy(String name, int hp, int defense, int damage, Item item, int maxHp) {
		this.name = name;
		this.hp = hp;
		this.defense = defense;
		this.damage = damage;
		this.maxHp = maxHp;
		this.inventory[0] = item;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getDefense() {
		return defense;
	}

	public int getDamage() {
		return damage;
	}

	public Item[] getInventory(){
		return inventory;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void heal(int amount){
		if(hp + amount > maxHp){
			hp = maxHp;
		} else {
			hp += amount;
		}
	}

	public abstract void attack();

	public void useItem(Item item){
		if(inventory[0].isUsable() && !inventory[0].wasUsed()){
			useItem(inventory[0]);
		}
	}
}
