package messages;

/**
 * Indique aux joueurs qui doit lancer son des
 */

public class Dice  {
	private String playerName;
	
	public Dice(){
		playerName = "";
	}
	
	public Dice(String name){
		playerName = name;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}