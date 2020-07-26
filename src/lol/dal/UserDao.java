package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lol.model.*;

public class UserDao {
	
	private static UserDao instance = null;
	protected ConnectionManager connectionManager;
	
	protected UserDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	public Users create(Users users) throws SQLException {
		
		String insertUser = "INSERT INTO Users(summonerName,firstName,lastName) VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);
			insertStmt.setString(1, users.getSummonerName());
			insertStmt.setString(2, users.getFirstName());
			insertStmt.setString(3, users.getLastName());
			insertStmt.executeUpdate();
			return users;
			
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
	
	public Users updateSummonerName(Users user, String newSummonerName) throws SQLException {
		String updateUser = "UPDATE Users SET summonerName=? WHERE summonerName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newSummonerName);
			updateStmt.setString(2,  user.getSummonerName());
			updateStmt.executeUpdate();
			
			user.setSummonerName(newSummonerName);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public Users updateFirstName(Users user, String newFirstName) throws SQLException {
		String updateUser = "UPDATE Users SET firstName=? WHERE summonerName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newFirstName);
			updateStmt.setString(2,  user.getSummonerName());
			updateStmt.executeUpdate();
			
			user.setSummonerName(newFirstName);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public Users updateLastName(Users user, String newLastName) throws SQLException {
		String updateUser = "UPDATE Users SET lastName=? WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newLastName);
			updateStmt.setString(2,  user.getSummonerName());
			updateStmt.executeUpdate();
			
			user.setSummonerName(newLastName);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public Users delete(Users user) throws SQLException {
		
		String deleteUser = "DELETE FROM Users WHERE summonerName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1,  user.getSummonerName());
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
	
	public Users getUserFromSummonerName(String summonerName) throws SQLException {
		
		String selectUser = "SELECT summonerName,firstName,lastName FROM Users WHERE summonerName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, summonerName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultSummonerName = results.getString("summonerName");
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				Users user = new Users(resultSummonerName, firstName, lastName);
				return user;
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
	
	public Summoner getUserDetail(String summonerName) throws SQLException {
		
		String selectUser = "SELECT * FROM Summoner WHERE summonerName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, summonerName);
			results = selectStmt.executeQuery();
			TeamStatsDao teamStatsDao = TeamStatsDao.getInstance();
			
			if(results.next()) {
				String id = results.getString("accountId");
				String resultSummonerName = results.getString("summonerName");
				String currentPlatformId = results.getString("currentPlatformId");
				String matchHistoryUri = results.getString("matchHistoryUri");
				int profileIcon = results.getInt("profileIcon");
				String teamStatsId = results.getString("teamStatsId");
				TeamStats teamStats = teamStatsDao.getTeamStatsFromStatsId(teamStatsId);

				return new Summoner(id, resultSummonerName, currentPlatformId, 
						matchHistoryUri, profileIcon, teamStats);
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
