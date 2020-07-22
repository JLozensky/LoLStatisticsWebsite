package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lol.model.Summoner;
import lol.model.TeamStats;


public class SummonerDao {
  protected ConnectionManager connectionManager;

  private static SummonerDao instance = null;

  protected SummonerDao() {
    connectionManager = new ConnectionManager();
  }

  public static SummonerDao getInstance() {
    if (instance == null) {
      instance = new SummonerDao();
    }
    return instance;
  }

  public Summoner create(Summoner summoner) throws SQLException {
    String insertSummoner = "INSERT IGNORE INTO Summoner(accountId, " +
            "summonerName, currentPlatformId, matchHistoryUri, profileIcon, teamStatsId) " +
            "VALUES(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertSummoner);
      insertStmt.setString(1, summoner.getAccountId());
      insertStmt.setString(2, summoner.getSummonerName());
      insertStmt.setString(3, summoner.getCurrentPlatformId());
      insertStmt.setString(4, summoner.getMatchHistoryUri());
      insertStmt.setInt(5, summoner.getProfileIcon());
      insertStmt.setString(6, summoner.getTeamStats().getTeamStatsId());
      
      insertStmt.executeUpdate();
      
      return summoner;
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


  public Summoner updateSummonerName(Summoner summoner, String newSummonerName) throws SQLException {
    String updateSummoner = "UPDATE Summoner SET summonerName=? WHERE summonerName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(updateSummoner);
      selectStmt.setString(1, newSummonerName);
      selectStmt.setString(2, summoner.getSummonerName());
      selectStmt.executeQuery();

      summoner.setSummonerName(newSummonerName);
      return summoner;

    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
    }
  }
  
  
  public Summoner delete(Summoner summoner) throws SQLException {
    String deleteSummoner = "DELETE FROM Summoner WHERE SummonerName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteSummoner);
      deleteStmt.setString(1, summoner.getSummonerName());
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
  
  
  public Summoner getSummonerFromSummonerName(String SummonerName) throws SQLException {
    String selectSummoner = "SELECT accountId, summonerName, currentPlatformId, matchHistoryUri, " +
            "profileIcon, teamStatsId FROM Summoner WHERE summonerName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSummoner);
      selectStmt.setString(1, SummonerName);
      results = selectStmt.executeQuery();
      TeamStatsDao teamStatsDao = TeamStatsDao.getInstance();
      
      if (results.next()) {
        String accountId = results.getString("accountId");
        String ResultSummonerName = results.getString("summonerName");
        String currentPlatformId = results.getString("currentPlatformId");
        String matchHistoryUri = results.getString("matchHistoryUri");
        int profileIcon = results.getInt("profileIcon");
        String teamStatsId = results.getString("teamStatsId");
        TeamStats teamStats = teamStatsDao.getTeamStatsFromStatsId(teamStatsId);
        
        return new Summoner(accountId, ResultSummonerName, currentPlatformId, matchHistoryUri, 
                profileIcon, teamStats);
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
  
  
  
