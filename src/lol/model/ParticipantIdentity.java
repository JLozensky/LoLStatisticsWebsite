package lol.model;

public class ParticipantIdentity {

	private int accountId;
	private String player;
	private String summonerName;
	private int summonerId;
	private int currentPlatformId;
	private int currentAccountId;
	private String matchHistoryUri;
	
	public ParticipantIdentity(int accountId, String player, String summonerName, int summonerId, int currentPlatformId,
			int currentAccountId, String matchHistoryUri) {
		this.accountId = accountId;
		this.player = player;
		this.summonerName = summonerName;
		this.summonerId = summonerId;
		this.currentPlatformId = currentPlatformId;
		this.currentAccountId = currentAccountId;
		this.matchHistoryUri = matchHistoryUri;
	}

	public ParticipantIdentity(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public int getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(int summonerId) {
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
