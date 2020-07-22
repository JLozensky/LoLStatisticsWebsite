package lol.dal;

import java.sql.*;

import lol.model.*;

/**
 * Data access object (DAO) class to interact with the SummonerStats table
 */
public class SummonerStatsDao {
  protected ConnectionManager connectionManager;

  // Single pattern: instantiation is limited to one object.
  private static SummonerStatsDao instance = null;

  private SummonerStatsDao() {
    connectionManager = new ConnectionManager();
  }

  public static SummonerStatsDao getInstance() {
    if (instance == null) {
      instance = new SummonerStatsDao();
    }
    return instance;
  }

  /**
   * Save the SummonerStats instance by storing it in MySQL instance.
   * This runs a INSERT statement.
   */
  public SummonerStats create(SummonerStats summonerStats) throws SQLException {
    String insertSummonerStats = "INSERT IGNORE INTO SummonerStats(summonerStatsId, championId, " +
            "spell1Id, spell2Id, itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, " +
            "kills, deaths, assists, totalDamageDealt, magicDamageDealt, physicalDamageDealt, " +
            "trueDamageDealt, largestCriticalStrike, totalDamageDealtToChampions, " +
            "magicDamageDealtToChampions, physicalDamageDealtToChampions, trueDamageDealtToChampions, " +
            "totalHeal, totalUnitsHealed, damageSelfMitigated, damageDealtToObjectives, " +
            "damageDealtToTurrets, visionScore, timeCCingOthers, totalDamageTaken, magicalDamageTaken, " +
            "physicalDamageTaken,trueDamageTaken, goldEarned, goldSpent, turretKills, totalMinionsKilled," +
            "neutralMinionsKilled, neutralMinionsKilledTeamJungle, neutralMinionsKilledEnemyJungle, " +
            "totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGame, " +
            "wardsPlaced, wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill," +
            "firstTowerAssist, firstInHibitorKill, firstInHibitorAssist, combatPlayerScore, " +
            "objectivePlayerScore, totalPlayerScore, totalScoreRank, role, lane, runeId0, runeId1, " +
            "runeId2, runeId3, runeId4, runeId5, highestAchievedSeasonTier, summonerName) VALUES(" +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertSummonerStats);

      insertStmt.setString(1, summonerStats.getSummonerStatsId());
      insertStmt.setInt(2, summonerStats.getChampionId());
      insertStmt.setInt(3, summonerStats.getSpell1Id());
      insertStmt.setInt(4, summonerStats.getSpell2Id());
      insertStmt.setInt(5, summonerStats.getItemId0());
      insertStmt.setInt(6, summonerStats.getItemId1());
      insertStmt.setInt(7, summonerStats.getItemId2());
      insertStmt.setInt(8, summonerStats.getItemId3());
      insertStmt.setInt(9, summonerStats.getItemId4());
      insertStmt.setInt(10, summonerStats.getItemId5());
      insertStmt.setInt(11, summonerStats.getItemId6());
      insertStmt.setInt(12, summonerStats.getKills());
      insertStmt.setInt(13, summonerStats.getDeaths());
      insertStmt.setInt(14, summonerStats.getAssists());
      insertStmt.setLong(15, summonerStats.getTotalDamageDealt());
      insertStmt.setLong(16, summonerStats.getMagicDamageDealt());
      insertStmt.setLong(17, summonerStats.getPhysicalDamageDealt());
      insertStmt.setLong(18, summonerStats.getTrueDamageDealt());
      insertStmt.setLong(19, summonerStats.getLargestCriticalStrike());
      insertStmt.setLong(20, summonerStats.getTotalDamageDealtToChampions());
      insertStmt.setLong(21, summonerStats.getMagicDamageDealtToChampions());
      insertStmt.setLong(22, summonerStats.getPhysicalDamageDealtToChampions());
      insertStmt.setLong(23, summonerStats.getTrueDamageDealtToChampions());
      insertStmt.setLong(24, summonerStats.getTotalHeal());
      insertStmt.setLong(25, summonerStats.getTotalUnitsHealed());
      insertStmt.setLong(26, summonerStats.getDamageSelfMitigated());
      insertStmt.setLong(27, summonerStats.getDamageDealtToObjectives());
      insertStmt.setLong(28, summonerStats.getDamageDealtToTurrets());
      insertStmt.setLong(29, summonerStats.getVisionScore());
      insertStmt.setLong(30, summonerStats.getTimeCCingOthers());
      insertStmt.setLong(31, summonerStats.getTotalDamageTaken());
      insertStmt.setLong(32, summonerStats.getMagicalDamageTaken());
      insertStmt.setLong(33, summonerStats.getPhysicalDamageTaken());
      insertStmt.setLong(34, summonerStats.getTrueDamageTaken());
      insertStmt.setLong(35, summonerStats.getGoldEarned());
      insertStmt.setLong(36, summonerStats.getGoldSpent());
      insertStmt.setLong(37, summonerStats.getTurretKills());
      insertStmt.setLong(38, summonerStats.getTotalMinionsKilled());
      insertStmt.setLong(39, summonerStats.getNeutralMinionsKilled());
      insertStmt.setLong(40, summonerStats.getNeutralMinionsKilledTeamJungle());
      insertStmt.setLong(41, summonerStats.getNeutralMinionsKilledEnemyJungle());
      insertStmt.setLong(42, summonerStats.getTotalTimeCrowdControlDealt());
      insertStmt.setInt(43, summonerStats.getChampLevel());
      insertStmt.setInt(44, summonerStats.getVisionWardsBoughtInGame());
      insertStmt.setInt(45, summonerStats.getSightWardsBoughtInGame());
      insertStmt.setInt(46, summonerStats.getWardsPlaced());
      insertStmt.setInt(47, summonerStats.getWardsKilled());
      insertStmt.setBoolean(48, summonerStats.isFirstBloodKill());
      insertStmt.setBoolean(49, summonerStats.isFirstBloodAssist());
      insertStmt.setBoolean(50, summonerStats.isFirstTowerKill());
      insertStmt.setBoolean(51, summonerStats.isFirstTowerAssist());
      insertStmt.setBoolean(52, summonerStats.isFirstBloodKill());
      insertStmt.setBoolean(53, summonerStats.isFirstBloodAssist());
      insertStmt.setInt(54, summonerStats.getCombatPlayerScore());
      insertStmt.setInt(55, summonerStats.getObjectivePlayerScore());
      insertStmt.setInt(56, summonerStats.getTotalPlayerScore());
      insertStmt.setInt(57, summonerStats.getTotalScoreRank());
      insertStmt.setString(58, summonerStats.getRole());
      insertStmt.setString(59, summonerStats.getLane());
      insertStmt.setInt(60, summonerStats.getRuneId0());
      insertStmt.setInt(61, summonerStats.getRuneId1());
      insertStmt.setInt(62, summonerStats.getRuneId2());
      insertStmt.setInt(63, summonerStats.getRuneId3());
      insertStmt.setInt(64, summonerStats.getRuneId4());
      insertStmt.setInt(65, summonerStats.getRuneId5());
      insertStmt.setString(66, summonerStats.getHighestAchievedSeasonTier());
      insertStmt.setString(67, summonerStats.getSummoner().getSummonerName());
      insertStmt.executeUpdate();
      
      return summonerStats;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
    }
  }


  /**
   * Delete the SummonerStats instance.
   * This runs a DELETE statement.
   */
  public SummonerStats delete(SummonerStats summonerStats) throws SQLException {
    String deleteSummonerStats = "DELETE FROM SummonerStats WHERE summonerStatsId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteSummonerStats);
      deleteStmt.setString(1, summonerStats.getSummonerStatsId());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }

  /**
   * Get the SummonerStats record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a single SummonerStats instance.
   */
  public SummonerStats getSummonerStatsById(String summonerStatsId) throws SQLException {
    String selectSummonerStats = "SELECT summonerStatsId, championId, " +
            "spell1Id, spell2Id, itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, " +
            "kills, deaths, assists, totalDamageDealt, magicDamageDealt, physicalDamageDealt, " +
            "trueDamageDealt, largestCriticalStrike, totalDamageDealtToChampions, " +
            "magicDamageDealtToChampions, physicalDamageDealtToChampions, trueDamageDealtToChampions, " +
            "totalHeal, totalUnitsHealed, damageSelfMitigated, damageDealtToObjectives, " +
            "damageDealtToTurrets, visionScore, timeCCingOthers, totalDamageTaken, magicalDamageTaken, " +
            "physicalDamageTaken,trueDamageTaken, goldEarned, goldSpent, turretKills, totalMinionsKilled," +
            "neutralMinionsKilled, neutralMinionsKilledTeamJungle, neutralMinionsKilledEnemyJungle, " +
            "totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGamel, " +
            "wardsPlaced, wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill," +
            "firstTowerAssist, firstInHibitorKill, firstInHibitorAssist, combatPlayerScore, " +
            "objectivePlayerScore, totalPlayerScore, totalScoreRank, role, lane, runeId0, runeId1, " +
            "runeId2, runeId3, runeId4, runeId5, highestAchievedSeasonTier, summonerName) " +
            "FROM SummonerStats WHERE summonerStatsId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSummonerStats);
      selectStmt.setString(1, summonerStatsId);
      results = selectStmt.executeQuery();
      SummonerDao summonerDao = SummonerDao.getInstance();
      
      if(results.next()) {
        String resultSummonerStatsId = results.getString("summonerStatsId");
        int championId = results.getInt("championId");
        int spell1Id = results.getInt("spell1Id");
        int spell2Id = results.getInt("spell2Id");
        int itemId0 = results.getInt("itemId0");
        int itemId1 = results.getInt("itemId1");
        int itemId2 = results.getInt("itemId2");
        int itemId3 = results.getInt("itemId3");
        int itemId4 = results.getInt("itemId4");
        int itemId5 = results.getInt("itemId5");
        int itemId6 = results.getInt("itemId6");
        int kills = results.getInt("kills");
        int deaths = results.getInt("deaths");
        int assists = results.getInt("assists");
        int totalDamageDealt = results.getInt("totalDamageDealt");
        int magicDamageDealt = results.getInt("magicDamageDealt");
        int physicalDamageDealt = results.getInt("physicalDamageDealt");
        int trueDamageDealt = results.getInt("trueDamageDealt");
        int largestCriticalStrike = results.getInt("largestCriticalStrike");
        long totalDamageDealtToChampions = results.getLong("totalDamageDealtToChampions");
        long magicDamageDealtToChampions = results.getLong("magicDamageDealtToChampions");
        long physicalDamageDealtToChampions = results.getLong("physicalDamageDealtToChampions");
        long trueDamageDealtToChampions = results.getLong("trueDamageDealtToChampions");
        long totalHeal = results.getLong("totalHeal");
        long totalUnitsHealed = results.getLong("totalUnitsHealed");
        long damageSelfMitigated = results.getLong("damageSelfMitigated");
        long damageDealtToObjectives = results.getLong("damageDealtToObjectives");
        long damageDealtToTurrets = results.getLong("damageDealtToTurrets");
        long visionScore = results.getLong("visionScore");
        long timeCCingOthers = results.getLong("timeCCingOthers");
        long totalDamageTaken = results.getLong("totalDamageTaken");
        long magicDamageTaken = results.getLong("magicDamageTaken");
        long physicalDamageTaken = results.getLong("physicalDamageTaken");
        long trueDamageTaken = results.getLong("trueDamageTaken");
        long goldEarned = results.getLong("goldEarned");
        long goldSpent = results.getLong("goldSpent");
        int turrentKills = results.getInt("turrentKills");
        long totalMinionsKilled = results.getLong("totalMinionsKilled");
        long neutralMinionsKilled = results.getLong("neutralMinionsKilled");
        long neutralMinionsKilledTeamJungle = results.getLong("neutralMinionsKilledTeamJungle");
        long neutralMinionsKilledEnemyJungle = results.getLong("neutralMinionsKilledEnemyJungle");
        long totalTimeCrowdControlDealt = results.getLong("totalTimeCrowdControlDealt");
        int champLevel = results.getInt("champLevel");
        int visionWardsBoughtInGame = results.getInt("visionWardsBoughtInGame");
        int sightWardsBoughtInGame = results.getInt("sightWardsBoughtInGame");
        int wardsPlaced = results.getInt("wardsPlaced");
        int wardsKilled = results.getInt("wardsKilled");
        boolean firstBloodKill = results.getBoolean("firstBloodKill");
        boolean firstBloodAssist = results.getBoolean("firstBloodAssist");
        boolean firstTowerKill = results.getBoolean("firstTowerKill");
        boolean firstTowerKillAssist = results.getBoolean("firstTowerKillAssist");
        boolean firstInHibitor = results.getBoolean("firstInHibitor");
        boolean firstInHibitorAssist = results.getBoolean("firstInHibitorAssist");
        int combatPlayerScore = results.getInt("combatPlayerScore");
        int objectivePlayerScore = results.getInt("objectivePlayerScore");
        int totalPlayerScore = results.getInt("totalPlayerScore");
        int totalScoreRank = results.getInt("totalScoreRank");
        String role = results.getString("role");
        String lane = results.getString("lane");
        int runeId0 = results.getInt("runeId0");
        int runeId1 = results.getInt("runeId1");
        int runeId2 = results.getInt("runeId2");
        int runeId3 = results.getInt("runeId3");
        int runeId4 = results.getInt("runeId4");
        int runeId5 = results.getInt("runeId5");
        String highestAchievedSeasonTier = results.getString("highestAchievedSeasonTier");
        String summonerName = results.getString("summonerName");
        Summoner summoner = summonerDao.getSummonerFromSummonerName(summonerName);
                
        return new SummonerStats(resultSummonerStatsId, championId, spell1Id, spell2Id, itemId0, itemId1, 
                itemId2, itemId3, itemId4, itemId5, itemId6, kills, deaths, assists, totalDamageDealt, 
                magicDamageDealt, physicalDamageDealt, trueDamageDealt, largestCriticalStrike, 
                totalDamageDealtToChampions, magicDamageDealtToChampions, physicalDamageDealtToChampions, 
                trueDamageDealtToChampions, totalHeal, totalUnitsHealed, damageSelfMitigated, 
                damageDealtToObjectives, damageDealtToTurrets, visionScore, timeCCingOthers, 
                totalDamageTaken, magicDamageTaken, physicalDamageTaken,trueDamageTaken, goldEarned, 
                goldSpent, turrentKills, totalMinionsKilled, neutralMinionsKilled, 
                neutralMinionsKilledTeamJungle, neutralMinionsKilledEnemyJungle, totalTimeCrowdControlDealt, 
                champLevel, visionWardsBoughtInGame, sightWardsBoughtInGame, wardsPlaced, wardsKilled, 
                firstBloodKill, firstBloodAssist, firstTowerKill, firstTowerKillAssist, firstInHibitor, 
                firstInHibitorAssist, combatPlayerScore, objectivePlayerScore, totalPlayerScore, 
                totalScoreRank, role, lane, runeId0, runeId1, runeId2, runeId3, runeId4, runeId5,
                highestAchievedSeasonTier, summoner);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }
}

