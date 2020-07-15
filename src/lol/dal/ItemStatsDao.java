package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lol.model.*;

public class ItemStatsDao {

	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static ItemStatsDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 */
	private ItemStatsDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static ItemStatsDao getInstance() {
		if(instance == null) {
			instance = new ItemStatsDao();
		}
		return instance;
	}
	
	/**
	 * INSERT a new item record in the LOL schema's Item table.
	 * @param item Item object to insert
	 * @return the created item
	 * @throws SQLException
	 */
	public ItemStats create(ItemStats itemStats) throws SQLException {

		String insertItemStats = "INSERT INTO ItemStats(ItemStatsId, ItemId, StatName, Value) VALUES(?,?,?,?);";


		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertItemStats);
			insertStmt.setInt(1, itemStats.getItemStatsId());
			insertStmt.setInt(2, itemStats.getItem().getItemId());
			insertStmt.setString(3, itemStats.getStatName());
			insertStmt.setDouble(4, itemStats.getValue());
			insertStmt.executeUpdate();
			return itemStats;
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
	 * DELETE the ItemStats instance in the database schema.
	 * @param item Item to delete
	 * @return null
	 * @throws SQLException 
	 */
	public ItemStats delete(ItemStats itemStats) throws SQLException {
		String deleteItemStats = "DELETE FROM ItemStats WHERE ItemStatsId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteItemStats);
			deleteStmt.setInt(1, itemStats.getItemStatsId());
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
	public ItemStats getItemStatsFromID(int id) throws SQLException {
		String selectItemStats =
				"SELECT ItemStats.ItemStatsId as ItemStatsId, ItemId, StatName, Value "
				+ "FROM ItemStats "
				+ "WHERE ItemStats.itemStatsId=?;";

			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				ItemDao itemDao = ItemDao.getInstance();
				selectStmt = connection.prepareStatement(selectItemStats);
				selectStmt.setInt(1, id);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int itemStatsId = results.getInt("ItemStatsId");
					int itemId = results.getInt("ItemId");
					String statName = results.getString("StatName");
					double value = results.getDouble("Value");
					Item item = itemDao.getItemFromID(itemId);
					ItemStats itemStats = new ItemStats(itemStatsId, item, statName, value);
					return itemStats;
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
