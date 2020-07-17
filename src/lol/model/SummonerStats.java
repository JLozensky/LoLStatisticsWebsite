package lol.model;

public class SummonerStats {
	
	private int summonerStatsId;
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
	private int sightWardsBoughtInGamel;
	private int wardsPlaced;
	private int wardsKilled;
	private boolean firstBloodKill;
	private boolean firstBloodAssist;
	private boolean firstTowerKill;
	private boolean firstTowerKillAssist;
	private boolean firstInHibitor;
	private boolean firstInHibitorAssist;
	private int combatPlayerScore;
	private int objectivePlayerScore;
	private int totalPlayerScore;
	private int totalScoreRank;
	private Role role;
	private Lane lane;
	private int perk0;
	private int perk0Var1;
	private int perk0Var2;
	private int perk0Var3;
	private int perk1;
	private int perk1Var1;
	private int perk1Var2;
	private int perk1Var3;
	private int perk2;
	private int perk2Var1;
	private int perk2Var2;
	private int perk2Var3;
	private int perk3;
	private int perk3Var1;
	private int perk3Var2;
	private int perk3Var3;
	private int perk4;
	private int perk4Var1;
	private int perk4Var2;
	private int perk4Var3;
	private int perk5;
	private int perk5Var1;
	private int perk50Var2;
	private int perk5Var3;
	private int perkPrimaryStyle;
	private int perkSubStyle;
	private int accountId;
	
	
	public enum Role {
		FIGHTER, MAGE, ASSASSIN, TANK, MARKSMAN, SUPPORT
	}
	
	public enum Lane {
		TOP, MIDDLE, BOTTOM, SUPPORT
	}

	public SummonerStats(int summonerStatsId, int championId, int spell1Id, int spell2Id, int itemId0, int itemId1,
			int itemId2, int itemId3, int itemId4, int itemId5, int itemId6, int kills, int deaths, int assists,
			int totalDamageDealt, int magicDamageDealt, int physicalDamageDealt, int trueDamageDealt,
			int largestCriticalStrike, int totalDamageDealtToChampions, int magicDamageDealtToChampions,
			int physicalDamageDealtToChampions, int trueDamageDealtToChampions, int totalHeal, int totalUnitHealed,
			int damageSelfMitigated, int damageDealtToObjectives, int damageDealtToTurrets, int visionScore,
			int timeCCingOthers, int totalDamageTaken, int magicDamageTaken, int physicalDamageTaken,
			int trueDamageTaken, int goldEarned, int goldSpent, int turretKills, int totalMinionsKilled,
			int neutralMinionsKilled, int neutralMinionsKilledTeamJungle, int neutralMinionsKilledEnemyJungle,
			int totalTimeCrowdControlDealt, int champLevel, int visionWardsBoughtInGame, int sightWardsBoughtInGamel,
			int wardsPlaced, int wardsKilled, boolean firstBloodKill, boolean firstBloodAssist, boolean firstTowerKill,
			boolean firstTowerKillAssist, boolean firstInHibitor, boolean firstInHibitorAssist, int combatPlayerScore,
			int objectivePlayerScore, int totalPlayerScore, int totalScoreRank, Role role, Lane lane, int perk0,
			int perk0Var1, int perk0Var2, int perk0Var3, int perk1, int perk1Var1, int perk1Var2, int perk1Var3,
			int perk2, int perk2Var1, int perk2Var2, int perk2Var3, int perk3, int perk3Var1, int perk3Var2,
			int perk3Var3, int perk4, int perk4Var1, int perk4Var2, int perk4Var3, int perk5, int perk5Var1,
			int perk50Var2, int perk5Var3, int perkPrimaryStyle, int perkSubStyle, int accountId) {
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
		this.sightWardsBoughtInGamel = sightWardsBoughtInGamel;
		this.wardsPlaced = wardsPlaced;
		this.wardsKilled = wardsKilled;
		this.firstBloodKill = firstBloodKill;
		this.firstBloodAssist = firstBloodAssist;
		this.firstTowerKill = firstTowerKill;
		this.firstTowerKillAssist = firstTowerKillAssist;
		this.firstInHibitor = firstInHibitor;
		this.firstInHibitorAssist = firstInHibitorAssist;
		this.combatPlayerScore = combatPlayerScore;
		this.objectivePlayerScore = objectivePlayerScore;
		this.totalPlayerScore = totalPlayerScore;
		this.totalScoreRank = totalScoreRank;
		this.role = role;
		this.lane = lane;
		this.perk0 = perk0;
		this.perk0Var1 = perk0Var1;
		this.perk0Var2 = perk0Var2;
		this.perk0Var3 = perk0Var3;
		this.perk1 = perk1;
		this.perk1Var1 = perk1Var1;
		this.perk1Var2 = perk1Var2;
		this.perk1Var3 = perk1Var3;
		this.perk2 = perk2;
		this.perk2Var1 = perk2Var1;
		this.perk2Var2 = perk2Var2;
		this.perk2Var3 = perk2Var3;
		this.perk3 = perk3;
		this.perk3Var1 = perk3Var1;
		this.perk3Var2 = perk3Var2;
		this.perk3Var3 = perk3Var3;
		this.perk4 = perk4;
		this.perk4Var1 = perk4Var1;
		this.perk4Var2 = perk4Var2;
		this.perk4Var3 = perk4Var3;
		this.perk5 = perk5;
		this.perk5Var1 = perk5Var1;
		this.perk50Var2 = perk50Var2;
		this.perk5Var3 = perk5Var3;
		this.perkPrimaryStyle = perkPrimaryStyle;
		this.perkSubStyle = perkSubStyle;
		this.accountId = accountId;
	}

	public SummonerStats(String summonerStatsId2, int championId2, int spell1Id2, int spell2Id2, int itemId02,
			int itemId12, int itemId22, int itemId32, int itemId42, int itemId52, int itemId62, int kills2, int deaths2,
			int assists2, long totalDamageDealt2, long magicDamageDealt2, long physicalDamageDealt2,
			long trueDamageDealt2, long largestCriticalStrike2, long totalDamageDealtToChampions2,
			long magicDamageDealtToChampions2, long physicalDamageDealtToChampions2, long trueDamageDealtToChampions2,
			long totalHeal2, long totalUnitHealed2, long damageSelfMitigated2, long damageDealtToObjectives2,
			long damageDealtToTurrets2, long visionScore2, long timeCCingOthers2, long totalDamageTaken2,
			long magicDamageTaken2, long physicalDamageTaken2, long trueDamageTaken2, long goldEarned2, long goldSpent2,
			int turretKills2, long totalMinionsKilled2, long neutralMinionsKilled2,
			long neutralMinionsKilledTeamJungle2, long neutralMinionsKilledEnemyJungle2,
			long totalTimeCrowdControlDealt2, int champLevel2, int visionWardsBoughtInGame2, int sightWardsBoughtInGame,
			int wardsPlaced2, int wardsKilled2, boolean firstBloodKill2, boolean firstBloodAssist2,
			boolean firstTowerKill2, boolean firstTowerKillAssist2, boolean firstInhibitor2,
			boolean firstInhibitorAssist2, int combatPlayerScore2, int objectivePlayerScore2, int totalPlayerScore2,
			int totalScoreRank2, String role2, String lane2, int runeId0, int runeId1, int runeId2, int runeId3,
			int runeId4, int runeId5, String highestAchievedSeasonTier) {
		// TODO Auto-generated constructor stub
	}

	public int getSummonerStatsId() {
		return summonerStatsId;
	}

	public void setSummonerStatsId(int summonerStatsId) {
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

	public int getSightWardsBoughtInGamel() {
		return sightWardsBoughtInGamel;
	}

	public void setSightWardsBoughtInGamel(int sightWardsBoughtInGamel) {
		this.sightWardsBoughtInGamel = sightWardsBoughtInGamel;
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

	public boolean isFirstInHibitor() {
		return firstInHibitor;
	}

	public void setFirstInHibitor(boolean firstInHibitor) {
		this.firstInHibitor = firstInHibitor;
	}

	public boolean isFirstInHibitorAssist() {
		return firstInHibitorAssist;
	}

	public void setFirstInHibitorAssist(boolean firstInHibitorAssist) {
		this.firstInHibitorAssist = firstInHibitorAssist;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Lane getLane() {
		return lane;
	}

	public void setLane(Lane lane) {
		this.lane = lane;
	}

	public int getPerk0() {
		return perk0;
	}

	public void setPerk0(int perk0) {
		this.perk0 = perk0;
	}

	public int getPerk0Var1() {
		return perk0Var1;
	}

	public void setPerk0Var1(int perk0Var1) {
		this.perk0Var1 = perk0Var1;
	}

	public int getPerk0Var2() {
		return perk0Var2;
	}

	public void setPerk0Var2(int perk0Var2) {
		this.perk0Var2 = perk0Var2;
	}

	public int getPerk0Var3() {
		return perk0Var3;
	}

	public void setPerk0Var3(int perk0Var3) {
		this.perk0Var3 = perk0Var3;
	}

	public int getPerk1() {
		return perk1;
	}

	public void setPerk1(int perk1) {
		this.perk1 = perk1;
	}

	public int getPerk1Var1() {
		return perk1Var1;
	}

	public void setPerk1Var1(int perk1Var1) {
		this.perk1Var1 = perk1Var1;
	}

	public int getPerk1Var2() {
		return perk1Var2;
	}

	public void setPerk1Var2(int perk1Var2) {
		this.perk1Var2 = perk1Var2;
	}

	public int getPerk1Var3() {
		return perk1Var3;
	}

	public void setPerk1Var3(int perk1Var3) {
		this.perk1Var3 = perk1Var3;
	}

	public int getPerk2() {
		return perk2;
	}

	public void setPerk2(int perk2) {
		this.perk2 = perk2;
	}

	public int getPerk2Var1() {
		return perk2Var1;
	}

	public void setPerk2Var1(int perk2Var1) {
		this.perk2Var1 = perk2Var1;
	}

	public int getPerk2Var2() {
		return perk2Var2;
	}

	public void setPerk2Var2(int perk2Var2) {
		this.perk2Var2 = perk2Var2;
	}

	public int getPerk2Var3() {
		return perk2Var3;
	}

	public void setPerk2Var3(int perk2Var3) {
		this.perk2Var3 = perk2Var3;
	}

	public int getPerk3() {
		return perk3;
	}

	public void setPerk3(int perk3) {
		this.perk3 = perk3;
	}

	public int getPerk3Var1() {
		return perk3Var1;
	}

	public void setPerk3Var1(int perk3Var1) {
		this.perk3Var1 = perk3Var1;
	}

	public int getPerk3Var2() {
		return perk3Var2;
	}

	public void setPerk3Var2(int perk3Var2) {
		this.perk3Var2 = perk3Var2;
	}

	public int getPerk3Var3() {
		return perk3Var3;
	}

	public void setPerk3Var3(int perk3Var3) {
		this.perk3Var3 = perk3Var3;
	}

	public int getPerk4() {
		return perk4;
	}

	public void setPerk4(int perk4) {
		this.perk4 = perk4;
	}

	public int getPerk4Var1() {
		return perk4Var1;
	}

	public void setPerk4Var1(int perk4Var1) {
		this.perk4Var1 = perk4Var1;
	}

	public int getPerk4Var2() {
		return perk4Var2;
	}

	public void setPerk4Var2(int perk4Var2) {
		this.perk4Var2 = perk4Var2;
	}

	public int getPerk4Var3() {
		return perk4Var3;
	}

	public void setPerk4Var3(int perk4Var3) {
		this.perk4Var3 = perk4Var3;
	}

	public int getPerk5() {
		return perk5;
	}

	public void setPerk5(int perk5) {
		this.perk5 = perk5;
	}

	public int getPerk5Var1() {
		return perk5Var1;
	}

	public void setPerk5Var1(int perk5Var1) {
		this.perk5Var1 = perk5Var1;
	}

	public int getPerk50Var2() {
		return perk50Var2;
	}

	public void setPerk50Var2(int perk50Var2) {
		this.perk50Var2 = perk50Var2;
	}

	public int getPerk5Var3() {
		return perk5Var3;
	}

	public void setPerk5Var3(int perk5Var3) {
		this.perk5Var3 = perk5Var3;
	}

	public int getPerkPrimaryStyle() {
		return perkPrimaryStyle;
	}

	public void setPerkPrimaryStyle(int perkPrimaryStyle) {
		this.perkPrimaryStyle = perkPrimaryStyle;
	}

	public int getPerkSubStyle() {
		return perkSubStyle;
	}

	public void setPerkSubStyle(int perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
}
