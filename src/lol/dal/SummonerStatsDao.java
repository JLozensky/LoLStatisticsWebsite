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
    String insertSummonerStats = "INSERT INTO SummonerStats(summonerStatsId, championId, " +
            "spell1Id, spell2Id, itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, " +
            "kills, deaths, assists, totalDamageDealt, magicDamageDealt, physicalDamageDealt, " +
            "trueDamageDealt, largestCriticalStrike, totalDamageDealtToChampions, " +
            "magicDamageDealtToChampions, physicalDamageDealtToChampions, trueDamageDealtToChampions, " +
            "totalHeal, totalUnitHealed, damageSelfMitigated, damageDealtToObjectives, " +
            "damageDealtToTurrets, visionScore, timeCCingOthers, totalDamageTaken, magicDamageTaken, " +
            "physicalDamageTaken,trueDamageTaken, goldEarned, goldSpent, turrentKills, totalMinionsKilled," +
            "neutralMinionsKilled, neutralMinionsKilledTeamJungle, neutralMinionsKilledEnemyJungle, " +
            "totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGamel, " +
            "wardsPlaced, wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill," +
            "firstTowerKillAssist, firstInHibitor, firstInHibitorAssist, combatPlayerScore, " +
            "objectivePlayerScore, totalPlayerScore, totalScoreRank, Role role, Lane lane, " +
            "perk0, perk0Var1, perk0Var2, perk0Var3, perk1, perk1Var1, perk1Var2, perk1Var3, " +
            "perk2, perk2Var1, perk2Var2, perk2Var3, perk3, perk3Var1, perk3Var2, perk3Var3, " +
            "perk4, perk4Var1, perk4Var2, perk4Var3, perk5, perk5Var1, perk50Var2, perk5Var3, " +
            "perkPrimaryStyle, perkSubStyle, accountId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertSummonerStats);

      insertStmt.setInt(1, summonerStats.getSummonerstatsId());
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
      insertStmt.setInt(15, summonerStats.getTotaldamagedealt());
      insertStmt.setInt(16, summonerStats.getMagicdamagedealt());
      insertStmt.setInt(17, summonerStats.getPhysicaldamagedealt());
      insertStmt.setInt(18, summonerStats.getTruedamagedealt());
      insertStmt.setInt(19, summonerStats.getLargestcriticalstrike());
      insertStmt.setInt(20, summonerStats.getTotaldamagedealttochampions());
      insertStmt.setInt(21, summonerStats.getMagicdamagedealttochampions());
      insertStmt.setInt(22, summonerStats.getPhysicaldamagedealttochampions());
      insertStmt.setInt(23, summonerStats.getTruedamagedealttochampions());
      insertStmt.setInt(24, summonerStats.getTotalheal());
      insertStmt.setInt(25, summonerStats.getTotalunithealed());
      insertStmt.setInt(26, summonerStats.getDamageselfmitigated());
      insertStmt.setInt(27, summonerStats.getDamagedealttoobjectives());
      insertStmt.setInt(28, summonerStats.getDamagedealttoturrets());
      insertStmt.setInt(29, summonerStats.getVisionscore());
      insertStmt.setInt(30, summonerStats.getTimeccingothers());
      insertStmt.setInt(31, summonerStats.getTotaldamagetaken());
      insertStmt.setInt(32, summonerStats.getMagicdamagetaken());
      insertStmt.setInt(33, summonerStats.getPhysicaldamagetaken());
      insertStmt.setInt(34, summonerStats.getTruedamagetaken());
      insertStmt.setInt(35, summonerStats.getGoldearned());
      insertStmt.setInt(36, summonerStats.getGoldspent());
      insertStmt.setInt(37, summonerStats.getTurrentkills());
      insertStmt.setInt(38, summonerStats.getTotalminionskilled());
      insertStmt.setInt(39, summonerStats.getNeutralminionskilled());
      insertStmt.setInt(40, summonerStats.getNeutralminionskilledteamjungle());
      insertStmt.setInt(41, summonerStats.getNeutralminionskilledenemyjungle());
      insertStmt.setInt(42, summonerStats.getTotaltimecrowdcontroldealt());
      insertStmt.setInt(43, summonerStats.getChamplevel());
      insertStmt.setInt(44, summonerStats.getVisionwardsboughtingame());
      insertStmt.setInt(45, summonerStats.getSightwardsboughtingamel());
      insertStmt.setInt(46, summonerStats.getWardsplaced());
      insertStmt.setInt(47, summonerStats.getWardskilled());
      insertStmt.setBoolean(48, summonerStats.getFirstbloodkill());
      insertStmt.setBoolean(49, summonerStats.getFirstbloodassist());
      insertStmt.setBoolean(50, summonerStats.getFirsttowerkill());
      insertStmt.setBoolean(51, summonerStats.getFirsttowerkillassist());
      insertStmt.setBoolean(52, summonerStats.getFirstinhibitor());
      insertStmt.setBoolean(53, summonerStats.getFirstinhibitorassist());
      insertStmt.setInt(54, summonerStats.getCombatplayerscore());
      insertStmt.setInt(55, summonerStats.getObjectiveplayerscore());
      insertStmt.setInt(56, summonerStats.getTotalplayerscore());
      insertStmt.setInt(57, summonerStats.getTotalscorerank());
      insertStmt.setString(58, summonerStats.getRole().toString());
      insertStmt.setString(59, summonerStats.getLane().toString());
      insertStmt.setInt(60, summonerStats.getPerk0());
      insertStmt.setInt(61, summonerStats.getPerk0Var1());
      insertStmt.setInt(62, summonerStats.getPerk0Var2());
      insertStmt.setInt(63, summonerStats.getPerk0Var3());
      insertStmt.setInt(64, summonerStats.getPerk1());
      insertStmt.setInt(65, summonerStats.getPerk1Var1());
      insertStmt.setInt(66, summonerStats.getPerk1Var2());
      insertStmt.setInt(67, summonerStats.getPerk1Var3());
      insertStmt.setInt(68, summonerStats.getPerk2());
      insertStmt.setInt(69, summonerStats.getPerk2Var1());
      insertStmt.setInt(70, summonerStats.getPerk2Var2());
      insertStmt.setInt(71, summonerStats.getPerk2Var3());
      insertStmt.setInt(72, summonerStats.getPerk3());
      insertStmt.setInt(73, summonerStats.getPerk3Var1());
      insertStmt.setInt(74, summonerStats.getPerk3Var2());
      insertStmt.setInt(75, summonerStats.getPerk3Var3());
      insertStmt.setInt(76, summonerStats.getPerk4());
      insertStmt.setInt(77, summonerStats.getPerk4Var1());
      insertStmt.setInt(78, summonerStats.getPerk4Var2());
      insertStmt.setInt(79, summonerStats.getPerk4Var3());
      insertStmt.setInt(80, summonerStats.getPerk5());
      insertStmt.setInt(81, summonerStats.getPerk5Var1());
      insertStmt.setInt(82, summonerStats.getPerk50Var2());
      insertStmt.setInt(83, summonerStats.getPerk5Var3());
      insertStmt.setInt(84, summonerStats.getPerkprimarystyle());
      insertStmt.setInt(85, summonerStats.getPerksubstyle());
      insertStmt.setInt(86, summonerStats.getAccountId());
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
      deleteStmt.setInt(1, summonerStats.getSummonerstatsId());
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
  public SummonerStats getSummonerStatsFromID(int id) throws SQLException {
    String selectSummonerStats =
            "SELECT SummonerStats.summonerStatsId as summonerStatsId,championId, " +
                    "spell1Id, spell2Id, itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, " +
                    "kills, deaths, assists, totalDamageDealt, magicDamageDealt, physicalDamageDealt, " +
                    "trueDamageDealt, largestCriticalStrike, totalDamageDealtToChampions, " +
                    "magicDamageDealtToChampions, physicalDamageDealtToChampions, trueDamageDealtToChampions, " +
                    "totalHeal, totalUnitHealed, damageSelfMitigated, damageDealtToObjectives, " +
                    "damageDealtToTurrets, visionScore, timeCCingOthers, totalDamageTaken, magicDamageTaken, " +
                    "physicalDamageTaken,trueDamageTaken, goldEarned, goldSpent, turrentKills, totalMinionsKilled," +
                    "neutralMinionsKilled, neutralMinionsKilledTeamJungle, neutralMinionsKilledEnemyJungle, " +
                    "totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGamel, " +
                    "wardsPlaced, wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill," +
                    "firstTowerKillAssist, firstInHibitor, firstInHibitorAssist, combatPlayerScore, " +
                    "objectivePlayerScore, totalPlayerScore, totalScoreRank, Role role, Lane lane, " +
                    "perk0, perk0Var1, perk0Var2, perk0Var3, perk1, perk1Var1, perk1Var2, perk1Var3, " +
                    "perk2, perk2Var1, perk2Var2, perk2Var3, perk3, perk3Var1, perk3Var2, perk3Var3, " +
                    "perk4, perk4Var1, perk4Var2, perk4Var3, perk5, perk5Var1, perk50Var2, perk5Var3, " +
                    "perkPrimaryStyle, perkSubStyle, accountId"
                    + "FROM SummonerStats "
                    + "WHERE SummonerStats.summonerStatsId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSummonerStats);
      selectStmt.setInt(1, id);
      results = selectStmt.executeQuery();
      if(results.next()) {

        int summonerStatsId = results.getInt("summonerStatsId");
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
        int totalDamageDealtToChampions = results.getInt("totalDamageDealtToChampions");
        int magicDamageDealtToChampions = results.getInt("magicDamageDealtToChampions");
        int physicalDamageDealtToChampions = results.getInt("physicalDamageDealtToChampions");
        int trueDamageDealtToChampions = results.getInt("trueDamageDealtToChampions");
        int totalHeal = results.getInt("totalHeal");
        int totalUnitHealed = results.getInt("totalUnitHealed");
        int damageSelfMitigated = results.getInt("damageSelfMitigated");
        int damageDealtToObjectives = results.getInt("damageDealtToObjectives");
        int damageDealtToTurrets = results.getInt("damageDealtToTurrets");
        int visionScore = results.getInt("visionScore");
        int timeCCingOthers = results.getInt("timeCCingOthers");
        int totalDamageTaken = results.getInt("totalDamageTaken");
        int magicDamageTaken = results.getInt("magicDamageTaken");
        int physicalDamageTaken = results.getInt("physicalDamageTaken");
        int trueDamageTaken = results.getInt("trueDamageTaken");
        int goldEarned = results.getInt("goldEarned");
        int goldSpent = results.getInt("goldSpent");
        int turrentKills = results.getInt("turrentKills");
        int totalMinionsKilled = results.getInt("totalMinionsKilled");
        int neutralMinionsKilled = results.getInt("neutralMinionsKilled");
        int neutralMinionsKilledTeamJungle = results.getInt("neutralMinionsKilledTeamJungle");
        int neutralMinionsKilledEnemyJungle = results.getInt("neutralMinionsKilledEnemyJungle");
        int totalTimeCrowdControlDealt = results.getInt("totalTimeCrowdControlDealt");
        int champLevel = results.getInt("champLevel");
        int visionWardsBoughtInGame = results.getInt("visionWardsBoughtInGame");
        int sightWardsBoughtInGamel = results.getInt("sightWardsBoughtInGamel");
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
        SummonerStats.Role role = SummonerStats.Role.valueOf(
                results.getString("role"));
        SummonerStats.Lane lane = SummonerStats.Lane.valueOf(
                results.getString("lane"));
        int perk0 = results.getInt("perk0");
        int perk0Var1 = results.getInt("perk0Var1");
        int perk0Var2 = results.getInt("perk0Var2");
        int perk0Var3 = results.getInt("perk0Var3");
        int perk1 = results.getInt("perk1");
        int perk1Var1 = results.getInt("perk1Var1");
        int perk1Var2 = results.getInt("perk1Var2");
        int perk1Var3 = results.getInt("perk1Var3");
        int perk2 = results.getInt("perk2");
        int perk2Var1 = results.getInt("perk2Var1");
        int perk2Var2 = results.getInt("perk2Var2");
        int perk2Var3 = results.getInt("perk2Var3");
        int perk3 = results.getInt("perk3");
        int perk3Var1 = results.getInt("perk3Var1");
        int perk3Var2 = results.getInt("perk3Var2");
        int perk3Var3 = results.getInt("perk3Var3");
        int perk4 = results.getInt("perk4");
        int perk4Var1 = results.getInt("perk4Var1");
        int perk4Var2 = results.getInt("perk4Var2");
        int perk4Var3 = results.getInt("perk4Var3");
        int perk5 = results.getInt("perk5");
        int perk5Var1 = results.getInt("perk5Var1");
        int perk50Var2 = results.getInt("perk50Var2");
        int perk5Var3 = results.getInt("perk5Var3");
        int perkPrimaryStyle = results.getInt("perkPrimaryStyle");
        int perkSubStyle = results.getInt("perkSubStyle");
        int accountId = results.getInt("accountId");

        SummonerStats summonerStats = new SummonerStats(summonerStatsId, championId,
                spell1Id, spell2Id, itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6,
                kills, deaths, assists, totalDamageDealt, magicDamageDealt, physicalDamageDealt,
                trueDamageDealt, largestCriticalStrike, totalDamageDealtToChampions,
                magicDamageDealtToChampions, physicalDamageDealtToChampions, trueDamageDealtToChampions,
                totalHeal, totalUnitHealed, damageSelfMitigated, damageDealtToObjectives,
                damageDealtToTurrets, visionScore, timeCCingOthers, totalDamageTaken, magicDamageTaken,
                physicalDamageTaken,trueDamageTaken, goldEarned, goldSpent, turrentKills, totalMinionsKilled,
                neutralMinionsKilled, neutralMinionsKilledTeamJungle, neutralMinionsKilledEnemyJungle,
                totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGamel,
                wardsPlaced, wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill,
                firstTowerKillAssist, firstInHibitor, firstInHibitorAssist, combatPlayerScore,
                objectivePlayerScore, totalPlayerScore, totalScoreRank, role, lane,
                perk0, perk0Var1, perk0Var2, perk0Var3, perk1, perk1Var1, perk1Var2, perk1Var3,
                perk2, perk2Var1, perk2Var2, perk2Var3, perk3, perk3Var1, perk3Var2, perk3Var3,
                perk4, perk4Var1, perk4Var2, perk4Var3, perk5, perk5Var1, perk50Var2, perk5Var3,
                perkPrimaryStyle, perkSubStyle, accountId);

        return summonerStats;
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

