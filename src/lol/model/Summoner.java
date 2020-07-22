package lol.model;

public class Summoner {
	private String accountId;
	private String summonerName;
	private String currentPlatformId;
	private String matchHistoryUri;
	private int profileIcon;
	private TeamStats teamStats;
	
	public Summoner(String accountId, String summonerName, String currentPlatformId, String matchHistoryUri, 
									int profileIcon, TeamStats teamStats) {
		this.accountId = accountId;
		this.summonerName = summonerName;
		this.currentPlatformId = currentPlatformId;
		this.matchHistoryUri = matchHistoryUri;
		this.profileIcon = profileIcon;
		this.teamStats = teamStats;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getCurrentPlatformId() {
		return currentPlatformId;
	}

	public void setCurrentPlatformId(String currentPlatformId) {
		this.currentPlatformId = currentPlatformId;
	}

	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}

	public void setMatchHistoryUri(String matchHistoryUri) {
		this.matchHistoryUri = matchHistoryUri;
	}

	public int getProfileIcon() {
		return profileIcon;
	}

	public void setProfileIcon(int profileIcon) {
		this.profileIcon = profileIcon;
	}

	public TeamStats getTeamStats() {
		return teamStats;
	}

	public void setTeamStats(TeamStats teamStats) {
		this.teamStats = teamStats;
	}
}
