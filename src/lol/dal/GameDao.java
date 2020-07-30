package lol.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lol.model.Game;

public class GameDao {
  protected ConnectionManager connectionManager;

  private static GameDao instance = null;

  protected GameDao() {
    connectionManager = new ConnectionManager();
  }

  public static GameDao getInstance() {
    if (instance == null) {
      instance = new GameDao();
    }
    return instance;
  }

  public Game create(Game game)
          throws SQLException {
    String insertGame = "INSERT IGNORE INTO Game(gameId, date, gameDuration, queueId, mapId, seasonId, " +
            "gameVersion, gameMode, gameType) " +
            "VALUES (?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertGame);
      insertStmt.setString(1, game.getGameId());
      insertStmt.setString(2, game.getDate());
      insertStmt.setInt(3, game.getGameDuration());
      insertStmt.setInt(4, game.getQueueId());
      insertStmt.setInt(5, game.getMapId());
      insertStmt.setInt(6, game.getSeasonId());
      insertStmt.setString(7, game.getGameVersion());
      insertStmt.setString(8, game.getGameMode());
      insertStmt.setString(9, game.getGameType());
      insertStmt.setString(9, game.getGameType());
      
      insertStmt.executeUpdate();

      return game;
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
  
  
  public Game delete(Game game) throws SQLException {
    String deleteGame = "DELETE FROM Game WHERE gameId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteGame);
      deleteStmt.setString(1, game.getGameId());
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

  public Game getGameById(String gameId)
          throws SQLException {
    String selectGame = "SELECT gameId, date, gameDuration, queueId, mapId, seasonId, gameVersion, " +
            "gameMode, gameType FROM Game WHERE gameId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectGame);
      selectStmt.setString(1, gameId);
      results = selectStmt.executeQuery();
      
      if (results.next()) {
        String resultGameId = results.getString("gameId");
        String date = results.getString("date");
        int gameDuration = results.getInt("gameDuration");
        int queueId = results.getInt("queueId");
        int mapId = results.getInt("mapId");
        int seasonId = results.getInt("seasonId");
        String gameVersion = results.getString("gameVersion");
        String gameMode = results.getString("gameMode");
        String gameType = results.getString("gameType");
        
        return new Game(resultGameId, date, gameDuration, queueId, mapId, seasonId, gameVersion,
                gameMode, gameType);
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

