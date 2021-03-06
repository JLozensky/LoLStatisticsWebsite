package lol.tools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lol.model.Game;
import lol.model.Summoner;
import lol.model.SummonerStats;
import lol.model.TeamStats;
import lol.dal.*;

public class Inserter {
  public static void main(String[] args) throws IOException, SQLException {
    // DAO instances
    GameDao gameDao = GameDao.getInstance();
    TeamStatsDao teamStatsDao = TeamStatsDao.getInstance();
    SummonerDao summonerDao = SummonerDao.getInstance();
    SummonerStatsDao summonerStatsDao = SummonerStatsDao.getInstance();
    ConnectionManager connectionMgr1 = new ConnectionManager();
    Connection connection1 = null;
    ConnectionManager connectionMgr2 = new ConnectionManager();
    Connection connection2 = null;
    ConnectionManager connectionMgr3 = new ConnectionManager();
    Connection connection3 = null;    
    ConnectionManager connectionMgr4 = new ConnectionManager();
    Connection connection4 = null;    
    

    String path = ""; // path to files here
    PathReader fr = new PathReader();
    // Obtain a list of file path
    List<File> fileList = fr.pathReader(path);
    JSONParser jsonParser = new JSONParser();
    int counter = 0;
    try {
      connection1 = connectionMgr1.getConnection();
      connection2 = connectionMgr2.getConnection();
      connection3 = connectionMgr3.getConnection();
      connection4 = connectionMgr4.getConnection();
      for (File f : fileList) {
        if(f.getPath().equals("")) { // same path here
          continue;
        }
        // Initialization
        List<Team> teamList = new ArrayList<>();
        List<Summoner> summonerList = new ArrayList<>();
        
        // Parse the json file to JSONObject
        JSONObject matchObject = (JSONObject) jsonParser
                .parse(new FileReader(f.getPath()));
        /*
        Game insertion
         */
        String gameId = matchObject.get("gameId") == null ? null : String.valueOf(matchObject.get("gameId"));
        String date = matchObject.get("gameCreation") == null ? null : String.valueOf(matchObject.get("gameCreation"));
        System.out.println(date);
        int gameDuration = matchObject.get("gameDuration") == null ? null : ((Long) matchObject.get("gameDuration")).intValue();
        int queueId = matchObject.get("queueId") == null ? 0 : ((Long) matchObject.get("queueId")).intValue();
        int mapId = matchObject.get("mapId") == null ? 0 : ((Long) matchObject.get("mapId")).intValue();
        int seasonId = matchObject.get("seasonId") == null ? 0 : ((Long) matchObject.get("seasonId")).intValue();
        String gameVersion = matchObject.get("gameVersion") == null ? null : String.valueOf(matchObject.get("gameVersion"));
        String gameMode = matchObject.get("gameMode") == null ? null : String.valueOf(matchObject.get("gameMode"));
        String gameType = matchObject.get("gameType") == null ? null : String.valueOf(matchObject.get("gameType"));

        Game game = new Game(gameId, date, gameDuration, queueId, mapId, seasonId, gameVersion,
                gameMode, gameType);
        game = gameDao.create(game, connection1);
        
        
        /*
        Team insertion
         */
        JSONArray teams = (JSONArray) matchObject.get("teams");
        /* Use a iterator to parse JSONArray */
        Iterator<JSONObject> teamIterator = teams.iterator();
        while (teamIterator.hasNext()) {
          JSONObject team = teamIterator.next();
          long teamId = team.get("teamId") == null ? 0 : (long) team.get("teamId");
          String teamStatsId = gameId + teamId;
          String win = team.get("win") == null ? null : String.valueOf(team.get("win"));
          boolean firstBlood = team.get("firstBlood") != null && (boolean) team.get("firstBlood");
          boolean firstTower = team.get("firstTower") != null && (boolean) team.get("firstTower");
          boolean firstInhibitor = team.get("firstInhibitor") != null && (boolean) team.get("firstInhibitor");
          boolean firstBaron = team.get("firstBaron") != null && (boolean) team.get("firstBaron");
          boolean firstDragon = team.get("firstDragon") != null && (boolean) team.get("firstDragon");
          boolean firstRiftHerald = team.get("firstRiftHerald") != null && (boolean) team.get("firstRiftHerald");
          int towerKills = team.get("towerKills") == null ? 0 : ((Long) team.get("towerKills")).intValue();
          int inhibitorKills = team.get("inhibitorKills") == null ? 0 : ((Long) team.get("inhibitorKills")).intValue();
          int baronKills = team.get("baronKills") == null ? 0 : ((Long) team.get("baronKills")).intValue();
          int dragonKills = team.get("dragonKills") == null ? 0 : ((Long) team.get("dragonKills")).intValue();
          int vilemawKills = team.get("vilemawKills") == null ? 0 : ((Long) team.get("vilemawKills")).intValue();
          int riftHeraldKills = team.get("riftHeraldKills") == null ? 0 :  ((Long) team.get("riftHeraldKills")).intValue();
          int dominionVictoryScore = team.get("dominionVictoryScore") == null ? 0 : ((Long) team.get("dominionVictoryScore")).intValue();
          
          JSONArray bans = (JSONArray) team.get("bans");
          Iterator<JSONObject> banIterator = bans.iterator();
          int banOne = banIterator.hasNext()
                  ? ((Long) banIterator.next().get("championId")).intValue() : 0;
          int banTwo = banIterator.hasNext()
                  ? ((Long) banIterator.next().get("championId")).intValue() : 0;
          int banThree = banIterator.hasNext()
                  ? ((Long) banIterator.next().get("championId")).intValue() : 0;
          int banFour = banIterator.hasNext()
                  ? ((Long) banIterator.next().get("championId")).intValue() : 0;
          int banFive = banIterator.hasNext()
                  ? ((Long) banIterator.next().get("championId")).intValue() : 0;

          TeamStats teamStats = new TeamStats(teamStatsId, win, firstBlood, firstTower, firstInhibitor,
                  firstBaron, firstDragon, firstRiftHerald, towerKills, inhibitorKills, baronKills,
                  dragonKills, vilemawKills, riftHeraldKills, dominionVictoryScore, banOne, banTwo,
                  banThree, banFour, banFive, game);
          teamStats = teamDao.create(teamStats, connection2);
          
          // store teamStats of team0 and team1 in a list
          teamList.add(teamStats);     
        }
        
        
        /*
        Summoner insertion 
         */
        JSONArray Summoners = (JSONArray) matchObject.get("participantIdentities");
        Iterator<JSONObject> summonerIterator = Summoners.iterator();
        int index = 0;    // count index of summoner
        
        while (summonerIterator.hasNext()) {
          Summoner summoner;
          JSONObject player = (JSONObject) summonerIterator.next().get("player");
          String accountId = player.get("accountId") == null ? null : String.valueOf(player.get("accountId"));
          String summonerName = player.get("summonerName") == null ? null : String.valueOf(player.get("summonerName"));
          String currentPlatformId = player.get("currentPlatformId") == null ? null : String.valueOf(player.get("currentPlatformId"));
          String summonerId = player.get("summonerId") == null ? null : String.valueOf(player.get("summonerId"));
          String matchHistoryUri = player.get("matchHistoryUri") == null ? null : String.valueOf(player.get("matchHistoryUri"));
          int profileIcon = player.get("profileIcon") == null ? 0 : ((Long) player.get("profileIcon")).intValue();


          summoner = new Summoner(accountId, summonerName, currentPlatformId, summonerId, matchHistoryUri, 
                  profileIcon);

          summoner = summonerDao.create(summoner, connection3);
          summonerList.add(summoner);
          index++;

        }
        

        /*
        SummonerStats insertion
         */
        index = 0;
        JSONArray participants = (JSONArray) matchObject.get("participants");
        Iterator<JSONObject> participantIterator = participants.iterator();

        while (participantIterator.hasNext()) {
          JSONObject participant = participantIterator.next();
          String participantId = String.valueOf(participant.get("participantId"));
          String summonerStatsId = participantId + gameId;
          int championId = participant.get("championId") == null ? 0 : ((Long) participant.get("championId")).intValue();
          int spell1Id = participant.get("spell1Id") == null ? 0 : ((Long) participant.get("spell1Id")).intValue();
          int spell2Id = participant.get("spell2Id") == null ? 0 : ((Long) participant.get("spell2Id")).intValue();
          
          if (participant.get("stats") == null) {
            System.out.println(f.getPath());
          }
          JSONObject stats = (JSONObject) participant.get("stats");
          int itemId0 = stats.get("item0") == null ? 0 : ((Long) stats.get("item0")).intValue();
          int itemId1 = stats.get("item1") == null ? 0 : ((Long) stats.get("item1")).intValue();
          int itemId2 = stats.get("item2") == null ? 0 : ((Long) stats.get("item2")).intValue();
          int itemId3 = stats.get("item3") == null ? 0 : ((Long) stats.get("item3")).intValue();
          int itemId4 = stats.get("item4") == null ? 0 : ((Long) stats.get("item4")).intValue();
          int itemId5 = stats.get("item5") == null ? 0 : ((Long) stats.get("item5")).intValue();
          int itemId6 = stats.get("item6") == null ? 0 : ((Long) stats.get("item6")).intValue();
          int kills = stats.get("kills") == null ? 0 : ((Long) stats.get("kills")).intValue();
          int deaths =  stats.get("deaths") == null ? 0 : ((Long) stats.get("deaths")).intValue();
          int assists = stats.get("assists") == null ? 0 : ((Long) stats.get("assists")).intValue();
          long totalDamageDealt = stats.get("totalDamageDealt") == null ? 0 : (long) stats.get("totalDamageDealt");
          long magicDamageDealt = stats.get("magicDamageDealt") == null ? 0 : (long) stats.get("magicDamageDealt");
          long physicalDamageDealt = stats.get("physicalDamageDealt") == null ? 0 : (long) stats.get("physicalDamageDealt");
          long trueDamageDealt =  stats.get("trueDamageDealt") == null ? 0 : (long) stats.get("trueDamageDealt");
          long largestCriticalStrike =  stats.get("largestCriticalStrike") == null ? 0 : (long) stats.get("largestCriticalStrike");
          long totalDamageDealtToChampions =  stats.get("totalDamageDealtToChampions") == null ? 0 : (long) stats.get("totalDamageDealtToChampions");
          long magicDamageDealtToChampions =  stats.get("magicDamageDealtToChampions") == null ? 0 : (long) stats.get("magicDamageDealtToChampions");
          long physicalDamageDealtToChampions =  stats.get("physicalDamageDealtToChampions") == null ? 0 : (long) stats.get("physicalDamageDealtToChampions");
          long trueDamageDealtToChampions =  stats.get("trueDamageDealtToChampions") == null ? 0 : (long) stats.get("trueDamageDealtToChampions");
          long totalHeal =  stats.get("totalHeal") == null ? 0 : (long) stats.get("totalHeal");
          long totalUnitsHealed =  stats.get("totalUnitsHealed") == null ? 0 : (long) stats.get("totalUnitsHealed");
          long damageSelfMitigated =  stats.get("damageSelfMitigated") == null ? 0 : (long) stats.get("damageSelfMitigated");
          long damageDealtToObjectives =  stats.get("damageDealtToObjectives") == null ? 0 : (long) stats.get("damageDealtToObjectives");
          long damageDealtToTurrets =  stats.get("damageDealtToTurrets") == null ? 0 : (long) stats.get("damageDealtToTurrets");
          long visionScore =  stats.get("visionScore") == null ? 0 : (long) stats.get("visionScore");
          long timeCCingOthers =  stats.get("timeCCingOthers") == null ? 0 : (long) stats.get("timeCCingOthers");
          long totalDamageTaken =  stats.get("totalDamageTaken") == null ? 0 : (long) stats.get("totalDamageTaken");
          long magicalDamageTaken =  stats.get("magicalDamageTaken") == null ? 0 : (long) stats.get("magicalDamageTaken");
          long physicalDamageTaken =  stats.get("physicalDamageTaken") == null ? 0 : (long) stats.get("physicalDamageTaken");
          long trueDamageTaken =  stats.get("trueDamageTaken") == null ? 0 : (long) stats.get("trueDamageTaken");
          long goldEarned =  stats.get("goldEarned") == null ? 0 : (long) stats.get("goldEarned");
          long goldSpent =  stats.get("goldSpent") == null ? 0 : (long) stats.get("goldSpent");
          int turretKills =  stats.get("turretKills") == null ? 0 : ((Long) stats.get("turretKills")).intValue();
          long totalMinionsKilled =  stats.get("totalMinionsKilled") == null ? 0 : (long) stats.get("totalMinionsKilled");
          long neutralMinionsKilled =  stats.get("neutralMinionsKilled") == null ? 0 : (long) stats.get("neutralMinionsKilled");
          long neutralMinionsKilledTeamJungle = stats.get("neutralMinionsKilledTeamJungle") 
                  == null ? 0 : (long)stats.get("neutralMinionsKilledTeamJungle");
          long neutralMinionsKilledEnemyJungle = stats.get("neutralMinionsKilledEnemyJungle")
                  == null ? 0 : (long)stats.get("neutralMinionsKilledEnemyJungle");;
          long totalTimeCrowdControlDealt = (long) stats.get("totalTimeCrowdControlDealt");
          int champLevel = ((Long) stats.get("champLevel")).intValue();
          int visionWardsBoughtInGame = ((Long) stats.get("visionWardsBoughtInGame")).intValue();
          int sightWardsBoughtInGame = ((Long) stats.get("sightWardsBoughtInGame")).intValue();
          int wardsPlaced = stats.get("wardsPlaced") == null ? 0 : ((Long) stats.get("wardsPlaced")).intValue();
          int wardsKilled =  stats.get("wardsKilled") == null ? 0 : ((Long) stats.get("wardsKilled")).intValue();
          boolean firstBloodKill = stats.get("firstBloodKill") != null && (boolean) stats.get("firstBloodKill");
          boolean firstBloodAssist = stats.get("firstBloodAssist") != null && (boolean) stats.get("firstBloodAssist");
          boolean firstTowerKill = stats.get("firstTowerKill") != null && (boolean) stats.get("firstTowerKill");
          boolean firstTowerAssist = stats.get("firstTowerAssist") != null && (boolean) stats.get("firstTowerAssist");
          boolean firstInhibitorKill = stats.get("firstInhibitorKill") != null && (boolean) stats.get("firstInhibitorKill");
          boolean firstInhibitorAssist = stats.get("firstInhibitorAssist") != null && (boolean) stats.get("firstInhibitorAssist");
          int combatPlayerScore = ((Long) stats.get("combatPlayerScore")).intValue();
          int objectivePlayerScore = ((Long) stats.get("objectivePlayerScore")).intValue();
          int totalPlayerScore = ((Long) stats.get("totalPlayerScore")).intValue();
          int totalScoreRank = ((Long) stats.get("totalScoreRank")).intValue();
          String role = String.valueOf(stats.get("role"));
          String lane = String.valueOf(stats.get("lane"));
          JSONArray runes = (JSONArray) participant.get("runes");
          int runeId0 = 0, runeId1 = 0, runeId2 = 0, runeId3 = 0, runeId4 = 0, runeId5 = 0;
          if (runes != null) {
            Iterator<JSONObject> rune = runes.iterator();
            runeId0 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
            runeId1 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
            runeId2 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
            runeId3 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
            runeId4 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
            runeId5 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
          }           
          String highestAchievedSeasonTier = String.valueOf(participant.get("highestAchievedSeasonTier"));
          
          SummonerStats summonerStats = new SummonerStats(summonerStatsId, championId, spell1Id, spell2Id, 
                  itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, kills, deaths, assists, 
                  totalDamageDealt, magicDamageDealt,  physicalDamageDealt, trueDamageDealt, 
                  largestCriticalStrike, totalDamageDealtToChampions, magicDamageDealtToChampions, 
                  physicalDamageDealtToChampions, trueDamageDealtToChampions, totalHeal, totalUnitsHealed, 
                  damageSelfMitigated,  damageDealtToObjectives, damageDealtToTurrets,  visionScore, 
                  timeCCingOthers,  totalDamageTaken, magicalDamageTaken, physicalDamageTaken, 
                  trueDamageTaken, goldEarned, goldSpent, turretKills, totalMinionsKilled, 
                  neutralMinionsKilled, neutralMinionsKilledTeamJungle,  neutralMinionsKilledEnemyJungle, 
                  totalTimeCrowdControlDealt, champLevel, visionWardsBoughtInGame, sightWardsBoughtInGame, 
                  wardsPlaced,  wardsKilled, firstBloodKill, firstBloodAssist, firstTowerKill, 
                  firstTowerAssist, firstInhibitorKill,  firstInhibitorAssist, combatPlayerScore, 
                  objectivePlayerScore, totalPlayerScore, totalScoreRank, role, lane, runeId0, 
                  runeId1, runeId2, runeId3, runeId4, runeId5, highestAchievedSeasonTier, summonerList.get(index));
          summonerStats = summonerStatsDao.create(summonerStats, connection4);
          index++;
        }
        counter++;
        System.out.println((double) counter / fileList.size() * 100 + "%\n" + counter); 
        }
      
    } catch (ParseException | IOException | SQLException e) {
      e.printStackTrace();
    } finally {
    	if (connection1 != null) {
	        connection1.close();
	      }
    	if (connection2 != null) {
	        connection2.close();
	      }
    	if (connection3 != null) {
	        connection3.close();
	      }
    	if (connection4 != null) {
	        connection4.close();
	      }
    }
  }
}
