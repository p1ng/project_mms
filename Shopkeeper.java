package game;

import java.util.ArrayList;

public class Shopkeeper extends Npc {

	private final ArrayList<Item> inventory;


	public Shopkeeper(String name, ArrayList<Item> inventory, String... dialogue) {
		super(name, dialogue);
		this.inventory = inventory;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void addItem(Item item){
		inventory.add(item);
	}

	public void sellItem(Item item, Player player){
		if(player.getMoney() > item.getPrice()){
			player.pay(player.getMoney() - item.getPrice());
			player.addItem(item);
		}
	}

	public void buyItem(Item item, Player player){
		player.addMoney(item.getPrice());
		inventory.add(item);
	}
}
