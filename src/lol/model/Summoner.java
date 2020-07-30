package lol.model;

public class Summoner {
	private String accountId;
	private String summonerName;
	private String currentPlatformId;
	private String matchHistoryUri;
	private int profileIcon;
	private String summonerId;
	
	public Summoner(String accountId, String summonerName, String currentPlatformId, String summonerId, String matchHistoryUri, int profileIcon) {
			this.accountId = accountId;
			this.summonerName = summonerName;
			this.summonerId = summonerId;
			this.currentPlatformId = currentPlatformId;
			this.matchHistoryUri = matchHistoryUri;
			this.profileIcon = profileIcon;
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
	
	public String getSummonerId() {
		return this.summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
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
}
