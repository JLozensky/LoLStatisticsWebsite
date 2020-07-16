package lol.model;

public class ParticipantIdentity {

	private int accountId;
	private String firstName;
	private String lastName;
	private String player;
	private String summonerName;
	private String summonerId;
	private int currentPlatformId;
	private int currentAccountId;
	private String matchHistoryUri;
	
	public ParticipantIdentity(int accountId, String firstName, String lastName, String player, String summonerName,
			String summonerId, int currentPlatformId, int currentAccountId, String matchHistoryUri) {
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.player = player;
		this.summonerName = summonerName;
		this.summonerId = summonerId;
		this.currentPlatformId = currentPlatformId;
		this.currentAccountId = currentAccountId;
		this.matchHistoryUri = matchHistoryUri;
	}
	
	

	public ParticipantIdentity(int accountId, String firstName, String lastName) {
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
	}





	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
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



	public int getCurrentPlatformId() {
		return currentPlatformId;
	}



	public void setCurrentPlatformId(int currentPlatformId) {
		this.currentPlatformId = currentPlatformId;
	}



	public int getCurrentAccountId() {
		return currentAccountId;
	}



	public void setCurrentAccountId(int currentAccountId) {
		this.currentAccountId = currentAccountId;
	}



	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}



	public void setMatchHistoryUri(String matchHistoryUri) {
		this.matchHistoryUri = matchHistoryUri;
	}


	
	
}
