package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import lol.model.TeamStats;

public class TeamStatsDao {
  protected ConnectionManager connectionManager;
  
  private static TeamStatsDao instance = null;
  
  protected TeamStatsDao() { 
    connectionManager = new ConnectionManager(); 
  }
  
  public static TeamStatsDao getInstance() {
    if (instance == null) {
      instance = new TeamStatsDao();
    }
    return instance;
  }
  
  public TeamStats create(TeamStats teamStats) throws SQLException {
    String insertTeamStats = "INSERT INTO TeamStats(statsId, win, firstBlood, firstTower, " +
            "firstInhibitor, firstBaron, firstDragon, firstRiftHerald, towerKills, " +
            "inhibitorKills, baronKills, dragonKills, vilemawKills, riftHeraldKills, " +
            "dominionVictoryScore, banOne, banTwo, banThree, banFour, banFive) VALUES(?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertTeamStats);
      
      insertStmt.setString(1, teamStats.getTeamStatsId());
      insertStmt.setString(2, teamStats.getWin());
      insertStmt.setBoolean(3, teamStats.isFirstBlood());
      insertStmt.setBoolean(4, teamStats.isFirstTower());
      insertStmt.setBoolean(5, teamStats.isFirstInhibitor());
      insertStmt.setBoolean(6, teamStats.isFirstBaron());
      insertStmt.setBoolean(7, teamStats.isFirstDragon());
      insertStmt.setBoolean(8, teamStats.isFirstRiftHerald());
      insertStmt.setInt(9, teamStats.getTowerKills());
      insertStmt.setInt(10, teamStats.getInhibitorKills());
      insertStmt.setInt(11, teamStats.getBaronKills());
      insertStmt.setInt(12, teamStats.getDragonKills());
      insertStmt.setInt(13, teamStats.getVilemawKills());
      insertStmt.setInt(14, teamStats.getRiftHeraldKills());
      insertStmt.setInt(15, teamStats.getDominionVictoryScore());
      insertStmt.setInt(16, teamStats.getBanOne());
      insertStmt.setInt(17, teamStats.getBanTwo());
      insertStmt.setInt(18, teamStats.getBanThree());
      insertStmt.setInt(19, teamStats.getBanFour());
      insertStmt.setInt(20, teamStats.getBanFive());

      insertStmt.executeUpdate();
      
      return teamStats;
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
  
<<<<<<< Updated upstream:src/lol/dal/TeamStatsDao.java
  public TeamStats delete(TeamStats teamStats) throws SQLException {
    String deleteTeamStats = "DELETE FROM teamStats WHERE statsId=?;";
=======
  
  
  public Team create(Team team, Connection connection) throws SQLException {
	    String insertTeamStats = "INSERT IGNORE INTO Team(teamId, win, firstBlood, firstTower, " +
	            "firstInhibitor, firstBaron, firstDragon, firstRiftHerald, towerKills, " +
	            "inhibitorKills, baronKills, dragonKills, vilemawKills, riftHeraldKills, " +
	            "dominionVictoryScore, banOne, banTwo, banThree, banFour, banFive, gameId) " +
	            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	    PreparedStatement insertStmt = null;
	    try {
	      insertStmt = connection.prepareStatement(insertTeamStats);
	      
	      insertStmt.setString(1, team.getTeamId());
	      insertStmt.setString(2, team.getWin());
	      insertStmt.setBoolean(3, team.isFirstBlood());
	      insertStmt.setBoolean(4, team.isFirstTower());
	      insertStmt.setBoolean(5, team.isFirstInhibitor());
	      insertStmt.setBoolean(6, team.isFirstBaron());
	      insertStmt.setBoolean(7, team.isFirstDragon());
	      insertStmt.setBoolean(8, team.isFirstRiftHerald());
	      insertStmt.setInt(9, team.getTowerKills());
	      insertStmt.setInt(10, team.getInhibitorKills());
	      insertStmt.setInt(11, team.getBaronKills());
	      insertStmt.setInt(12, team.getDragonKills());
	      insertStmt.setInt(13, team.getVilemawKills());
	      insertStmt.setInt(14, team.getRiftHeraldKills());
	      insertStmt.setInt(15, team.getDominionVictoryScore());
	      insertStmt.setInt(16, team.getBanOne());
	      insertStmt.setInt(17, team.getBanTwo());
	      insertStmt.setInt(18, team.getBanThree());
	      insertStmt.setInt(19, team.getBanFour());
	      insertStmt.setInt(20, team.getBanFive());
	      insertStmt.setString(21, team.getGame().getGameId());
	      insertStmt.executeUpdate();
	      
	      return team;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      throw e;
	    } finally {
	      if (insertStmt != null) {
	        insertStmt.close();
	      }
	    }
	  }
  
  
  
  
  
  
  
  
  public Team delete(Team team) throws SQLException {
    String deleteTeamStats = "DELETE FROM Team WHERE teamId=?;";
>>>>>>> Stashed changes:src/lol/dal/TeamDao.java
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteTeamStats);
      deleteStmt.setString(1, teamStats.getTeamStatsId());
      deleteStmt.executeUpdate();
      
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
  
  public TeamStats getTeamStatsFromStatsId(String teamStatsId) throws SQLException {
    String selectTeamStats = "SELECT statsId FROM teamStats WHERE statsId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectTeamStats);
      selectStmt.setString(1, teamStatsId);
      results = selectStmt.executeQuery();
      
      if (results.next()) {
        String resultTeamStatsId = results.getString("statsId");
        String win = results.getString("win");
        boolean firstBlood = results.getBoolean("firstBlood");
        boolean firstTower = results.getBoolean("firstTower");
        boolean firstInhibitor = results.getBoolean("firstInhibitor");
        boolean firstBaron = results.getBoolean("firstBaron");
        boolean firstDragon = results.getBoolean("firstDragon");
        boolean firstRiftHerald = results.getBoolean("firstRiftHerald");
        int towerKills = results.getInt("towerKills");
        int inhibitorKills = results.getInt("inhibitorKills");
        int baronKills = results.getInt("baronKills");
        int dragonKills = results.getInt("dragonKills");
        int vilemawKills = results.getInt("vilemawKills");
        int riftHeraldKills = results.getInt("riftHeraldKills");
        int dominionVictoryScore = results.getInt("dominionVictoryScore");
        int banOne = results.getInt("banOne");
        int banTwo = results.getInt("banTwo");
        int banThree = results.getInt("banThree");
        int banFour = results.getInt("banFour");
        int banFive = results.getInt("banFive");
        return new TeamStats(resultTeamStatsId, win, firstBlood, firstTower,
                firstInhibitor, firstBaron, firstDragon, firstRiftHerald, towerKills, inhibitorKills,
                baronKills, dragonKills, vilemawKills, riftHeraldKills, dominionVictoryScore, 
                banOne, banTwo, banThree, banFour, banFive);
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
