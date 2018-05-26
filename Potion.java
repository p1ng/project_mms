package game;


public class Potion extends Item {

	private final int health;


	public Potion(String name, int price, int health) {
		super(name, price, true, ItemType.POTION, false);
		this.health = health;
	}

	public int getHealth(){
		return health;
	}

	public boolean usePotion(Potion potion, Player player){
		player.heal(potion.getHealth());
		return useItem(potion);
	}

	public boolean usePotionEnemy(Potion potion, Enemy enemy){
		enemy.heal(potion.getHealth());
		return useItem(potion);
	}

}
