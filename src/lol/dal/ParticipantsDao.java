package lol.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lol.model.*;

public class ParticipantsDao {

	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static ParticipantsDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 * Inaccessible to outside classes only the singleton instance can be accessed.
	 */
	private ParticipantsDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static ParticipantsDao getInstance() {
		if(instance == null) {
			instance = new ParticipantsDao();
		}
		return instance;
	}
	
	/**
	 * Creates a new champion record in Champions.
	 * Runs an INSERT statement.
	 * @param champion Champions object to create in the database
	 * @return the created champion
	 * @throws SQLException
	 */
	public ParticipantIdentity create(ParticipantIdentity participant) throws SQLException {

		String insertParticipant = "INSERT INTO ParticipantIdentity(accountId,player,summonerName,summonerId,"
				+ "currentPlatformId,currentAccountId,matchHistoryUri) VALUES(?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertParticipant);
			insertStmt.setInt(1, participant.getAccountId());
			insertStmt.setString(2,  participant.getPlayer());
			insertStmt.setString(3,  participant.getSummonerName());
			insertStmt.setString(4,  participant.getSummonerId());
			insertStmt.setInt(5, participant.getCurrentPlatformId());
			insertStmt.setInt(6, participant.getCurrentAccountId());
			insertStmt.setString(7, participant.getMatchHistoryUri());

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

	public ParticipantIdentity delete(ParticipantIdentity participant) throws SQLException {
		String deleteChampion = "DELETE FROM ParticipantIdentity WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteChampion);
			deleteStmt.setInt(1, participant.getAccountId());
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
	
	public ParticipantIdentity getParticipantFromId(int id) throws SQLException {
		String selectChampion =
				"SELECT accountId,player,summonerName,summonerId,"
				+ "currentPlatformId,currentAccountId,matchHistoryUri "
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
				int resultAccountId = results.getInt("accountId");
				String player = results.getString("player");
				String summonerName = results.getString("summonerName");
				String summonerId = results.getString("summonerId");
				int currentPlatformId = results.getInt("currentPlatformId");
				int currentAccountId = results.getInt("currentAccountId");
				String matchHistoryUri = results.getString("matchHistoryUri");
				
				ParticipantIdentity participant = new ParticipantIdentity(resultAccountId, player,
						summonerName, summonerId, currentPlatformId, currentAccountId, matchHistoryUri);
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
			selectStmt.setInt(2, participant.getAccountId());
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
				+ "currentPlatformId,currentAccountId,matchHistoryUri "
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
				int resultAccountId = results.getInt("accountId");
				String player = results.getString("player");
				String summonerName = results.getString("summonerName");
				String summonerId = results.getString("summonerId");
				int currentPlatformId = results.getInt("currentPlatformId");
				int currentAccountId = results.getInt("currentAccountId");
				String matchHistoryUri = results.getString("matchHistoryUri");
				
				ParticipantIdentity participant = new ParticipantIdentity(resultAccountId, player,
						summonerName, summonerId, currentPlatformId, currentAccountId, matchHistoryUri);
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
