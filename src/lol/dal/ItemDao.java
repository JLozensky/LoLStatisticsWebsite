package lol.dal;

import java.sql.*;
import lol.model.*;

/**
 * Dao for the Item table
 */
public class ItemDao {

	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static ItemDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 */
	private ItemDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static ItemDao getInstance() {
		if(instance == null) {
			instance = new ItemDao();
		}
		return instance;
	}
	
	/**
	 * INSERT a new item record in the LOL schema's Item table.
	 * @param item Item object to insert
	 * @return the created item
	 * @throws SQLException
	 */
	public Item create(Item item) throws SQLException {

		String insertItem = "INSERT INTO Item(ItemId, Name, Description, PlainTextDesc, BaseCost, "
				+ "Purchasable, TotalCost, SellPrice, Tags, Map11, Map12, Map22, Depth, MaxStack, Consumed, "
				+ "InStore, RequiredChampion, RequiredAlly) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertItem);
			insertStmt.setInt(1, item.getItemId());
			insertStmt.setString(2, item.getName());
			insertStmt.setString(3, item.getDescription());
			insertStmt.setString(4, item.getPlainTextDesc());
			insertStmt.setString(5, item.getBaseCost());
			insertStmt.setBoolean(6, item.isPurchasable());
			insertStmt.setInt(7, item.getTotalCost());
			insertStmt.setInt(8, item.getSellPrice());
			insertStmt.setString(9, item.getTags());
			insertStmt.setBoolean(10, item.isMap11());
			insertStmt.setBoolean(11, item.isMap12());
			insertStmt.setBoolean(12, item.isMap22());
			insertStmt.setInt(13, item.getDepth());
			insertStmt.setInt(14, item.getMaxStack());
			insertStmt.setBoolean(15, item.isConsumed());
			insertStmt.setBoolean(16, item.isInStore());
			insertStmt.setString(17, item.getRequiredChampion());
			insertStmt.setString(18, item.getRequiredAlly());
			insertStmt.executeUpdate();
			return item;
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
	 * DELETE the Item instance in the database schema.
	 * @param item Item to delete
	 * @return null
	 * @throws SQLException 
	 */
	public Item delete(Item item) throws SQLException {
		String deleteItem = "DELETE FROM Item WHERE itemId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteItem);
			deleteStmt.setInt(1, item.getItemId());
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
	public Item getItemFromID(int id) throws SQLException {
		String selectItem =
				"SELECT Item.ItemId as ItemId,Name,Description,PlainTextDesc,BaseCost,Purchasable,"
				+ "TotalCost,SellPrice,Tags,Map11,Map12,Map22,Depth,MaxStack,Consumed,InStore,RequiredChampion,"
				+ "RequiredAlly FROM Item WHERE Item.itemId=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectItem);
				selectStmt.setInt(1, id);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int itemId = results.getInt("ItemId");
					String name = results.getString("Name");
					String description = results.getString("Description");
					String plainTextDesc = results.getString("PlainTextDesc");
					String baseCost = results.getString("BaseCost");
					boolean purchasable = results.getBoolean("Purchasable");
					int totalCost = results.getInt("TotalCost");
					int sellPrice = results.getInt("SellPrice");
					String tags = results.getString("Tags");
					boolean map11 = results.getBoolean("Map11");
					boolean map12 = results.getBoolean("Map12");
					boolean map22 = results.getBoolean("Map22");
					int depth = results.getInt("Depth");
					int maxStack = results.getInt("MaxStack");
					boolean consumed = results.getBoolean("Consumed");
					boolean inStore = results.getBoolean("InStore");
					String requiredChampion = results.getString("RequiredChampion");
					String requiredAlly = results.getString("RequiredAlly");
					Item item = new Item(itemId, name, description, plainTextDesc, baseCost, purchasable, totalCost,
							sellPrice, tags, map11, map12, map22, depth, maxStack, consumed, inStore,
							requiredChampion, requiredAlly);
					return item;
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
