package messages;

/**
 *	Message contenant un entier identifiant le jeu souhaite
 */
public class CHOOSE_GAME {
	private int gameId;
	
	public CHOOSE_GAME(int i){
		gameId = i;
	}
	
	public void setGameId(int i){
		gameId = i;
	}
	
	public int getGameId(){
		return gameId;
	}
}
