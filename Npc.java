package game;

public class Npc {

	private final String name;
	private String[] dialogue;

	public Npc(String name, String ... dialogue){
		this.name = name;
		this.dialogue = dialogue;
	}

	public String getName(){
		return this.name;
	}

	public String[] getDialogue() {
		return dialogue;
	}


}
