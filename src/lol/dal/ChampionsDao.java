package lol.dal;

import java.sql.*;

import lol.model.*;

/**
 * Data Access Object for Champions table
 */
public class ChampionsDao {
	
	/**
	 * Manages connection to the database.
	 */
	protected ConnectionManager connectionManager;
	
	/**
	 * Single pattern: instantiation is limited to one object.
	 */
	private static ChampionsDao instance = null;
	
	/**
	 * Private constructor that creates a new connection manager.
	 * Inaccessible to outside classes only the singleton instance can be accessed.
	 */
	private ChampionsDao() {
		connectionManager = new ConnectionManager();
	}
	
	/**
	 * Returns the singleton instance for this class.
	 * @return singleton instance for this class
	 */
	public static ChampionsDao getInstance() {
		if(instance == null) {
			instance = new ChampionsDao();
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
	public Champions create(Champions champion) throws SQLException {

		String insertChampions = "INSERT INTO Champions(championId,name,title,lore,"
				+ "championRole1,championRole2,attack,defense,magic,difficulty,hp,"
				+ "hpPerLevel,mp,mpPerLevel,moveSpeed,armor,armorPerLevel,spellBlock,"
				+ "spellBlockPerLevel,attackRange,hpRegen,hpRegenPerLevel,mpRegen,"
				+ "mpRegenPerLevel,attackDamage,attackDamagePerLevel,"
				+ "attackSpeed,attackSpeedPerLevel,passiveName,passiveDescription) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertChampions);
			insertStmt.setInt(1, champion.getChampionId());
			insertStmt.setString(2, champion.getName());
			insertStmt.setString(3, champion.getTitle());
			insertStmt.setString(4, champion.getLore());
			insertStmt.setString(5, champion.getChampionRole1().toString());
			insertStmt.setString(6, champion.getChampionRole2().toString());
			insertStmt.setInt(7, champion.getAttack());
			insertStmt.setInt(8, champion.getDefense());
			insertStmt.setInt(9, champion.getMagic());
			insertStmt.setInt(10, champion.getDifficulty());
			insertStmt.setDouble(11, champion.getHp());
			insertStmt.setDouble(12, champion.getHpPerLevel());
			insertStmt.setDouble(13, champion.getMp());
			insertStmt.setDouble(14, champion.getMpPerLevel());
			insertStmt.setInt(15, champion.getMoveSpeed());
			insertStmt.setDouble(16, champion.getArmor());
			insertStmt.setDouble(17, champion.getArmorPerLevel());
			insertStmt.setDouble(18, champion.getSpellBlock());
			insertStmt.setDouble(19, champion.getSpellBlockPerLevel());
			insertStmt.setInt(20, champion.getAttackRange());
			insertStmt.setDouble(21, champion.getHpRegen());
			insertStmt.setDouble(22, champion.getHpRegenPerLevel());
			insertStmt.setDouble(23, champion.getMpRegen());
			insertStmt.setDouble(24, champion.getMpRegenLevel());
			insertStmt.setDouble(25, champion.getAttackDamage());
			insertStmt.setDouble(26, champion.getAttackDamagePerLevel());
			insertStmt.setDouble(27, champion.getAttackSpeed());
			insertStmt.setDouble(28, champion.getAttackSpeedPerLevel());
			insertStmt.setString(29, champion.getPassiveName());
			insertStmt.setString(30, champion.getPassiveDescription());			
			insertStmt.executeUpdate();
			return champion;
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
	 * Delete the Champions instance. This runs a DELETE statement.
	 * @param champion Champion to delete
	 * @return null
	 * @throws SQLException 
	 */
	public Champions delete(Champions champion) throws SQLException {
		String deleteChampion = "DELETE FROM Champions WHERE championId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteChampion);
			deleteStmt.setInt(1, champion.getChampionId());
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
	 * Gets the specified champion from the Champions table based on championId.
	 * Runs a SELECT statement.
	 * @param id championId field of the champion to get.
	 * @return Champions table row
	 * @throws SQLException
	 */
	public Champions getChampionFromID(int id) throws SQLException {
		String selectChampion =
				"SELECT Champions.championId as championId,name,title,lore,"
				+ "championRole1,championRole2,attack,defense,magic,difficulty,hp,"
				+ "hpPerLevel,mp,mpPerLevel,moveSpeed,armor,armorPerLevel,spellBlock,"
				+ "spellBlockPerLevel,attackRange,hpRegen,hpRegenPerLevel,mpRegen,"
				+ "mpRegenPerLevel,attackDamage,attackDamagePerLevel,"
				+ "attackSpeed,attackSpeedPerLevel,passiveName,passiveDescription "
				+ "FROM Champions "
				+ "WHERE Champions.championId=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectChampion);
				selectStmt.setInt(1, id);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int resultID = results.getInt("championId");
					String name = results.getString("name");
					String title = results.getString("title");
					String lore = results.getString("lore");
					Champions.championRole championRole1 = Champions.championRole.valueOf(
							results.getString("championRole1"));
					Champions.championRole championRole2 = Champions.championRole.valueOf(
							results.getString("championRole2"));
					int attack = results.getInt("attack");
					int defense = results.getInt("defense");
					int magic = results.getInt("magic");
					int difficulty = results.getInt("difficulty");
					double hp = results.getDouble("hp");
					double hpPerLevel = results.getDouble("hpPerLevel");
					double mp = results.getDouble("mp");
					double mpPerLevel = results.getDouble("mpPerLevel");
					int moveSpeed = results.getInt("moveSpeed");
					double armor = results.getDouble("armor");
					double armorPerLevel = results.getDouble("armorPerLevel");
					double spellBlock = results.getDouble("spellBlock");
					double spellBlockPerLevel = results.getDouble("spellBlockPerLevel");
					int attackRange = results.getInt("attackRange");
					double hpRegen = results.getDouble("hpRegen");
					double hpRegenPerLevel = results.getDouble("hpRegenPerLevel");
					double mpRegen = results.getDouble("mpRegen");
					double mpRegenPerLevel = results.getDouble("mpRegenPerLevel");
					double attackDamage = results.getDouble("attackDamage");
					double attackDamagePerLevel = results.getDouble("attackDamagePerLevel");
					double attackSpeed = results.getDouble("attackSpeed");
					double attackSpeedPerLevel = results.getDouble("attackSpeedPerLevel");
					String passiveName = results.getString("passiveName");
					String passiveDescription = results.getString("passiveDescription");
					
					Champions champion = new Champions(resultID, name, title, lore, championRole1,
					 championRole2, attack, defense, magic, difficulty, hp, hpPerLevel, mp, mpPerLevel, moveSpeed, armor, armorPerLevel,
					 spellBlock, spellBlockPerLevel, attackRange, hpRegen, hpRegenPerLevel, mpRegen, mpRegenPerLevel, attackDamage, attackDamagePerLevel,
					 attackSpeedPerLevel, attackSpeed, passiveName, passiveDescription);
					
					return champion;
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
