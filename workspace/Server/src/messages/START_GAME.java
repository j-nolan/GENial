package messages;

/**
 * Indique aux joueurs que le mini-jeu peut commencer
 */
public class START_GAME {
	private int gameId;
	private int seed;
	
	public START_GAME(int gameId, int seed){
		this.gameId = gameId;
		this.seed = seed;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}
}
