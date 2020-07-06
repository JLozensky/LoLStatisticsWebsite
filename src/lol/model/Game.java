package lol.model;

public class Game {

	
	private int gameId;
	private String date;
	private int gameDuration;
	private int queueId;
	private int mapId;
	private int seasonId;
	private int gameVersion;
	private int gameMode;
	private int gameType;
	private int team1;
	private int team2;
	
	
	public Game(int gameId, String date, int gameDuration, int queueId, int mapId, int seasonId, int gameVersion,
			int gameMode, int gameType, int team1, int team2) {
		this.gameId = gameId;
		this.date = date;
		this.gameDuration = gameDuration;
		this.queueId = queueId;
		this.mapId = mapId;
		this.seasonId = seasonId;
		this.gameVersion = gameVersion;
		this.gameMode = gameMode;
		this.gameType = gameType;
		this.team1 = team1;
		this.team2 = team2;
	}


	public int getGameId() {
		return gameId;
	}


	public void setGameId(int gameId) {
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


	public int getGameVersion() {
		return gameVersion;
	}


	public void setGameVersion(int gameVersion) {
		this.gameVersion = gameVersion;
	}


	public int getGameMode() {
		return gameMode;
	}


	public void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}


	public int getGameType() {
		return gameType;
	}


	public void setGameType(int gameType) {
		this.gameType = gameType;
	}


	public int getTeam1() {
		return team1;
	}


	public void setTeam1(int team1) {
		this.team1 = team1;
	}


	public int getTeam2() {
		return team2;
	}


	public void setTeam2(int team2) {
		this.team2 = team2;
	}
	
	
	
	
	
	
}
