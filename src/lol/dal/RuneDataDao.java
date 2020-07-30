package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lol.model.*;

public class RuneDataDao {
	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static RuneDataDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 */
	private RuneDataDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static RuneDataDao getInstance() {
		if(instance == null) {
			instance = new RuneDataDao();
		}
		return instance;
	}
	
	/**
	 * INSERT a new item record in the LOL schema's Item table.
	 * @param item Item object to insert
	 * @return the created item
	 * @throws SQLException
	 */
	public Rune create(Rune rune) throws SQLException {

		String insertRuneData = "INSERT INTO RuneData(RuneId, Name, PathName, LongDesc) VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertRuneData);
			insertStmt.setInt(1, rune.getRuneId());
			insertStmt.setString(2, rune.getName());
			insertStmt.setString(3, rune.getPathName());
			insertStmt.setString(4, rune.getLongDesc());
			insertStmt.executeUpdate();
			return rune;
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
	 * DELETE the RuneData instance in the database schema.
	 * @param item Item to delete
	 * @return null
	 * @throws SQLException 
	 */
	public Rune delete(Rune rune) throws SQLException {
		String deleteRuneData = "DELETE FROM RuneData WHERE RuneId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteRuneData);
			deleteStmt.setInt(1, rune.getRuneId());
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
	public Rune getRuneDataFromID(int id) throws SQLException {
		String selectRuneData =
				"SELECT RuneData.RuneId as RuneId, ItemId, StatName, Value "
				+ "FROM RuneData "
				+ "WHERE RuneData.runeId=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectRuneData);
				selectStmt.setInt(1, id);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int runeId = results.getInt("RuneId");
					String name = results.getString("Name");
					String pathName = results.getString("PathName");
					String longDesc = results.getString("LongDesc");
					Rune rune = new Rune(runeId, name, pathName, longDesc);
					return rune;
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
