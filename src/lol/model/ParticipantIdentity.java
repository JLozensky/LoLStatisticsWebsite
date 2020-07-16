package lol.model;

public class ParticipantIdentity {

	private String accountId;
	private String summonerName;
	private String summonerId;
	private String currentPlatformId;
	private String matchHistoryUri;
	private long profileIcon;
	
	public ParticipantIdentity(String accountId, String summonerName, String summonerId, 
														 String currentPlatformId, String matchHistoryUri, long profileIcon) {
		this.accountId = accountId;
		this.summonerName = summonerName;
		this.summonerId = summonerId;
		this.currentPlatformId = currentPlatformId;
		this.matchHistoryUri = matchHistoryUri;
		this.profileIcon = profileIcon;
	}

	public ParticipantIdentity(String accountId) {
		this.accountId = accountId;
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

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
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


	public long getProfileIcon() {
		return profileIcon;
	}

	public void setProfileIcon(long profileIcon) {
		this.profileIcon = profileIcon;
	}
	
}
