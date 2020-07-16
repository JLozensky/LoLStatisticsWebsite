package lol.model;

public class ParticipantIdentity {


	private String accountId;
	private String firstName;
	private String lastName;
	private String player;
	private String summonerName;
	private String summonerId;
	private int currentPlatformId;
	private int currentAccountId;
	private String matchHistoryUri;
	private long profileIcon;
	

	public ParticipantIdentity(String accountId, String firstName, String lastName, String player, String summonerName,
			String summonerId, String currentPlatformId, String currentAccountId, String matchHistoryUri) {
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.player = player;
		this.summonerName = summonerName;
		this.summonerId = summonerId;
		this.currentPlatformId = currentPlatformId;
		this.matchHistoryUri = matchHistoryUri;
		this.profileIcon = profileIcon;
	}
	
	public ParticipantIdentity(String accountId, String firstName, String lastName) {
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public ParticipantIdentity(int accountId) {
		this.accountId = accountId;
	}


	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPlayer() {
		return player;
	}


	public void setPlayer(String player) {
		this.player = player;
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



	public String getCurrentAccountId() {
		return currentAccountId;
	}



	public void setCurrentAccountId(String currentAccountId) {
		this.currentAccountId = currentAccountId;
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
