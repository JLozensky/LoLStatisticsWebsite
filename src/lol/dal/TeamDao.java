package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import lol.model.Game;
import lol.model.Team;

public class TeamDao {
  protected ConnectionManager connectionManager;
  
  private static TeamDao instance = null;
  
  protected TeamDao() { 
    connectionManager = new ConnectionManager(); 
  }
  
  public static TeamDao getInstance() {
    if (instance == null) {
      instance = new TeamDao();
    }
    return instance;
  }
  
  public Team create(Team team) throws SQLException {
    String insertTeamStats = "INSERT IGNORE INTO Team(teamId, win, firstBlood, firstTower, " +
            "firstInhibitor, firstBaron, firstDragon, firstRiftHerald, towerKills, " +
            "inhibitorKills, baronKills, dragonKills, vilemawKills, riftHeraldKills, " +
            "dominionVictoryScore, banOne, banTwo, banThree, banFour, banFive, gameId) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
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
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
    }
  }
  
  
  // Overridden for the inserter so we don't need to create a new connection for every row
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
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteTeamStats);
      deleteStmt.setString(1, team.getTeamId());
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
  
  public Team getTeamFromTeamId(String teamId) throws SQLException {
    String selectTeamStats = "SELECT teamId,win,firstBlood,firstTower,firstInhibitor,firstBaron," +
            "firstDragon,firstRiftHerald,towerKills,inhibitorKills,baronKills,dragonKills," +
            "vilemawKills,riftHeraldKills,dominionVictoryScore,banOne,banTwo,banThree,banFour,banFive," +
            "gameId) FROM team WHERE teamId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectTeamStats);
      selectStmt.setString(1, teamId);
      results = selectStmt.executeQuery();
      GameDao gameDao = GameDao.getInstance();
      
      if (results.next()) {
        String resultTeamId = results.getString("teamId");
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
        String gameId = results.getString("gameId");
        Game game = gameDao.getGameById(gameId);
        
        return new Team(resultTeamId, win, firstBlood, firstTower,
                firstInhibitor, firstBaron, firstDragon, firstRiftHerald, towerKills, inhibitorKills,
                baronKills, dragonKills, vilemawKills, riftHeraldKills, dominionVictoryScore, 
                banOne, banTwo, banThree, banFour, banFive, game);
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
