package lol.model;

public class Game {
	
	private String gameId;
	private String date;
	private int gameDuration;
	private int queueId;
	private int mapId;
	private int seasonId;
	private String gameVersion;
	private String gameMode;
	private String gameType;
	
	public Game(String gameId, String date, int gameDuration, int queueId, int mapId, int seasonId, 
							String gameVersion, String gameMode, String gameType) {
		this.gameId = gameId;
		this.date = date;
		this.gameDuration = gameDuration;
		this.queueId = queueId;
		this.mapId = mapId;
		this.seasonId = seasonId;
		this.gameVersion = gameVersion;
		this.gameMode = gameMode;
		this.gameType = gameType;
	}
	

	public String getGameId() {
		return gameId;
	}


	public void setGameId(String gameId) {
		this.gameId = gameId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getGameDuration() {
		return gameDuration;
	}


	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}


	public int getQueueId() {
		return queueId;
	}


	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}


	public int getMapId() {
		return mapId;
	}


	public void setMapId(int mapId) {
		this.mapId = mapId;
	}


	public int getSeasonId() {
		return seasonId;
	}


	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}


	public String getGameVersion() {
		return gameVersion;
	}


	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}


	public String getGameMode() {
		return gameMode;
	}


	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}


	public String getGameType() {
		return gameType;
	}


	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	
	
}
