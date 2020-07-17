package lol.tools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lol.model.Game;
import lol.model.ParticipantIdentity;
import lol.model.SummonerStats;
import lol.model.TeamStats;

public class Inserter {
  public static void main(String[] args) throws IOException {
    List<Game> gameList = new ArrayList<>();
     List<TeamStats> teamStatsList = new ArrayList<>();
     List<ParticipantIdentity> identityList = new ArrayList<>();
     
    String path = "/Users/calvinyin/Documents/CS5200/match_json";
    PathReader fr = new PathReader();
    
    // Obtain a list of file path
    List<File> fileList = fr.pathReader(path);
    JSONParser jsonParser = new JSONParser();
    
    int  count = 0;
    try {
      for (File f : fileList) {
        System.out.println(f.getPath());
        if(f.getPath().equals("/Users/calvinyin/Documents/CS5200/match_json/.DS_Store")) {
          continue;
        }
        // Parse the json file to JSONObject
        JSONObject matchObject = (JSONObject) jsonParser
                .parse(new FileReader(f.getPath()));

        /*
        Game insertion
         */
        String gameId = String.valueOf(matchObject.get("gameId"));
        String date = String.valueOf(matchObject.get("date"));
        int gameDuration = ((Long) matchObject.get("gameDuration")).intValue();
        int queueId = ((Long) matchObject.get("queueId")).intValue();
        int mapId = ((Long) matchObject.get("mapId")).intValue();
        int seasonId = ((Long) matchObject.get("seasonId")).intValue();
        String gameVersion = String.valueOf(matchObject.get("gameVersion"));
        String gameMode = String.valueOf(matchObject.get("gameMode"));
        String gameType = String.valueOf(matchObject.get("gameType"));
        
        Game game = new Game(gameId, date, gameDuration, queueId, mapId, seasonId, gameVersion, 
                gameMode, gameType);
        
        gameList.add(game);
        
        
        /*
        TeamStats insertion
         */
        JSONArray teams = (JSONArray) matchObject.get("teams");
        /* Use a iterator to parse JSONArray */
        Iterator<JSONObject> teamIterator = teams.iterator();
        while (teamIterator.hasNext()) {
          JSONObject team = teamIterator.next();
          long team0Id = (long) team.get("teamId");
          String teamStatsId = gameId + team0Id;
          String win = String.valueOf(team.get("win"));
          boolean firstBlood = (boolean) team.get("firstBlood");
          boolean firstTower = (boolean) team.get("firstTower");
          boolean firstInhibitor = (boolean) team.get("firstInhibitor");
          boolean firstBaron = (boolean) team.get("firstBaron");
          boolean firstDragon = (boolean) team.get("firstDragon");
          boolean firstRiftHerald = (boolean) team.get("firstRiftHerald");
          int towerKills = ((Long) team.get("towerKills")).intValue();
          int inhibitorKills = ((Long) team.get("inhibitorKills")).intValue();
          int baronKills = ((Long) team.get("baronKills")).intValue();
          int dragonKills = ((Long) team.get("dragonKills")).intValue();
          int vilemawKills = ((Long) team.get("vilemawKills")).intValue();
          int riftHeraldKills = ((Long) team.get("riftHeraldKills")).intValue();
          int dominionVictoryScore = ((Long) team.get("dominionVictoryScore")).intValue();
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
                  banThree, banFour, banFive);
          
          teamStatsList.add(teamStats);
        }

        /*
        SummonerStats insertion
         */
         JSONArray participants = (JSONArray) matchObject.get("participants");
        Iterator<JSONObject> participantIterator = participants.iterator();
        while (participantIterator.hasNext()) {
          JSONObject participant = participantIterator.next();
          int participantId = (int) participant.get("participantId");
          String summonerStatsId = participantId + gameId;
          int championId = ((Long) participant.get("championId")).intValue();
          int spell1Id = ((Long) participant.get("spell1Id")).intValue();
          int spell2Id = ((Long) participant.get("spell2Id")).intValue();

          JSONObject stats = (JSONObject) participant.get("stats");
          int itemId0 = ((Long) stats.get("item0")).intValue();
          int itemId1 = ((Long) stats.get("item1")).intValue();
          int itemId2 = ((Long) stats.get("item2")).intValue();
          int itemId3 = ((Long) stats.get("item3")).intValue();
          int itemId4 = ((Long) stats.get("item4")).intValue();
          int itemId5 = ((Long) stats.get("item5")).intValue();
          int itemId6 = ((Long) stats.get("item6")).intValue();
          int kills = ((Long) stats.get("kills")).intValue();
          int deaths = ((Long) stats.get("deaths")).intValue();
          int assists = ((Long) stats.get("assists")).intValue();
          long totalDamageDealt = (long) stats.get("totalDamageDealt");
          long magicDamageDealt = (long) stats.get("magicDamageDealt");
          long physicalDamageDealt = (long) stats.get("physicalDamageDealt");
          long trueDamageDealt = (long) stats.get("trueDamageDealt");
          long largestCriticalStrike = (long) stats.get("largestCriticalStrike");
          long totalDamageDealtToChampions = (long) stats.get("totalDamageDealtToChampions");
          long magicDamageDealtToChampions = (long) stats.get("magicDamageDealtToChampions");
          long physicalDamageDealtToChampions = (long) stats.get("physicalDamageDealtToChampions");
          long trueDamageDealtToChampions = (long) stats.get("trueDamageDealtToChampions");
          long totalHeal = (long) stats.get("totalHeal");
          long totalUnitHealed = (long) stats.get("totalUnitHealed");
          long damageSelfMitigated = (long) stats.get("damageSelfMitigated");
          long damageDealtToObjectives = (long) stats.get("damageDealtToObjectives");
          long damageDealtToTurrets = (long) stats.get("damageDealtToTurrets");
          long visionScore = (long) stats.get("visionScore");
          long timeCCingOthers = (long) stats.get("timeCCingOthers");
          long totalDamageTaken = (long) stats.get("totalDamageTaken");
          long magicDamageTaken = (long) stats.get("magicDamageTaken");
          long physicalDamageTaken = (long) stats.get("physicalDamageTaken");
          long trueDamageTaken = (long) stats.get("trueDamageTaken");
          long goldEarned = (long) stats.get("goldEarned");
          long goldSpent = (long) stats.get("goldSpent");
          int turretKills = ((Long) stats.get("turretKills")).intValue();
          long totalMinionsKilled = (long) stats.get("totalMinionsKilled");
          long neutralMinionsKilled = (long) stats.get("neutralMinionsKilled");
          long neutralMinionsKilledTeamJungle = (long) stats.get("neutralMinionsKilledTeamJungle");
          long neutralMinionsKilledEnemyJungle = (long) stats.get("neutralMinionsKilledEnemyJungle");
          long totalTimeCrowdControlDealt = (long) stats.get("totalTimeCrowdControlDealt");
          int champLevel = ((Long) stats.get("champLevel")).intValue();
          int visionWardsBoughtInGame = ((Long) stats.get("visionWardsBoughtInGame")).intValue();
          int sightWardsBoughtInGame = ((Long) stats.get("sightWardsBoughtInGame")).intValue();
          int wardsPlaced = ((Long) stats.get("wardsPlaced")).intValue();
          int wardsKilled = ((Long) stats.get("wardsKilled")).intValue();
          boolean firstBloodKill = (boolean) stats.get("firstBloodKill");
          boolean firstBloodAssist = (boolean) stats.get("firstBloodAssist");
          boolean firstTowerKill = (boolean) stats.get("firstTowerKill");
          boolean firstTowerKillAssist = (boolean) stats.get("firstTowerKillAssist");
          boolean firstInhibitor = (boolean) stats.get("firstInhibitor");
          boolean firstInhibitorAssist = (boolean) stats.get("firstInhibitorAssist");
          int combatPlayerScore = ((Long) stats.get("combatPlayerScore")).intValue();
          int objectivePlayerScore = ((Long) stats.get("objectivePlayerScore")).intValue();
          int totalPlayerScore = ((Long) stats.get("totalPlayerScore")).intValue();
          int totalScoreRank = ((Long) stats.get("totalScoreRank")).intValue();
          String role = String.valueOf(stats.get("role"));
          String lane = String.valueOf(stats.get("lane"));
          
          JSONArray runes = (JSONArray) participant.get("runes");
          Iterator<JSONObject> rune = runes.iterator();
          int runeId0 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
          int runeId1 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
          int runeId2 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
          int runeId3 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
          int runeId4 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;
          int runeId5 = rune.hasNext() ? ((Long) rune.next().get("runeId")).intValue() : 0;      
          String highestAchievedSeasonTier = String.valueOf(participant.get("highestAchievedSeasonTier"));
          
          SummonerStats summonerStats = new SummonerStats(summonerStatsId, championId, spell1Id, spell2Id, 
                  itemId0, itemId1, itemId2, itemId3, itemId4, itemId5, itemId6, kills, deaths, assists, 
                  totalDamageDealt, magicDamageDealt,  physicalDamageDealt, trueDamageDealt, 
                  largestCriticalStrike, totalDamageDealtToChampions, magicDamageDealtToChampions, 
                  physicalDamageDealtToChampions, trueDamageDealtToChampions, totalHeal, totalUnitHealed, 
                  damageSelfMitigated,  damageDealtToObjectives, damageDealtToTurrets,  visionScore, 
                  timeCCingOthers,  totalDamageTaken, magicDamageTaken, physicalDamageTaken, 
                  trueDamageTaken, goldEarned, goldSpent, turretKills, totalMinionsKilled, 
                  neutralMinionsKilled, neutralMinionsKilledTeamJungle,  neutralMinionsKilledEnemyJungle, 
                  totalTimeCrowdControlDealt,  champLevel,  visionWardsBoughtInGame,  sightWardsBoughtInGame, 
                  wardsPlaced,  wardsKilled,  firstBloodKill,  firstBloodAssist,  firstTowerKill, 
                  firstTowerKillAssist, firstInhibitor,  firstInhibitorAssist,  combatPlayerScore, 
                  objectivePlayerScore,  totalPlayerScore, totalScoreRank,  role, lane, 
                  runeId0, runeId1,  runeId2, runeId3, runeId4,  runeId5, highestAchievedSeasonTier);
          
          
        }
        /*
        ParticipantIdentity insertion 
         */
        JSONArray participantIdentities = (JSONArray) matchObject.get("participantIdentities");
        Iterator<JSONObject> identityIterator = participantIdentities.iterator();
        while (identityIterator.hasNext()) {
          JSONObject player = (JSONObject) identityIterator.next().get("player");
          String accountId = String.valueOf(player.get("accountId"));
          String summonerName = String.valueOf(player.get("summonerName"));
          String summonerId = String.valueOf(player.get("summonerId"));
          String currentPlatformId = String.valueOf(player.get("currentPlatformId"));
          String matchHistoryUri = String.valueOf(player.get("matchHistoryUri"));
          long profileIcon = (long) player.get("profileIcon");
          String participantIdentityId = gameId + summonerName;
          ParticipantIdentity participantIdentity = new ParticipantIdentity(participantIdentityId, 
                  accountId, summonerName, summonerId, currentPlatformId, matchHistoryUri, profileIcon);
          
          identityList.add(participantIdentity);
          count++;
        }
        
        System.out.println(count);
      }
    } catch (ParseException | IOException e) {
      e.printStackTrace();
    }
    for (TeamStats t : teamStatsList) {
      
    }
  }
}
