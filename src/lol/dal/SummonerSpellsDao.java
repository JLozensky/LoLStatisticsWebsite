package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lol.model.*;

public class SummonerSpellsDao {
	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static SummonerSpellsDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 */
	private SummonerSpellsDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static SummonerSpellsDao getInstance() {
		if(instance == null) {
			instance = new SummonerSpellsDao();
		}
		return instance;
	}
	
	/**
	 * INSERT a new item record in the LOL schema's Item table.
	 * @param item Item object to insert
	 * @return the created item
	 * @throws SQLException
	 */
	public SummonerSpells create(SummonerSpells summonerSpells) throws SQLException {

		String insertSummonerSpells = "INSERT INTO SummonerSpells(SummonerSpellId, Name, Description,"
				+ " Range, CoolDown, SummonerLevel, ModeAvailable) VALUES(?,?,?,?,?,?,?);";

		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertSummonerSpells);
			insertStmt.setInt(1, summonerSpells.getSummonerSpellId());
			insertStmt.setString(2, summonerSpells.getName());
			insertStmt.setString(3, summonerSpells.getDescription());
			insertStmt.setInt(4, summonerSpells.getRange());
			insertStmt.setInt(5, summonerSpells.getCoolDown());
			insertStmt.setInt(6, summonerSpells.getSummonerLevel());
			insertStmt.setString(7, summonerSpells.getModeAvailable());
			insertStmt.executeUpdate();
			return summonerSpells;
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

	/**
	 * DELETE the SummonerSpells instance in the database schema.
	 * @param item Item to delete
	 * @return null
	 * @throws SQLException 
	 */
	public SummonerSpells delete(SummonerSpells summonerSpells) throws SQLException {
		String deleteSummonerSpells = "DELETE FROM SummonerSpells WHERE SummonerSpellId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteSummonerSpells);
			deleteStmt.setInt(1, summonerSpells.getSummonerSpellId());
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
	 * Gets the specified item from the Item table based on itemId.
	 * Runs a SELECT statement.
	 * @param id itemId field of the item to get.
	 * @return Item table row
	 * @throws SQLException
	 */
	public SummonerSpells getSummonerSpellsFromID(int id) throws SQLException {
		String selectSummonerSpells =
				"SELECT SummonerSpells.SummonerSpellId as SummonerSpellId, Name, Description, Range, "
				+ "CoolDown, SummonerLevel, ModeAvailable "
				+ "FROM SummonerSpells "
				+ "WHERE SummonerSpells.summonerSpellId=?;";

			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectSummonerSpells);
				selectStmt.setInt(1, id);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int summonerSpellId = results.getInt("SummonerSpellId");
					String name = results.getString("Name");
					String description = results.getString("Description");
					int range = results.getInt("Range");
					int coolDown = results.getInt("CoolDown");
					int summonerLevel = results.getInt("SummonerLevel");
					String modeAvailable = results.getString("ModeAvailable");
					SummonerSpells summonerSpells = new SummonerSpells(summonerSpellId, name, 
							description, range, coolDown, summonerLevel, modeAvailable);
					return summonerSpells;
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
