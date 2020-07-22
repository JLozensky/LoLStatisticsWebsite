package lol.model;

public class TeamStats {
	
	private String teamStatsId;
	private String win;
	private boolean firstBlood;
	private boolean firstTower;
	private boolean firstInhibitor;
	private boolean firstBaron;
	private boolean firstDragon;
	private boolean firstRiftHerald;
	private int towerKills;
	private int inhibitorKills;
	private int baronKills;
	private int dragonKills;
	private int vilemawKills;
	private int riftHeraldKills;
	private int dominionVictoryScore;
	private int banOne;
	private int banTwo;
	private int banThree;
	private int banFour;
	private int banFive;
	private Game game;
	
	public TeamStats(String teamStatsId, String win, boolean firstBlood, boolean firstTower, boolean firstInhibitor,
									 boolean firstBaron, boolean firstDragon, boolean firstRiftHerald, int towerKills, int inhibitorKills,
									 int baronKills, int dragonKills, int vilemawKills, int riftHeraldKills, int dominionVictoryScore,
									 int banOne, int banTwo, int banThree, int banFour, int banFive, Game game) {
		this.teamStatsId = teamStatsId;
		this.win = win;
		this.firstBlood = firstBlood;
		this.firstTower = firstTower;
		this.firstInhibitor = firstInhibitor;
		this.firstBaron = firstBaron;
		this.firstDragon = firstDragon;
		this.firstRiftHerald = firstRiftHerald;
		this.towerKills = towerKills;
		this.inhibitorKills = inhibitorKills;
		this.baronKills = baronKills;
		this.dragonKills = dragonKills;
		this.vilemawKills = vilemawKills;
		this.riftHeraldKills = riftHeraldKills;
		this.dominionVictoryScore = dominionVictoryScore;
		this.banOne = banOne;
		this.banTwo = banTwo;
		this.banThree = banThree;
		this.banFour = banFour;
		this.banFive = banFive;
		this.game = game;
	}
	
	public String  getTeamStatsId() {
		return teamStatsId;
	}

	public void setTeamStatsId(String teamStatsId) {
		this.teamStatsId = teamStatsId;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public boolean isFirstBlood() {
		return firstBlood;
	}

	public void setFirstBlood(boolean firstBlood) {
		this.firstBlood = firstBlood;
	}

	public boolean isFirstTower() {
		return firstTower;
	}
	
	public void setFirstTower(boolean firstTower) {
		this.firstTower = firstTower;
	}
	
	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}
	
	public void setFirstInhibitor(boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}
	
	public boolean isFirstBaron() {
		return firstBaron;
	}
	
	public void setFirstBaron(boolean firstBaron) {
		this.firstBaron = firstBaron;
	}
	
	public boolean isFirstDragon() {
		return firstDragon;
	}

	public void setFirstDragon(boolean firstDragon) {
		this.firstDragon = firstDragon;
	}
	
	public boolean isFirstRiftHerald() {
		return firstRiftHerald;
	}
	
	public void setFirstRiftHerald(boolean firstRiftHerald) {
		this.firstRiftHerald = firstRiftHerald;
	}

	public int getTowerKills() {
		return towerKills;
	}
	
	public void setTowerKills(int towerKills) {
		this.towerKills = towerKills;
	}

	public int getInhibitorKills() {
		return inhibitorKills;
	}
	
	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}
	
	public int getBaronKills() {
		return baronKills;
	}

	public void setBaronKills(int baronKills) {
		this.baronKills = baronKills;
	}
	
	public int getDragonKills() {
		return dragonKills;
	}

	public void setDragonKills(int dragonKills) {
		this.dragonKills = dragonKills;
	}
	
	public int getVilemawKills() {
		return vilemawKills;
	}
	
	public void setVilemawKills(int vilemawKills) {
		this.vilemawKills = vilemawKills;
	}
	
	public int getRiftHeraldKills() {
		return riftHeraldKills;
	}

	public void setRiftHeraldKills(int riftHeraldKills) {
		this.riftHeraldKills = riftHeraldKills;
	}

	public int getDominionVictoryScore() {
		return dominionVictoryScore;
	}
	
	public void setDominionVictoryScore(int dominionVictoryScore) {
		this.dominionVictoryScore = dominionVictoryScore;
	}

	public int getBanOne() {
		return banOne;
	}
	
	public void setBanOne(int banOne) {
		this.banOne = banOne;
	}
	
	public int getBanTwo() {
		return banTwo;
	}
	
	public void setBanTwo(int banTwo) {
		this.banTwo = banTwo;
	}

	public int getBanThree() {
		return banThree;
	}
	
	public void setBanThree(int banThree) {
		this.banThree = banThree;
	}
	
	public int getBanFour() {
		return banFour;
	}
	
	public void setBanFour(int banFour) {
		this.banFour = banFour;
	}
	
	public int getBanFive() {
		return banFive;
	}
	
	public void setBanFive(int banFive) {
		this.banFive = banFive;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
}
