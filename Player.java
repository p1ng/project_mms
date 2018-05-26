package game;

import java.util.ArrayList;

public class Player {

	private final String name;
	private final ArrayList<Item> inventory = new ArrayList<>();
	private static final int MAX_HP = 20;
	private int money;
	private int hp;
	private int damage;
	private int defense;
	private Item weapon;
	private Item armor;

	public Player(String name, int damage, int defense){
		this.name = name;
		this.hp = 20;
		this.damage = damage;
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public int getMoney() {
		return money;
	}

	public int getHp(){
		return hp;
	}

	public int getMaxHp(){
		return MAX_HP;
	}

	public void addItem(Item item){
		inventory.add(item);
	}

	public void removeUsedItemsFromInventory(){
		for(Item item : inventory){
			if(item.wasUsed()){
				inventory.remove(item);
			}
		}
	}

	public void heal(int amount){
		if(hp + amount > MAX_HP){
			hp = MAX_HP;
		} else {
			hp += amount;
		}
	}

	public boolean useItem(Item item){
		if(item.isUsable() && !item.wasUsed()){
			useItem(item);
			return true;
		} else {
			return false;
		}
	}

	public void equipArmor(Armor armor){
		armor = armor;
		this.defense += armor.getDefense();

	}

	public void equipWeapon(Weapon weapon){

		this.weapon = weapon;
		this.damage += weapon.getDamage();
	}

	public int attack(){
		return damage;
	}

	public void addMoney(int amount){
		money += amount;
	}

	public void pay(int amount){
		money -= amount;
	}

}
