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

import lol.model.ParticipantIdentity;
import lol.model.TeamStats;

public class Inserter {
  public static void main(String[] args) throws IOException {
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

        String gameId = String.valueOf(matchObject.get("gameId"));
        String date = String.valueOf(matchObject.get("date"));
        int gameDuration = ((Long) matchObject.get("gameDuration")).intValue();
        
        /*
        TeamStats insertion
         */
        JSONArray teams = (JSONArray) matchObject.get("teams");
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
         * ParticipantIdentity insertion 
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

          ParticipantIdentity participantIdentity = new ParticipantIdentity(accountId, summonerName,
                  summonerId, currentPlatformId, matchHistoryUri, profileIcon);
          
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
