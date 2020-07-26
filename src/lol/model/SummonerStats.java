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
	private long totalDamageDealt;
	private long magicDamageDealt;
	private long physicalDamageDealt;
	private long trueDamageDealt;
	private long largestCriticalStrike;
	private long totalDamageDealtToChampions;
	private long magicDamageDealtToChampions;
	private long physicalDamageDealtToChampions;
	private long trueDamageDealtToChampions;
	private long totalHeal;
	private long totalUnitsHealed;
	private long damageSelfMitigated;
	private long damageDealtToObjectives;
	private long damageDealtToTurrets;
	private long visionScore;
	private long timeCCingOthers;
	private long totalDamageTaken;
	private long magicalDamageTaken;
	private long physicalDamageTaken;
	private long trueDamageTaken;
	private long goldEarned;
	private long goldSpent;
	private int turretKills;
	private long totalMinionsKilled;
	private long neutralMinionsKilled;
	private long neutralMinionsKilledTeamJungle;
	private long neutralMinionsKilledEnemyJungle;
	private long totalTimeCrowdControlDealt;
	private int champLevel;
	private int visionWardsBoughtInGame;
	private int sightWardsBoughtInGame;
	private int wardsPlaced;
	private int wardsKilled;
	private boolean firstBloodKill;
	private boolean firstBloodAssist;
	private boolean firstTowerKill;
	private boolean firstTowerAssist;
	private boolean firstInhibitorKill;
	private boolean firstInhibitorAssist;
	private int combatPlayerScore;
	private int objectivePlayerScore;
	private int totalPlayerScore;
	private int totalScoreRank;
	private int perk0;
	private int perk1;
	private int perk2;
	private int perk3;
	private int perk4;
	private int perk5;
	private long perkPrimaryStyle;
	private long perkSubStyle;
	private String role;
	private String lane;
	private String highestAchievedSeasonTier;
	private Summoner summoner;
	
	public SummonerStats(String summonerStatsId, int championId, int spell1Id, int spell2Id, int itemId0,
											 int itemId1, int itemId2, int itemId3, int itemId4, int itemId5, int itemId6,
											 int kills, int deaths, int assists, long totalDamageDealt, long magicDamageDealt,
											 long physicalDamageDealt, long trueDamageDealt, long largestCriticalStrike,
											 long totalDamageDealtToChampions, long magicDamageDealtToChampions,
											 long physicalDamageDealtToChampions, long trueDamageDealtToChampions,
											 long totalHeal, long totalUnitsHealed, long damageSelfMitigated,
											 long damageDealtToObjectives, long damageDealtToTurrets, long visionScore,
											 long timeCCingOthers, long totalDamageTaken, long magicalDamageTaken,
											 long physicalDamageTaken, long trueDamageTaken, long goldEarned, long goldSpent,
											 int turretKills, long totalMinionsKilled, long neutralMinionsKilled,
											 long neutralMinionsKilledTeamJungle, long neutralMinionsKilledEnemyJungle,
											 long totalTimeCrowdControlDealt, int champLevel, int visionWardsBoughtInGame,
											 int sightWardsBoughtInGame, int wardsPlaced, int wardsKilled,
											 boolean firstBloodKill, boolean firstBloodAssist, boolean firstTowerKill,
											 boolean firstTowerAssist, boolean firstInhibitorKill, boolean firstInhibitorAssist,
											 int combatPlayerScore, int objectivePlayerScore, int totalPlayerScore,
											 int totalScoreRank, int perk0, int perk1, int perk2, int perk3, int perk4, 
											 int perk5, long perkPrimaryStyle, long perkSubStyle, String role, String lane, 
											 String highestAchievedSeasonTier, Summoner summoner) {
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
		this.totalUnitsHealed = totalUnitsHealed;
		this.damageSelfMitigated = damageSelfMitigated;
		this.damageDealtToObjectives = damageDealtToObjectives;
		this.damageDealtToTurrets = damageDealtToTurrets;
		this.visionScore = visionScore;
		this.timeCCingOthers = timeCCingOthers;
		this.totalDamageTaken = totalDamageTaken;
		this.magicalDamageTaken = magicalDamageTaken;
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
		this.firstTowerAssist = firstTowerAssist;
		this.firstInhibitorKill = firstInhibitorKill;
		this.firstInhibitorAssist = firstInhibitorAssist;
		this.combatPlayerScore = combatPlayerScore;
		this.objectivePlayerScore = objectivePlayerScore;
		this.totalPlayerScore = totalPlayerScore;
		this.totalScoreRank = totalScoreRank;
		this.perk0 = perk0;
		this.perk1 = perk1;
		this.perk2 = perk2;
		this.perk3 = perk3;
		this.perk4 = perk4;
		this.perk5 = perk5;
		this.perkPrimaryStyle = perkPrimaryStyle;
		this.perkSubStyle = perkSubStyle;
		this.role = role;
		this.lane = lane;
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
		this.summoner = summoner;
	}

	public SummonerStats() {

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

	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(long totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public long getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(long magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(long physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public long getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(long trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public long getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(long largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(long totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(long magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(long physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(long trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public long getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(long totalHeal) {
		this.totalHeal = totalHeal;
	}

	public long getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public void setTotalUnitsHealed(long totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public long getDamageSelfMitigated() {
		return damageSelfMitigated;
	}

	public void setDamageSelfMitigated(long damageSelfMitigated) {
		this.damageSelfMitigated = damageSelfMitigated;
	}

	public long getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}

	public void setDamageDealtToObjectives(long damageDealtToObjectives) {
		this.damageDealtToObjectives = damageDealtToObjectives;
	}

	public long getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}

	public void setDamageDealtToTurrets(long damageDealtToTurrets) {
		this.damageDealtToTurrets = damageDealtToTurrets;
	}

	public long getVisionScore() {
		return visionScore;
	}

	public void setVisionScore(long visionScore) {
		this.visionScore = visionScore;
	}

	public long getTimeCCingOthers() {
		return timeCCingOthers;
	}

	public void setTimeCCingOthers(long timeCCingOthers) {
		this.timeCCingOthers = timeCCingOthers;
	}

	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(long totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public long getMagicalDamageTaken() {
		return magicalDamageTaken;
	}

	public void setMagicalDamageTaken(long magicalDamageTaken) {
		this.magicalDamageTaken = magicalDamageTaken;
	}

	public long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(long physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public long getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(long trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public long getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(long goldEarned) {
		this.goldEarned = goldEarned;
	}

	public long getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(long goldSpent) {
		this.goldSpent = goldSpent;
	}

	public int getTurretKills() {
		return turretKills;
	}

	public void setTurretKills(int turretKills) {
		this.turretKills = turretKills;
	}

	public long getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(long totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public long getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(long neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public long getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(long neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public long getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledEnemyJungle(long neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public long getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public void setTotalTimeCrowdControlDealt(long totalTimeCrowdControlDealt) {
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

	public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
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

	public boolean isFirstTowerAssist() {
		return firstTowerAssist;
	}

	public void setFirstTowerAssist(boolean firstTowerAssist) {
		this.firstTowerAssist = firstTowerAssist;
	}

	public boolean isFirstInhibitorKill() {
		return firstInhibitorKill;
	}

	public void setFirstInhibitorKill(boolean firstInhibitorKill) {
		this.firstInhibitorKill = firstInhibitorKill;
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

	public int getPerk0() {
		return perk0;
	}

	public void setPerk0(int perk0) {
		this.perk0 = perk0;
	}

	public int getPerk1() {
		return perk1;
	}

	public void setPerk1(int perk1) {
		this.perk1 = perk1;
	}

	public int getPerk2() {
		return perk2;
	}

	public void setPerk2(int perk2) {
		this.perk2 = perk2;
	}

	public int getPerk3() {
		return perk3;
	}

	public void setPerk3(int perk3) {
		this.perk3 = perk3;
	}

	public int getPerk4() {
		return perk4;
	}

	public void setPerk4(int perk4) {
		this.perk4 = perk4;
	}

	public int getPerk5() {
		return perk5;
	}

	public void setPerk5(int perk5) {
		this.perk5 = perk5;
	}
	
	public long getPerkPrimaryStyle() {
		return perkPrimaryStyle;
	}

	public void setPerkPrimaryStyle(long perkPrimaryStyle) {
		this.perkPrimaryStyle = perkPrimaryStyle;
	}

	public long getPerkSubStyle() {
		return perkSubStyle;
	}

	public void setPerkSubStyle(long perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}

	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	public Summoner getSummoner() {
		return summoner;
	}

	public void setSummoner(Summoner summoner) {
		this.summoner = summoner;
	}
}