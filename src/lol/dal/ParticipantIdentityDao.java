package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
  getPlayerFromAccountId
  updateLastName

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
    String selectParticipantIdentity = "SELECT accountId,lastName,firstName,player,summonerName,summonerId,"
			+ "currentPlatformId,currentAccountId,matchHistoryUri,profileIcon "
			+ "FROM ParticipantIdentity "
			+ "WHERE summonerName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectParticipantIdentity);
      selectStmt.setString(1, SummonerName);
      results = selectStmt.executeQuery();
      
      if (results.next()) {
			String resultAccountId = results.getString("accountId");
			String player = results.getString("player");
			String lastName = results.getString("lastName");
			String firstName = results.getString("firstName");
			String summonerName = results.getString("summonerName");
			String summonerId = results.getString("summonerId");
			String currentPlatformId = results.getString("currentPlatformId");
			String currentAccountId = results.getString("currentAccountId");
			String matchHistoryUri = results.getString("matchHistoryUri");
			Long profileIcon = results.getLong("profileIcon");
			
			ParticipantIdentity participant = new ParticipantIdentity(resultAccountId, 
					firstName, lastName, player,
					summonerName, summonerId, currentPlatformId, currentAccountId, matchHistoryUri, profileIcon);
			return participant;
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  public ParticipantIdentity create(ParticipantIdentity participant) throws SQLException {

		String insertParticipant = "INSERT INTO ParticipantIdentity(accountId,firstName,lastName,player,summonerName,summonerId,"
				+ "currentPlatformId,currentAccountId,matchHistoryUri) VALUES(?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertParticipant);
			insertStmt.setString(1, participant.getAccountId());
			insertStmt.setString(2,  participant.getFirstName());
			insertStmt.setString(3,  participant.getLastName());
			insertStmt.setString(4,  participant.getPlayer());
			insertStmt.setString(5,  participant.getSummonerName());
			insertStmt.setString(6,  participant.getSummonerId());
			insertStmt.setString(7, participant.getCurrentPlatformId());
			insertStmt.setString(8, participant.getCurrentAccountId());
			insertStmt.setString(9, participant.getMatchHistoryUri());

			insertStmt.executeUpdate();
			return participant;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}

	
	
	public ParticipantIdentity getParticipantFromId(int id) throws SQLException {
		String selectChampion =
				"SELECT accountId,lastName,firstName,player,summonerName,summonerId,"
				+ "currentPlatformId,currentAccountId,matchHistoryUri,profileIcon "
				+ "FROM ParticipantIdentity "
				+ "WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			selectStmt.setInt(1, id);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultAccountId = results.getString("accountId");
				String player = results.getString("player");
				String lastName = results.getString("lastName");
				String firstName = results.getString("firstName");
				String summonerName = results.getString("summonerName");
				String summonerId = results.getString("summonerId");
				String currentPlatformId = results.getString("currentPlatformId");
				String currentAccountId = results.getString("currentAccountId");
				String matchHistoryUri = results.getString("matchHistoryUri");
				Long profileIcon = results.getLong("profileIcon");
				
				ParticipantIdentity participant = new ParticipantIdentity(resultAccountId, 
						firstName, lastName, player,
						summonerName, summonerId, currentPlatformId, currentAccountId, matchHistoryUri, profileIcon);
				return participant;
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
	
	public ParticipantIdentity updateParticipantSummonerName(ParticipantIdentity participant, 
			String newSummonerName) throws SQLException {
		String updateParticipant =
				"UPDATE ParticipantIdentity SET summonerName=? WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(updateParticipant);
			selectStmt.setString(1,  newSummonerName);
			selectStmt.setString(2, participant.getAccountId());
			selectStmt.executeQuery();
			
			participant.setSummonerName(newSummonerName);
			return participant;
			
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
		}
	}
	
	
	public List<ParticipantIdentity> getParticipantsBySummonerNameStartingWith(String startPrefix)
			throws SQLException {
		List<ParticipantIdentity> participants = new ArrayList<ParticipantIdentity>();
		String selectParticipants =
				"SELECT accountId,player,summonerName,summonerId,"
				+ "currentPlatformId,currentAccountId,matchHistoryUri,profileIcon "
				+ "FROM ParticipantIdentity "
				+ "WHERE summonerName LIKE'" + startPrefix + "%';";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectParticipants);
			selectStmt.setString(1, startPrefix);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String resultAccountId = results.getString("accountId");
				String player = results.getString("player");
				String lastName = results.getString("lastName");
				String firstName = results.getString("firstName");
				String summonerName = results.getString("summonerName");
				String summonerId = results.getString("summonerId");
				String currentPlatformId = results.getString("currentPlatformId");
				String currentAccountId = results.getString("currentAccountId");
				String matchHistoryUri = results.getString("matchHistoryUri");
				Long profileIcon = results.getLong("profileIcon");
				
				ParticipantIdentity participant = new ParticipantIdentity(resultAccountId,
						firstName, lastName, player, summonerName, summonerId, currentPlatformId,
						currentAccountId, matchHistoryUri, profileIcon);
			    participants.add(participant);
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
		return participants;
	}
  
  
  
  
  
}
