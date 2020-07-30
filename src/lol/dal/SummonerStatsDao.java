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
            "firstTowerAssist, firstInhibitorKill, firstInhibitorAssist, combatPlayerScore, " +
            "objectivePlayerScore, totalPlayerScore, totalScoreRank, perk0, perk1, perk2, perk3," +
            "perk4, perk5,perkPrimaryStyle, perkSubStyle,role, lane, " +
            "highestAchievedSeasonTier, gameId, teamId, accountId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?);";
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
      insertStmt.setBoolean(52, summonerStats.isFirstInhibitorKill());
      insertStmt.setBoolean(53, summonerStats.isFirstInhibitorAssist());
      insertStmt.setInt(54, summonerStats.getCombatPlayerScore());
      insertStmt.setInt(55, summonerStats.getObjectivePlayerScore());
      insertStmt.setInt(56, summonerStats.getTotalPlayerScore());
      insertStmt.setInt(57, summonerStats.getTotalScoreRank());
      insertStmt.setInt(58, summonerStats.getPerk0());
      insertStmt.setInt(59, summonerStats.getPerk1());
      insertStmt.setInt(60, summonerStats.getPerk2());
      insertStmt.setInt(61, summonerStats.getPerk3());
      insertStmt.setInt(62, summonerStats.getPerk4());
      insertStmt.setInt(63, summonerStats.getPerk5());
      insertStmt.setLong(64, summonerStats.getPerkPrimaryStyle());
      insertStmt.setLong(65, summonerStats.getPerkSubStyle());
      insertStmt.setString(66, summonerStats.getRole());
      insertStmt.setString(67, summonerStats.getLane());
      insertStmt.setString(68, summonerStats.getHighestAchievedSeasonTier());
      insertStmt.setString(69, summonerStats.getGame().getGameId());
      insertStmt.setString(70, summonerStats.getTeam().getTeamId());
      insertStmt.setString(71, summonerStats.getSummoner().getAccountId());
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
            "firstTowerAssist, firstInhibitorKill, firstInhibitorAssist, combatPlayerScore, " +
            "objectivePlayerScore, totalPlayerScore, totalScoreRank, perk0, perk1, " +
            "perk2, perk3, perk4, perk5, perkSubStyle, perkPrimaryStyle, role, lane, highestAchievedSeasonTier, " +
            "gameId, teamId, accountId) FROM SummonerStats WHERE summonerStatsId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSummonerStats);
      selectStmt.setString(1, summonerStatsId);
      results = selectStmt.executeQuery();
      GameDao gameDao = GameDao.getInstance();
      TeamDao teamDao = TeamDao.getInstance();
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
        long magicalDamageTaken = results.getLong("magicalDamageTaken");
        long physicalDamageTaken = results.getLong("physicalDamageTaken");
        long trueDamageTaken = results.getLong("trueDamageTaken");
        long goldEarned = results.getLong("goldEarned");
        long goldSpent = results.getLong("goldSpent");
        int turretKills = results.getInt("turretKills");
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
        boolean firstTowerAssist = results.getBoolean("firstTowerAssist");
        boolean firstInhibitorKill = results.getBoolean("firstInhibitorKill");
        boolean firstInhibitorAssist = results.getBoolean("firstInhibitorAssist");
        int combatPlayerScore = results.getInt("combatPlayerScore");
        int objectivePlayerScore = results.getInt("objectivePlayerScore");
        int totalPlayerScore = results.getInt("totalPlayerScore");
        int totalScoreRank = results.getInt("totalScoreRank");
        int perk0 = results.getInt("perk0");
        int perk1 = results.getInt("perk1");
        int perk2 = results.getInt("perk2");
        int perk3 = results.getInt("perk3");
        int perk4 = results.getInt("perk4");
        int perk5 = results.getInt("perk5");
        long perkPrimaryStyle = results.getLong("perkPrimaryStyle");
        long perkSubStyle =results.getLong("perkSubStyle");
        String role = results.getString("role");
        String lane = results.getString("lane");
        String highestAchievedSeasonTier = results.getString("highestAchievedSeasonTier");
        String gameId = results.getString("gameId");
        String teamId =results.getString("teamId");
        String summonerName = results.getString("summonerName");
        Game game = gameDao.getGameById(gameId);
        Team team = teamDao.getTeamFromTeamId(teamId);
        Summoner summoner = summonerDao.getSummonerFromSummonerName(summonerName);
                
        return new SummonerStats(resultSummonerStatsId, championId, spell1Id, spell2Id,
                itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, kills, deaths, assists,
                totalDamageDealt, magicDamageDealt, physicalDamageDealt, trueDamageDealt,
                largestCriticalStrike, totalDamageDealtToChampions, magicDamageDealtToChampions,
                physicalDamageDealtToChampions, trueDamageDealtToChampions, totalHeal, totalUnitsHealed,
                damageSelfMitigated, damageDealtToObjectives, damageDealtToTurrets, visionScore,
                timeCCingOthers, totalDamageTaken, magicalDamageTaken, physicalDamageTaken,
                trueDamageTaken, goldEarned, goldSpent, turretKills, totalMinionsKilled,
                neutralMinionsKilled, neutralMinionsKilledTeamJungle,  neutralMinionsKilledEnemyJungle,
                totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGame,
                wardsPlaced, wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill,
                firstTowerAssist, firstInhibitorKill, firstInhibitorAssist, combatPlayerScore,
                objectivePlayerScore, totalPlayerScore, totalScoreRank, perk0, perk1, perk2, perk3,
                perk4, perk5, perkPrimaryStyle, perkSubStyle, role, lane, highestAchievedSeasonTier,
                game, team, summoner);
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

