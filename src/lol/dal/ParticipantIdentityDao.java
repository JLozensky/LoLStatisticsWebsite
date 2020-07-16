package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lol.model.ParticipantIdentity;


public class ParticipantIdentityDao {
  protected ConnectionManager connectionManager;

  private static ParticipantIdentityDao instance = null;

  protected ParticipantIdentityDao() {
    connectionManager = new ConnectionManager();
  }

  public static ParticipantIdentityDao getInstance() {
    if (instance == null) {
      instance = new ParticipantIdentityDao();
    }
    return instance;
  }

  public ParticipantIdentity create(ParticipantIdentity participantIdentity) 
          throws SQLException {
    String insertParticipantIdentity = "INSERT INTO ParticipantIdentity(accountId, summonerName, " +
            "summonerId, currentPlatformId, matchHistoryUri, profileIcon) VAULES(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertParticipantIdentity);
      
      insertStmt.setString(1, participantIdentity.getAccountId());
      insertStmt.setString(2, participantIdentity.getSummonerName());
      insertStmt.setString(3, participantIdentity.getSummonerId());
      insertStmt.setString(4, participantIdentity.getCurrentPlatformId());
      insertStmt.setString(5, participantIdentity.getMatchHistoryUri());
      insertStmt.setLong(6, participantIdentity.getProfileIcon());
      
      insertStmt.executeUpdate();
      
      return participantIdentity;
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

  public ParticipantIdentity delete(ParticipantIdentity participantIdentity) throws SQLException {
    String deleteParticipantIdentity = "DELETE FROM participantIdentity WHERE SummonerName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteParticipantIdentity);
      deleteStmt.setString(1, participantIdentity.getSummonerName());
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

  public ParticipantIdentity getParticipantIdentityFromSummonerName(String SummonerName) 
          throws SQLException {
    String selectParticipantIdentity = "SELECT SummonerName FROM ParticipantIdentity WHERE " +
            "SummonerName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectParticipantIdentity);
      selectStmt.setString(1, SummonerName);
      results = selectStmt.executeQuery();
      
      if (results.next()) {
        String accountId = results.getString("accountId");
        String resultSummonerName = results.getString("summonerName");
        String summonerId = results.getString("summonerId");
        String currentPlatformId = results.getString("currentPlatformId");
        String matchHistoryUri =results.getString("matchHistoryUri");
        long profileIcon = results.getLong("profileIcon");
        return new ParticipantIdentity(accountId, resultSummonerName, summonerId, currentPlatformId,
                matchHistoryUri, profileIcon);
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
