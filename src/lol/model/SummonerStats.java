package lol.model;

public class SummonerStats {
	
	private String summonerStatsId;
	private int championId;
	private int spell1Id;
	private int spell2Id;
	private int itemId0;
	private int itemId1;
	private int itemId2;
	private int itemId3;
	private int itemId4;
	private int itemId5;
	private int itemId6;
	private int kills;
	private int deaths;
	private int assists;
	private int totalDamageDealt;
	private int magicDamageDealt;
	private int physicalDamageDealt;
	private int trueDamageDealt;
	private int largestCriticalStrike;
	private int totalDamageDealtToChampions;
	private int magicDamageDealtToChampions;
	private int physicalDamageDealtToChampions;
	private int trueDamageDealtToChampions;
	private int totalHeal;
	private int totalUnitHealed;
	private int damageSelfMitigated;
	private int damageDealtToObjectives;
	private int damageDealtToTurrets;
	private int visionScore;
	private int timeCCingOthers;
	private int totalDamageTaken;
	private int magicDamageTaken;
	private int physicalDamageTaken;
	private int trueDamageTaken;
	private int goldEarned;
	private int goldSpent;
	private int turretKills;
	private int totalMinionsKilled;
	private int neutralMinionsKilled;
	private int neutralMinionsKilledTeamJungle;
	private int neutralMinionsKilledEnemyJungle;
	private int totalTimeCrowdControlDealt;
	private int champLevel;
	private int visionWardsBoughtInGame;
	private int sightWardsBoughtInGame;
	private int wardsPlaced;
	private int wardsKilled;
	private boolean firstBloodKill;
	private boolean firstBloodAssist;
	private boolean firstTowerKill;
	private boolean firstTowerKillAssist;
	private boolean firstInhibitor;
	private boolean firstInhibitorAssist;
	private int combatPlayerScore;
	private int objectivePlayerScore;
	private int totalPlayerScore;
	private int totalScoreRank;
	private String role;
	private String lane;
	private int runeId0;
	private int runeId1;
	private int runeId2;
	private int runeId3;
	private int runeId4;
	private int runeId5;
	private String highestAchievedSeasonTier;

	public SummonerStats() {
		
	}

	

	public SummonerStats(String summonerStatsId, int championId, int spell1Id, int spell2Id, int itemId0, int itemId1,
											 int itemId2, int itemId3, int itemId4, int itemId5, int itemId6, int kills, int deaths, int assists,
											 int totalDamageDealt, int magicDamageDealt, int physicalDamageDealt, int trueDamageDealt,
											 int largestCriticalStrike, int totalDamageDealtToChampions, int magicDamageDealtToChampions,
											 int physicalDamageDealtToChampions, int trueDamageDealtToChampions, int totalHeal, int totalUnitHealed,
											 int damageSelfMitigated, int damageDealtToObjectives, int damageDealtToTurrets, int visionScore,
											 int timeCCingOthers, int totalDamageTaken, int magicDamageTaken, int physicalDamageTaken,
											 int trueDamageTaken, int goldEarned, int goldSpent, int turretKills, int totalMinionsKilled,
											 int neutralMinionsKilled, int neutralMinionsKilledTeamJungle, int neutralMinionsKilledEnemyJungle,
											 int totalTimeCrowdControlDealt, int champLevel, int visionWardsBoughtInGame, int sightWardsBoughtInGame,
											 int wardsPlaced, int wardsKilled, boolean firstBloodKill, boolean firstBloodAssist, boolean firstTowerKill,
											 boolean firstTowerKillAssist, boolean firstInhibitor, boolean firstInhibitorAssist, int combatPlayerScore,
											 int objectivePlayerScore, int totalPlayerScore, int totalScoreRank, String role, String lane,
											 int runeId0, int runeId1, int runeId2, int runeId3, int runeId4, int runeId5,
											 String highestAchievedSeasonTier) {
		this.summonerStatsId = summonerStatsId;
		this.championId = championId;
		this.spell1Id = spell1Id;
		this.spell2Id = spell2Id;
		this.itemId0 = itemId0;
		this.itemId1 = itemId1;
		this.itemId2 = itemId2;
		this.itemId3 = itemId3;
		this.itemId4 = itemId4;
		this.itemId5 = itemId5;
		this.itemId6 = itemId6;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.totalDamageDealt = totalDamageDealt;
		this.magicDamageDealt = magicDamageDealt;
		this.physicalDamageDealt = physicalDamageDealt;
		this.trueDamageDealt = trueDamageDealt;
		this.largestCriticalStrike = largestCriticalStrike;
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
		this.totalHeal = totalHeal;
		this.totalUnitHealed = totalUnitHealed;
		this.damageSelfMitigated = damageSelfMitigated;
		this.damageDealtToObjectives = damageDealtToObjectives;
		this.damageDealtToTurrets = damageDealtToTurrets;
		this.visionScore = visionScore;
		this.timeCCingOthers = timeCCingOthers;
		this.totalDamageTaken = totalDamageTaken;
		this.magicDamageTaken = magicDamageTaken;
		this.physicalDamageTaken = physicalDamageTaken;
		this.trueDamageTaken = trueDamageTaken;
		this.goldEarned = goldEarned;
		this.goldSpent = goldSpent;
		this.turretKills = turretKills;
		this.totalMinionsKilled = totalMinionsKilled;
		this.neutralMinionsKilled = neutralMinionsKilled;
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
		this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
		this.champLevel = champLevel;
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
		this.wardsPlaced = wardsPlaced;
		this.wardsKilled = wardsKilled;
		this.firstBloodKill = firstBloodKill;
		this.firstBloodAssist = firstBloodAssist;
		this.firstTowerKill = firstTowerKill;
		this.firstTowerKillAssist = firstTowerKillAssist;
		this.firstInhibitor = firstInhibitor;
		this.firstInhibitorAssist = firstInhibitorAssist;
		this.combatPlayerScore = combatPlayerScore;
		this.objectivePlayerScore = objectivePlayerScore;
		this.totalPlayerScore = totalPlayerScore;
		this.totalScoreRank = totalScoreRank;
		this.role = role;
		this.lane = lane;
		this.runeId0 = runeId0;
		this.runeId1 = runeId1;
		this.runeId2 = runeId2;
		this.runeId3 = runeId3;
		this.runeId4 = runeId4;
		this.runeId5 = runeId5;
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	public String getSummonerStatsId() {
		return summonerStatsId;
	}

	public void setSummonerStatsId(String summonerStatsId) {
		this.summonerStatsId = summonerStatsId;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}

	public int getItemId0() {
		return itemId0;
	}

	public void setItemId0(int itemId0) {
		this.itemId0 = itemId0;
	}

	public int getItemId1() {
		return itemId1;
	}

	public void setItemId1(int itemId1) {
		this.itemId1 = itemId1;
	}

	public int getItemId2() {
		return itemId2;
	}

	public void setItemId2(int itemId2) {
		this.itemId2 = itemId2;
	}

	public int getItemId3() {
		return itemId3;
	}

	public void setItemId3(int itemId3) {
		this.itemId3 = itemId3;
	}

	public int getItemId4() {
		return itemId4;
	}

	public void setItemId4(int itemId4) {
		this.itemId4 = itemId4;
	}

	public int getItemId5() {
		return itemId5;
	}

	public void setItemId5(int itemId5) {
		this.itemId5 = itemId5;
	}

	public int getItemId6() {
		return itemId6;
	}

	public void setItemId6(int itemId6) {
		this.itemId6 = itemId6;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public int getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(int magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public int getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(int physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public int getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(int trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public int getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(int largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public int getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public int getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public int getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public int getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public int getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(int totalHeal) {
		this.totalHeal = totalHeal;
	}

	public int getTotalUnitHealed() {
		return totalUnitHealed;
	}

	public void setTotalUnitHealed(int totalUnitHealed) {
		this.totalUnitHealed = totalUnitHealed;
	}

	public int getDamageSelfMitigated() {
		return damageSelfMitigated;
	}

	public void setDamageSelfMitigated(int damageSelfMitigated) {
		this.damageSelfMitigated = damageSelfMitigated;
	}

	public int getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}

	public void setDamageDealtToObjectives(int damageDealtToObjectives) {
		this.damageDealtToObjectives = damageDealtToObjectives;
	}

	public int getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}

	public void setDamageDealtToTurrets(int damageDealtToTurrets) {
		this.damageDealtToTurrets = damageDealtToTurrets;
	}

	public int getVisionScore() {
		return visionScore;
	}

	public void setVisionScore(int visionScore) {
		this.visionScore = visionScore;
	}

	public int getTimeCCingOthers() {
		return timeCCingOthers;
	}

	public void setTimeCCingOthers(int timeCCingOthers) {
		this.timeCCingOthers = timeCCingOthers;
	}

	public int getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(int totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public int getMagicDamageTaken() {
		return magicDamageTaken;
	}

	public void setMagicDamageTaken(int magicDamageTaken) {
		this.magicDamageTaken = magicDamageTaken;
	}

	public int getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(int physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public int getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(int trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public int getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
	}

	public int getTurretKills() {
		return turretKills;
	}

	public void setTurretKills(int turretKills) {
		this.turretKills = turretKills;
	}

	public int getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(int totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public int getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(int neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public int getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(int neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public int getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledEnemyJungle(int neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public int getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public void setTotalTimeCrowdControlDealt(int totalTimeCrowdControlDealt) {
		this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
	}

	public int getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}

	public int getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}

	public int getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	public void setSightWardsBoughtInGame(int sightWardsBoughtInGamel) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGamel;
	}

	public int getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public int getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}

	public void setFirstBloodKill(boolean firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}

	public boolean isFirstBloodAssist() {
		return firstBloodAssist;
	}

	public void setFirstBloodAssist(boolean firstBloodAssist) {
		this.firstBloodAssist = firstBloodAssist;
	}

	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}

	public void setFirstTowerKill(boolean firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}

	public boolean isFirstTowerKillAssist() {
		return firstTowerKillAssist;
	}

	public void setFirstTowerKillAssist(boolean firstTowerKillAssist) {
		this.firstTowerKillAssist = firstTowerKillAssist;
	}

	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}

	public void setFirstInhibitor(boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}

	public boolean isFirstInhibitorAssist() {
		return firstInhibitorAssist;
	}

	public void setFirstInhibitorAssist(boolean firstInhibitorAssist) {
		this.firstInhibitorAssist = firstInhibitorAssist;
	}

	public int getCombatPlayerScore() {
		return combatPlayerScore;
	}

	public void setCombatPlayerScore(int combatPlayerScore) {
		this.combatPlayerScore = combatPlayerScore;
	}

	public int getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	public void setObjectivePlayerScore(int objectivePlayerScore) {
		this.objectivePlayerScore = objectivePlayerScore;
	}

	public int getTotalPlayerScore() {
		return totalPlayerScore;
	}

	public void setTotalPlayerScore(int totalPlayerScore) {
		this.totalPlayerScore = totalPlayerScore;
	}

	public int getTotalScoreRank() {
		return totalScoreRank;
	}

	public void setTotalScoreRank(int totalScoreRank) {
		this.totalScoreRank = totalScoreRank;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}
	
	public int getRuneId0() {
		return runeId0;
	}

	public void setRuneId0(int runeId0) {
		this.runeId0 = runeId0;
	}

	public int getRuneId1() {
		return runeId1;
	}

	public void setRuneId1(int runeId1) {
		this.runeId1 = runeId1;
	}

	public int getRuneId2() {
		return runeId2;
	}

	public void setRuneId2(int runeId2) {
		this.runeId2 = runeId2;
	}

	public int getRuneId3() {
		return runeId3;
	}

	public void setRuneId3(int runeId3) {
		this.runeId3 = runeId3;
	}

	public int getRuneId4() {
		return runeId4;
	}

	public void setRuneId4(int runeId4) {
		this.runeId4 = runeId4;
	}

	public int getRuneId5() {
		return runeId5;
	}

	public void setRuneId5(int runeId5) {
		this.runeId5 = runeId5;
	}

	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}
	
}
