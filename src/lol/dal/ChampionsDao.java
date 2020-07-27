package lol.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
				"SELECT championId,name,title,lore,championRole1,championRole2,attack,t.minAttack, t.maxAttack,defense,t.minDefense,t.maxDefense,"
				+ "magic,t.minMagic, t.maxMagic,difficulty,t.minDifficulty, t.maxDifficulty,hp,t.minHp, t.maxHp,"
				+ "hpPerLevel,t.minHpPerLevel, t.maxHpPerLevel,mp,t.minMp, t.maxMp,mpPerLevel,t.minMpPerLevel, t.maxMpPerLevel,"
				+ "moveSpeed,t.minMoveSpeed, t.maxMoveSpeed,armor,t.minArmor, t.maxArmor,armorPerLevel,t.minArmorPerLevel, "
				+ "t.maxArmorPerLevel,spellBlock,t.minSpellBlock, t.maxSpellBlock,spellBlockPerLevel,t.minSpellBlockPerLevel, "
				+ "t.maxSpellBlockPerLevel,attackRange,t.minAttackRange, t.maxAttackRange,hpRegen,t.minHpRegen, t.maxHpRegen,"
				+ "hpRegenPerLevel,t.minHpRegenPerLevel, t.maxHpRegenPerLevel,mpRegen,t.minMpRegen, t.maxMpRegen,"
				+ "mpRegenPerLevel,t.minMpRegenPerLevel, t.maxMpRegenPerLevel,attackDamage,t.minAttackDamage, t.maxAttackDamage,"
				+ "attackDamagePerLevel,t.minAttackDamagePerLevel, t.maxAttackDamagePerLevel,attackSpeed,t.minAttackSpeed, "
				+ "t.maxAttackSpeed,attackSpeedPerLevel,t.minAttackSpeedPerLevel, t.maxAttackSpeedPerLevel,"
				+ "passiveName,passiveDescription,imageFile "
				+ "FROM ("
				+ "SELECT MIN(attack) as minAttack, MAX(attack) as maxAttack,"
				+ "MIN(defense) as minDefense, MAX(defense) as maxDefense,"
				+ "MIN(magic) as minMagic, MAX(magic) as maxMagic,"
				+ "MIN(difficulty) as minDifficulty, MAX(difficulty) as maxDifficulty,"
				+ "MIN(hp) as minHp, MAX(hp) as maxHp,"
				+ "MIN(hpPerLevel) as minHpPerLevel, MAX(hpPerLevel) as maxHpPerLevel,"
				+ "MIN(mp) as minMp, MAX(mp) as maxMp,"
				+ "MIN(mpPerLevel) as minMpPerLevel, MAX(mpPerLevel) as maxMpPerLevel,"
				+ "MIN(moveSpeed) as minMoveSpeed, MAX(moveSpeed) as maxMoveSpeed,"
				+ "MIN(armor) as minArmor, MAX(armor) as maxArmor,"
				+ "MIN(armorPerLevel) as minArmorPerLevel, MAX(armorPerLevel) as maxArmorPerLevel,"
				+ "MIN(spellBlock) as minSpellBlock, MAX(spellBlock) as maxSpellBlock,"
				+ "MIN(spellBlockPerLevel) as minSpellBlockPerLevel, MAX(spellBlockPerLevel) as maxSpellBlockPerLevel,"
				+ "MIN(attackRange) as minAttackRange, MAX(attackRange) as maxAttackRange,"
				+ "MIN(hpRegen) as minHpRegen, MAX(hpRegen) as maxHpRegen,"
				+ "MIN(hpRegenPerLevel) as minHpRegenPerLevel, MAX(hpRegenPerLevel) as maxHpRegenPerLevel,"
				+ "MIN(mpRegen) as minMpRegen, MAX(mpRegen) as maxMpRegen,"
				+ "MIN(mpRegenPerLevel) as minMpRegenPerLevel, MAX(mpRegenPerLevel) as maxMpRegenPerLevel,"
				+ "MIN(attackDamage) as minAttackDamage, MAX(attackDamage) as maxAttackDamage,"
				+ "MIN(attackDamagePerLevel) as minAttackDamagePerLevel, MAX(attackDamagePerLevel) as maxAttackDamagePerLevel,"
				+ "MIN(attackSpeed) as minAttackSpeed, MAX(attackSpeed) as maxAttackSpeed,"
				+ "MIN(attackSpeedPerLevel) as minAttackSpeedPerLevel, MAX(attackSpeedPerLevel) as maxAttackSpeedPerLevel "
				+ "FROM Champions) AS t "
				+ "CROSS JOIN Champions WHERE championId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			selectStmt.setInt(1, id);
			results = selectStmt.executeQuery();
			if(results.next()) {
				return parseChampionFromResult(results);
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
	
	private Champions parseChampionFromResult(ResultSet results) throws SQLException {
		int resultID = results.getInt("championId");
		String name = results.getString("name");
		String title = results.getString("title");
		String lore = results.getString("lore");
		String championRole = results.getString("championRole1");
		Champions.championRole championRole1 = Champions.championRole.NONE;
		if (championRole != null && !championRole.trim().isEmpty()) {
			championRole1 = Champions.championRole.valueOf(
					championRole);
		}
		
		Champions.championRole championRole2 = Champions.championRole.NONE;
		championRole = results.getString("championRole2");
		if (championRole != null && !championRole.trim().isEmpty()) {
			championRole2 = Champions.championRole.valueOf(
					championRole);
		}
		int attack = results.getInt("attack");
		int minAttack = results.getInt("minAttack");
		int maxAttack = results.getInt("maxAttack");
		int defense = results.getInt("defense");
		int minDefense = results.getInt("minDefense");
		int maxDefense = results.getInt("maxDefense");
		int magic = results.getInt("magic");
		int minMagic = results.getInt("minMagic");
		int maxMagic = results.getInt("maxMagic");
		int difficulty = results.getInt("difficulty");
		int minDifficulty = results.getInt("minDifficulty");
		int maxDifficulty = results.getInt("maxDifficulty");
		double hp = results.getDouble("hp");
		double minHp = results.getDouble("minHp");
		double maxHp = results.getDouble("maxHp");
		double hpPerLevel = results.getDouble("hpPerLevel");
		double minHpPerLevel = results.getDouble("minHpPerLevel");
		double maxHpPerLevel = results.getDouble("maxHpPerLevel");
		double mp = results.getDouble("mp");
		double minMp = results.getDouble("minMp");
		double maxMp = results.getDouble("maxMp");
		double mpPerLevel = results.getDouble("mpPerLevel");
		double minMpPerLevel = results.getDouble("minMpPerLevel");
		double maxMpPerLevel = results.getDouble("maxMpPerLevel");
		int moveSpeed = results.getInt("moveSpeed");
		int minMoveSpeed = results.getInt("minMoveSpeed");
		int maxMoveSpeed = results.getInt("maxMoveSpeed");
		double armor = results.getDouble("armor");
		double minArmor = results.getDouble("minArmor");
		double maxArmor = results.getDouble("maxArmor");
		double armorPerLevel = results.getDouble("armorPerLevel");
		double minArmorPerLevel = results.getDouble("minArmorPerLevel");
		double maxArmorPerLevel = results.getDouble("maxArmorPerLevel");
		double spellBlock = results.getDouble("spellBlock");
		double minSpellBlock = results.getDouble("minSpellBlock");
		double maxSpellBlock = results.getDouble("maxSpellBlock");
		double spellBlockPerLevel = results.getDouble("spellBlockPerLevel");
		double minSpellBlockPerLevel = results.getDouble("minSpellBlockPerLevel");
		double maxSpellBlockPerLevel = results.getDouble("maxSpellBlockPerLevel");
		int attackRange = results.getInt("attackRange");
		int minAttackRange = results.getInt("minAttackRange");
		int maxAttackRange = results.getInt("maxAttackRange");
		double hpRegen = results.getDouble("hpRegen");
		double minHpRegen = results.getDouble("minHpRegen");
		double maxHpRegen = results.getDouble("maxHpRegen");
		double hpRegenPerLevel = results.getDouble("hpRegenPerLevel");
		double minHpRegenPerLevel = results.getDouble("minHpRegenPerLevel");
		double maxHpRegenPerLevel = results.getDouble("maxHpRegenPerLevel");
		double mpRegen = results.getDouble("mpRegen");
		double minMpRegen = results.getDouble("minMpRegen");
		double maxMpRegen = results.getDouble("maxMpRegen");
		double mpRegenPerLevel = results.getDouble("mpRegenPerLevel");
		double minMpRegenPerLevel = results.getDouble("minMpRegenPerLevel");
		double maxMpRegenPerLevel = results.getDouble("maxMpRegenPerLevel");
		double attackDamage = results.getDouble("attackDamage");
		double minAttackDamage = results.getDouble("minAttackDamage");
		double maxAttackDamage = results.getDouble("maxAttackDamage");
		double attackDamagePerLevel = results.getDouble("attackDamagePerLevel");
		double minAttackDamagePerLevel = results.getDouble("minAttackDamagePerLevel");
		double maxAttackDamagePerLevel = results.getDouble("maxAttackDamagePerLevel");
		double attackSpeed = results.getDouble("attackSpeed");
		double minAttackSpeed = results.getDouble("minAttackSpeed");
		double maxAttackSpeed = results.getDouble("maxAttackSpeed");
		double attackSpeedPerLevel = results.getDouble("attackSpeedPerLevel");
		double minAttackSpeedPerLevel = results.getDouble("minAttackSpeedPerLevel");
		double maxAttackSpeedPerLevel = results.getDouble("maxAttackSpeedPerLevel");
		String passiveName = results.getString("passiveName");
		String passiveDescription = results.getString("passiveDescription");
		String imageFile = results.getString("imageFile");
		
		Champions champion = new Champions(resultID, name, title, lore, championRole1,
		 championRole2, attack, defense, magic, difficulty, hp, hpPerLevel, mp, mpPerLevel, moveSpeed, armor, armorPerLevel,
		 spellBlock, spellBlockPerLevel, attackRange, hpRegen, hpRegenPerLevel, mpRegen, mpRegenPerLevel, attackDamage, attackDamagePerLevel,
		 attackSpeedPerLevel, attackSpeed, passiveName, passiveDescription, imageFile);
		
		champion.setMinMaxFields(minAttack, maxAttack, minDefense, maxDefense, minMagic, maxMagic, minDifficulty, maxDifficulty, 
				minHp, maxHp, minHpPerLevel, maxHpPerLevel, minMp, maxMp, minMpPerLevel, maxMpPerLevel, 
				minMoveSpeed, maxMoveSpeed, minArmor, maxArmor, minArmorPerLevel, maxArmorPerLevel, minSpellBlock, maxSpellBlock, 
				minSpellBlockPerLevel, maxSpellBlockPerLevel, minAttackRange, maxAttackRange, minHpRegen, maxHpRegen, 
				minHpRegenPerLevel, maxHpRegenPerLevel, minMpRegen, maxMpRegen, minMpRegenPerLevel, maxMpRegenPerLevel,
				minAttackDamage, maxAttackDamage, minAttackDamagePerLevel, 
				maxAttackDamagePerLevel, minAttackSpeed, maxAttackSpeed, minAttackSpeedPerLevel, maxAttackSpeedPerLevel);
		
		return champion;
	}
	
	public List<Champions> getChampionsFromMatchOutcome(boolean isWin, int seasonId) throws SQLException {
		List<Champions> championList = new ArrayList<Champions>();
		
		// gets the winning/losing champions for a particular season
		String selectChampion =
				"SELECT Champions.championId as championId,name,title,lore,"
				+ "championRole1,championRole2,attack,defense,magic,difficulty,hp,"
				+ "hpPerLevel,mp,mpPerLevel,moveSpeed,armor,armorPerLevel,spellBlock,"
				+ "spellBlockPerLevel,attackRange,hpRegen,hpRegenPerLevel,mpRegen,"
				+ "mpRegenPerLevel,attackDamage,attackDamagePerLevel,"
				+ "attackSpeed,attackSpeedPerLevel,passiveName,passiveDescription,TeamStats.win,"
				+ "Game.seasonId "
				+ "FROM Champions "
				+ "INNER JOIN SummonerStats "
				+ "ON SummonerStats.championId=Champions.championId"
				+ "INNER JOIN TeamStats "
				+ "ON TeamStats.statsId=SummonerStats.summonerStatsId"
				+ "LEFT OUTER JOIN Game"
				+ "ON Game.team1=TeamStats.statId"
				+ "LEFT OUTER JOIN Game "
				+ "ON Game.team2=TeamStats.statId "
				+ "WHERE TeamStats.win=? AND Game.seasonId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			selectStmt.setBoolean(1, isWin);
			selectStmt.setInt(2, seasonId);
			results = selectStmt.executeQuery();
			while(results.next()) {
				championList.add(parseChampionFromResult(results));
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
		
		return championList;
	}
	
	public List<Champions> getChampionsFromName(String championName) throws SQLException {
		List<Champions> championList = new ArrayList<Champions>();
		
		// gets the winning/losing champions for a particular season
		String selectChampion =
				"SELECT championId,name,title,lore,championRole1,championRole2,attack,t.minAttack, t.maxAttack,defense,t.minDefense,t.maxDefense,"
						+ "magic,t.minMagic, t.maxMagic,difficulty,t.minDifficulty, t.maxDifficulty,hp,t.minHp, t.maxHp,"
						+ "hpPerLevel,t.minHpPerLevel, t.maxHpPerLevel,mp,t.minMp, t.maxMp,mpPerLevel,t.minMpPerLevel, t.maxMpPerLevel,"
						+ "moveSpeed,t.minMoveSpeed, t.maxMoveSpeed,armor,t.minArmor, t.maxArmor,armorPerLevel,t.minArmorPerLevel, "
						+ "t.maxArmorPerLevel,spellBlock,t.minSpellBlock, t.maxSpellBlock,spellBlockPerLevel,t.minSpellBlockPerLevel, "
						+ "t.maxSpellBlockPerLevel,attackRange,t.minAttackRange, t.maxAttackRange,hpRegen,t.minHpRegen, t.maxHpRegen,"
						+ "hpRegenPerLevel,t.minHpRegenPerLevel, t.maxHpRegenPerLevel,mpRegen,t.minMpRegen, t.maxMpRegen,"
						+ "mpRegenPerLevel,t.minMpRegenPerLevel, t.maxMpRegenPerLevel,attackDamage,t.minAttackDamage, t.maxAttackDamage,"
						+ "attackDamagePerLevel,t.minAttackDamagePerLevel, t.maxAttackDamagePerLevel,attackSpeed,t.minAttackSpeed, "
						+ "t.maxAttackSpeed,attackSpeedPerLevel,t.minAttackSpeedPerLevel, t.maxAttackSpeedPerLevel,"
						+ "passiveName,passiveDescription,imageFile "
						+ "FROM ("
						+ "SELECT MIN(attack) as minAttack, MAX(attack) as maxAttack,"
						+ "MIN(defense) as minDefense, MAX(defense) as maxDefense,"
						+ "MIN(magic) as minMagic, MAX(magic) as maxMagic,"
						+ "MIN(difficulty) as minDifficulty, MAX(difficulty) as maxDifficulty,"
						+ "MIN(hp) as minHp, MAX(hp) as maxHp,"
						+ "MIN(hpPerLevel) as minHpPerLevel, MAX(hpPerLevel) as maxHpPerLevel,"
						+ "MIN(mp) as minMp, MAX(mp) as maxMp,"
						+ "MIN(mpPerLevel) as minMpPerLevel, MAX(mpPerLevel) as maxMpPerLevel,"
						+ "MIN(moveSpeed) as minMoveSpeed, MAX(moveSpeed) as maxMoveSpeed,"
						+ "MIN(armor) as minArmor, MAX(armor) as maxArmor,"
						+ "MIN(armorPerLevel) as minArmorPerLevel, MAX(armorPerLevel) as maxArmorPerLevel,"
						+ "MIN(spellBlock) as minSpellBlock, MAX(spellBlock) as maxSpellBlock,"
						+ "MIN(spellBlockPerLevel) as minSpellBlockPerLevel, MAX(spellBlockPerLevel) as maxSpellBlockPerLevel,"
						+ "MIN(attackRange) as minAttackRange, MAX(attackRange) as maxAttackRange,"
						+ "MIN(hpRegen) as minHpRegen, MAX(hpRegen) as maxHpRegen,"
						+ "MIN(hpRegenPerLevel) as minHpRegenPerLevel, MAX(hpRegenPerLevel) as maxHpRegenPerLevel,"
						+ "MIN(mpRegen) as minMpRegen, MAX(mpRegen) as maxMpRegen,"
						+ "MIN(mpRegenPerLevel) as minMpRegenPerLevel, MAX(mpRegenPerLevel) as maxMpRegenPerLevel,"
						+ "MIN(attackDamage) as minAttackDamage, MAX(attackDamage) as maxAttackDamage,"
						+ "MIN(attackDamagePerLevel) as minAttackDamagePerLevel, MAX(attackDamagePerLevel) as maxAttackDamagePerLevel,"
						+ "MIN(attackSpeed) as minAttackSpeed, MAX(attackSpeed) as maxAttackSpeed,"
						+ "MIN(attackSpeedPerLevel) as minAttackSpeedPerLevel, MAX(attackSpeedPerLevel) as maxAttackSpeedPerLevel "
						+ "FROM Champions) AS t "
						+ "CROSS JOIN Champions WHERE name LIKE ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			selectStmt.setString(1, "%" + championName + "%");
			results = selectStmt.executeQuery();
			while(results.next()) {
				championList.add(parseChampionFromResult(results));
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
		
		return championList;
	}
	
	/**
	 * Gets the top 10 best champions for the specified user to fight against
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<Champions> getBestChampionsToFightAgainst(Users user) throws SQLException {
		List<Champions> championList = new ArrayList<Champions>();
		
		// TODO insert actual query
		String selectChampion = "SELECT * FROM ("
				+ "SELECT MIN(attack) as minAttack, MAX(attack) as maxAttack,"
				+ "MIN(defense) as minDefense, MAX(defense) as maxDefense,"
				+ "MIN(magic) as minMagic, MAX(magic) as maxMagic,"
				+ "MIN(difficulty) as minDifficulty, MAX(difficulty) as maxDifficulty,"
				+ "MIN(hp) as minHp, MAX(hp) as maxHp,"
				+ "MIN(hpPerLevel) as minHpPerLevel, MAX(hpPerLevel) as maxHpPerLevel,"
				+ "MIN(mp) as minMp, MAX(mp) as maxMp,"
				+ "MIN(mpPerLevel) as minMpPerLevel, MAX(mpPerLevel) as maxMpPerLevel,"
				+ "MIN(moveSpeed) as minMoveSpeed, MAX(moveSpeed) as maxMoveSpeed,"
				+ "MIN(armor) as minArmor, MAX(armor) as maxArmor,"
				+ "MIN(armorPerLevel) as minArmorPerLevel, MAX(armorPerLevel) as maxArmorPerLevel,"
				+ "MIN(spellBlock) as minSpellBlock, MAX(spellBlock) as maxSpellBlock,"
				+ "MIN(spellBlockPerLevel) as minSpellBlockPerLevel, MAX(spellBlockPerLevel) as maxSpellBlockPerLevel,"
				+ "MIN(attackRange) as minAttackRange, MAX(attackRange) as maxAttackRange,"
				+ "MIN(hpRegen) as minHpRegen, MAX(hpRegen) as maxHpRegen,"
				+ "MIN(hpRegenPerLevel) as minHpRegenPerLevel, MAX(hpRegenPerLevel) as maxHpRegenPerLevel,"
				+ "MIN(mpRegen) as minMpRegen, MAX(mpRegen) as maxMpRegen,"
				+ "MIN(mpRegenPerLevel) as minMpRegenPerLevel, MAX(mpRegenPerLevel) as maxMpRegenPerLevel,"
				+ "MIN(attackDamage) as minAttackDamage, MAX(attackDamage) as maxAttackDamage,"
				+ "MIN(attackDamagePerLevel) as minAttackDamagePerLevel, MAX(attackDamagePerLevel) as maxAttackDamagePerLevel,"
				+ "MIN(attackSpeed) as minAttackSpeed, MAX(attackSpeed) as maxAttackSpeed,"
				+ "MIN(attackSpeedPerLevel) as minAttackSpeedPerLevel, MAX(attackSpeedPerLevel) as maxAttackSpeedPerLevel "
				+ "FROM Champions) as t "
				+ "CROSS JOIN Champions LIMIT 10;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			// TODO uncomment when there's a parameter in the query to filter against
			// selectStmt.setString(1, user.getUsername());
			results = selectStmt.executeQuery();
			while(results.next()) {
				championList.add(parseChampionFromResult(results));
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
		
		return championList;
	}
	
	/**
	 * Gets the top 10 best champions for the specified user to fight against
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<Champions> getWorstChampionsToFightAgainst(Users user) throws SQLException {
		List<Champions> championList = new ArrayList<Champions>();
		
		// TODO insert actual query
		String selectChampion = "SELECT * FROM ("
				+ "SELECT MIN(attack) as minAttack, MAX(attack) as maxAttack,"
				+ "MIN(defense) as minDefense, MAX(defense) as maxDefense,"
				+ "MIN(magic) as minMagic, MAX(magic) as maxMagic,"
				+ "MIN(difficulty) as minDifficulty, MAX(difficulty) as maxDifficulty,"
				+ "MIN(hp) as minHp, MAX(hp) as maxHp,"
				+ "MIN(hpPerLevel) as minHpPerLevel, MAX(hpPerLevel) as maxHpPerLevel,"
				+ "MIN(mp) as minMp, MAX(mp) as maxMp,"
				+ "MIN(mpPerLevel) as minMpPerLevel, MAX(mpPerLevel) as maxMpPerLevel,"
				+ "MIN(moveSpeed) as minMoveSpeed, MAX(moveSpeed) as maxMoveSpeed,"
				+ "MIN(armor) as minArmor, MAX(armor) as maxArmor,"
				+ "MIN(armorPerLevel) as minArmorPerLevel, MAX(armorPerLevel) as maxArmorPerLevel,"
				+ "MIN(spellBlock) as minSpellBlock, MAX(spellBlock) as maxSpellBlock,"
				+ "MIN(spellBlockPerLevel) as minSpellBlockPerLevel, MAX(spellBlockPerLevel) as maxSpellBlockPerLevel,"
				+ "MIN(attackRange) as minAttackRange, MAX(attackRange) as maxAttackRange,"
				+ "MIN(hpRegen) as minHpRegen, MAX(hpRegen) as maxHpRegen,"
				+ "MIN(hpRegenPerLevel) as minHpRegenPerLevel, MAX(hpRegenPerLevel) as maxHpRegenPerLevel,"
				+ "MIN(mpRegen) as minMpRegen, MAX(mpRegen) as maxMpRegen,"
				+ "MIN(mpRegenPerLevel) as minMpRegenPerLevel, MAX(mpRegenPerLevel) as maxMpRegenPerLevel,"
				+ "MIN(attackDamage) as minAttackDamage, MAX(attackDamage) as maxAttackDamage,"
				+ "MIN(attackDamagePerLevel) as minAttackDamagePerLevel, MAX(attackDamagePerLevel) as maxAttackDamagePerLevel,"
				+ "MIN(attackSpeed) as minAttackSpeed, MAX(attackSpeed) as maxAttackSpeed,"
				+ "MIN(attackSpeedPerLevel) as minAttackSpeedPerLevel, MAX(attackSpeedPerLevel) as maxAttackSpeedPerLevel "
				+ "FROM Champions) as t "
				+ "CROSS JOIN Champions ORDER BY name DESC LIMIT 10;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			// TODO uncomment when there's a parameter in the query to filter against
			// selectStmt.setString(1, user.getUsername());
			results = selectStmt.executeQuery();
			while(results.next()) {
				championList.add(parseChampionFromResult(results));
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
		
		return championList;
	}
	
	/**
	 * Gets the top 10 best champions for the specified champion to fight against
	 * @param champion
	 * @return
	 * @throws SQLException
	 */
	public List<Champions> getBestChampionsToFightAgainst(Champions champion) throws SQLException {
		List<Champions> championList = new ArrayList<Champions>();
		
		// TODO insert actual query
		String selectChampion = "SELECT * FROM ("
				+ "SELECT MIN(attack) as minAttack, MAX(attack) as maxAttack,"
				+ "MIN(defense) as minDefense, MAX(defense) as maxDefense,"
				+ "MIN(magic) as minMagic, MAX(magic) as maxMagic,"
				+ "MIN(difficulty) as minDifficulty, MAX(difficulty) as maxDifficulty,"
				+ "MIN(hp) as minHp, MAX(hp) as maxHp,"
				+ "MIN(hpPerLevel) as minHpPerLevel, MAX(hpPerLevel) as maxHpPerLevel,"
				+ "MIN(mp) as minMp, MAX(mp) as maxMp,"
				+ "MIN(mpPerLevel) as minMpPerLevel, MAX(mpPerLevel) as maxMpPerLevel,"
				+ "MIN(moveSpeed) as minMoveSpeed, MAX(moveSpeed) as maxMoveSpeed,"
				+ "MIN(armor) as minArmor, MAX(armor) as maxArmor,"
				+ "MIN(armorPerLevel) as minArmorPerLevel, MAX(armorPerLevel) as maxArmorPerLevel,"
				+ "MIN(spellBlock) as minSpellBlock, MAX(spellBlock) as maxSpellBlock,"
				+ "MIN(spellBlockPerLevel) as minSpellBlockPerLevel, MAX(spellBlockPerLevel) as maxSpellBlockPerLevel,"
				+ "MIN(attackRange) as minAttackRange, MAX(attackRange) as maxAttackRange,"
				+ "MIN(hpRegen) as minHpRegen, MAX(hpRegen) as maxHpRegen,"
				+ "MIN(hpRegenPerLevel) as minHpRegenPerLevel, MAX(hpRegenPerLevel) as maxHpRegenPerLevel,"
				+ "MIN(mpRegen) as minMpRegen, MAX(mpRegen) as maxMpRegen,"
				+ "MIN(mpRegenPerLevel) as minMpRegenPerLevel, MAX(mpRegenPerLevel) as maxMpRegenPerLevel,"
				+ "MIN(attackDamage) as minAttackDamage, MAX(attackDamage) as maxAttackDamage,"
				+ "MIN(attackDamagePerLevel) as minAttackDamagePerLevel, MAX(attackDamagePerLevel) as maxAttackDamagePerLevel,"
				+ "MIN(attackSpeed) as minAttackSpeed, MAX(attackSpeed) as maxAttackSpeed,"
				+ "MIN(attackSpeedPerLevel) as minAttackSpeedPerLevel, MAX(attackSpeedPerLevel) as maxAttackSpeedPerLevel "
				+ "FROM Champions) as t "
				+ "CROSS JOIN Champions LIMIT 10;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			// TODO uncomment when there's a parameter in the query to filter against
			// selectStmt.setString(1, champion.getChampionId());
			results = selectStmt.executeQuery();
			while(results.next()) {
				championList.add(parseChampionFromResult(results));
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
		
		return championList;
	}
	
	/**
	 * Gets the top 10 worst champions for the specified champion to fight against
	 * @param champion
	 * @return
	 * @throws SQLException
	 */
	public List<Champions> getWorstChampionsToFightAgainst(Champions champion) throws SQLException {
		List<Champions> championList = new ArrayList<Champions>();
		
		// TODO insert actual query
		String selectChampion = "SELECT * FROM ("
				+ "SELECT MIN(attack) as minAttack, MAX(attack) as maxAttack,"
				+ "MIN(defense) as minDefense, MAX(defense) as maxDefense,"
				+ "MIN(magic) as minMagic, MAX(magic) as maxMagic,"
				+ "MIN(difficulty) as minDifficulty, MAX(difficulty) as maxDifficulty,"
				+ "MIN(hp) as minHp, MAX(hp) as maxHp,"
				+ "MIN(hpPerLevel) as minHpPerLevel, MAX(hpPerLevel) as maxHpPerLevel,"
				+ "MIN(mp) as minMp, MAX(mp) as maxMp,"
				+ "MIN(mpPerLevel) as minMpPerLevel, MAX(mpPerLevel) as maxMpPerLevel,"
				+ "MIN(moveSpeed) as minMoveSpeed, MAX(moveSpeed) as maxMoveSpeed,"
				+ "MIN(armor) as minArmor, MAX(armor) as maxArmor,"
				+ "MIN(armorPerLevel) as minArmorPerLevel, MAX(armorPerLevel) as maxArmorPerLevel,"
				+ "MIN(spellBlock) as minSpellBlock, MAX(spellBlock) as maxSpellBlock,"
				+ "MIN(spellBlockPerLevel) as minSpellBlockPerLevel, MAX(spellBlockPerLevel) as maxSpellBlockPerLevel,"
				+ "MIN(attackRange) as minAttackRange, MAX(attackRange) as maxAttackRange,"
				+ "MIN(hpRegen) as minHpRegen, MAX(hpRegen) as maxHpRegen,"
				+ "MIN(hpRegenPerLevel) as minHpRegenPerLevel, MAX(hpRegenPerLevel) as maxHpRegenPerLevel,"
				+ "MIN(mpRegen) as minMpRegen, MAX(mpRegen) as maxMpRegen,"
				+ "MIN(mpRegenPerLevel) as minMpRegenPerLevel, MAX(mpRegenPerLevel) as maxMpRegenPerLevel,"
				+ "MIN(attackDamage) as minAttackDamage, MAX(attackDamage) as maxAttackDamage,"
				+ "MIN(attackDamagePerLevel) as minAttackDamagePerLevel, MAX(attackDamagePerLevel) as maxAttackDamagePerLevel,"
				+ "MIN(attackSpeed) as minAttackSpeed, MAX(attackSpeed) as maxAttackSpeed,"
				+ "MIN(attackSpeedPerLevel) as minAttackSpeedPerLevel, MAX(attackSpeedPerLevel) as maxAttackSpeedPerLevel "
				+ "FROM Champions) as t "
				+ "CROSS JOIN Champions ORDER BY name DESC LIMIT 10;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectChampion);
			// TODO uncomment when there's a parameter in the query to filter against
			// selectStmt.setString(1, champion.getChampionId());
			results = selectStmt.executeQuery();
			while(results.next()) {
				championList.add(parseChampionFromResult(results));
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
		
		return championList;
	}
}
