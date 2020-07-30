package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		String insertUser = "INSERT INTO Users(userName,userPassword,email,accountId,firstName,lastName) VALUES(?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);
			insertStmt.setString(1, users.getUsername());
			insertStmt.setString(2, users.getPassword());
			insertStmt.setString(3, users.getEmail());
			insertStmt.setString(4, users.getSummoner().getAccountId());
			insertStmt.setString(5, users.getFirstName());
			insertStmt.setString(6, users.getLastName());
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
	
	public Users updateSummoner(Users user, Summoner summoner) throws SQLException {
		String updateUser = "UPDATE Users SET accountId=? WHERE userName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  summoner.getAccountId());
			updateStmt.setString(2,  user.getUsername());
			updateStmt.executeUpdate();
			
			user.setSummoner(summoner);
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
		String updateUser = "UPDATE Users SET firstName=? WHERE userName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newFirstName);
			updateStmt.setString(2,  user.getUsername());
			updateStmt.executeUpdate();
			
			user.setFirstName(newFirstName);
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
		String updateUser = "UPDATE Users SET lastName=? WHERE userName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newLastName);
			updateStmt.setString(2,  user.getUsername());
			updateStmt.executeUpdate();
			
			user.setLastName(newLastName);
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
	
	public Users updateEmail(Users user, String newEmail) throws SQLException {
		String updateUser = "UPDATE Users SET email=? WHERE userName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newEmail);
			updateStmt.setString(2,  user.getUsername());
			updateStmt.executeUpdate();
			
			user.setEmail(newEmail);
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
	
	public Users updatePassword(Users user, String newPassword) throws SQLException {
		String updateUser = "UPDATE Users SET userPassword=? WHERE userName=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateUser);
			updateStmt.setString(1,  newPassword);
			updateStmt.setString(2,  user.getUsername());
			updateStmt.executeUpdate();
			
			user.setPassword(newPassword);
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
		
		String deleteUser = "DELETE FROM Users WHERE userName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1,  user.getUsername());
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
	
	public Users getUserFromSummoner(Summoner summoner) throws SQLException {
		
		String selectUser = "SELECT * FROM Users WHERE accountId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, summoner.getAccountId());
			results = selectStmt.executeQuery();
			if(results.next()) {
				String username = results.getString("userName");
				String password = results.getString("userPassword");
				String email = results.getString("email");
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				Users user = new Users(summoner, username, password, firstName, lastName, email);
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
	
	public Users getUserFromUserName(String userName) throws SQLException {
		
		String selectUser = "SELECT * FROM Users WHERE userName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		SummonerDao summonerDao = new SummonerDao();
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String accountId = results.getString("accountId");
				String username = results.getString("userName");
				String password = results.getString("userPassword");
				String email = results.getString("email");
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				Summoner summoner = summonerDao.getSummonerFromAccountId(accountId);
				Users user = new Users(summoner, username, password, firstName, lastName, email);
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
			
			if(results.next()) {
				String id = results.getString("accountId");
				String resultSummonerName = results.getString("summonerName");
				String currentPlatformId = results.getString("currentPlatformId");
				String matchHistoryUri = results.getString("matchHistoryUri");
				int profileIcon = results.getInt("profileIcon");

				return new Summoner(id, resultSummonerName, currentPlatformId, 
						matchHistoryUri, profileIcon);
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
