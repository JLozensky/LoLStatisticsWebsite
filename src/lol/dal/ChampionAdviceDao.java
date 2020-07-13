package lol.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lol.model.*;

public class ChampionAdviceDao {

	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static ChampionAdviceDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 * Inaccessible to outside classes only the singleton instance can be accessed.
	 */
	private ChampionAdviceDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static ChampionAdviceDao getInstance() {
		if(instance == null) {
			instance = new ChampionAdviceDao();
		}
		return instance;
	}
	
	/**
	 * Creates a new champion advice record in ChampionAdvice.
	 * Runs an INSERT statement.
	 * @param championAdvice ChampionAdvice object to create in the database
	 * @return the created champion
	 * @throws SQLException
	 */
	public ChampionAdvice create(ChampionAdvice championAdvice) throws SQLException {

		String insertChampions = "INSERT INTO "
				+ "ChampionAdvice(championId,allyAdvice,enemyAdvice) VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;

		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertChampions, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setInt(1, championAdvice.getChampionId());
			insertStmt.setString(2, championAdvice.getAllyAdivce());
			insertStmt.setString(3, championAdvice.getEnemyAdvice());			
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int adviceId = -1;
			if(resultKey.next()) {
				adviceId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			championAdvice.setAdvice(adviceId);
			return championAdvice;
			
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
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}

	/**
	 * Delete the ChampionAdvice instance from the database. This runs a DELETE statement.
	 * @param championAdvice Champion to delete
	 * @return null
	 * @throws SQLException 
	 */
	public ChampionAdvice delete(ChampionAdvice championAdvice) throws SQLException {
		String deleteChampion = "DELETE FROM ChampionAdvice WHERE adviceId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteChampion);
			deleteStmt.setInt(1, championAdvice.getAdvice());
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
	 * Returns the champion advice for the specified adviceId.
	 * Runs a SELECT statement on the ChampionAdvice table.
	 * @param adviceID
	 * @return
	 * @throws SQLException
	 */
	public ChampionAdvice getChampionAdviceById(int adviceID) throws SQLException {
		String selectReshare =
			"SELECT adviceId,championId,allyAdvice,enemyAdvice " +
			"FROM ChampionAdvice " +
			"WHERE adviceId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectReshare);
			selectStmt.setInt(1, adviceID);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultAdviceId = results.getInt("adviceId");
				int championId = results.getInt("championId");
				String allyAdvice = results.getString("allyAdvice");
				String enemyAdvice = results.getString("enemyAdvice");
	
				ChampionAdvice championAdvice = new ChampionAdvice(resultAdviceId, 
						championId, allyAdvice, enemyAdvice);
				return championAdvice;
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
	
	/**
	 * Returns all the champion advice for the specified champion.
	 * Runs a SELECT statement on the ChampionAdvice table.
	 * @param champion
	 * @return
	 * @throws SQLException
	 */
	public List<ChampionAdvice> getAdviceForChampion(Champions champion) throws SQLException {
		List<ChampionAdvice> championAdviceList = new ArrayList<ChampionAdvice>();
		String selectReshares =
			"SELECT adviceId,allyAdvice,enemyAdvice " +
			"FROM ChampionAdvice " + 
			"WHERE championId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		int championId = champion.getChampionId();
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectReshares);
			selectStmt.setInt(1, championId);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int adviceId = results.getInt("adviceId");
				String allyAdvice = results.getString("allyAdvice");
				String enemyAdvice = results.getString("enemyAdvice");
				ChampionAdvice advice = new ChampionAdvice(adviceId, championId, allyAdvice, enemyAdvice);
				championAdviceList.add(advice);
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
		return championAdviceList;
	}
}
