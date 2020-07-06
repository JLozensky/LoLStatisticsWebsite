package lol.model;

public class ChampionAdvice {
	
	private int advice;
	private int championId;
	private String allyAdivce;
	private String enemyAdvice;
	
	public ChampionAdvice(int advice, int championId, String allyAdivce, String enemyAdvice) {
		this.advice = advice;
		this.championId = championId;
		this.allyAdivce = allyAdivce;
		this.enemyAdvice = enemyAdvice;
	}

	public int getAdvice() {
		return advice;
	}

	public void setAdvice(int advice) {
		this.advice = advice;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public String getAllyAdivce() {
		return allyAdivce;
	}

	public void setAllyAdivce(String allyAdivce) {
		this.allyAdivce = allyAdivce;
	}

	public String getEnemyAdvice() {
		return enemyAdvice;
	}

	public void setEnemyAdvice(String enemyAdvice) {
		this.enemyAdvice = enemyAdvice;
	}
	
	

}
