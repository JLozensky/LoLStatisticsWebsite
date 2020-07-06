package lol.model;

public class SummonerSpells {
	
	private int summonerSpellId;
	private String name;
	private String description;
	private int range;
	private int coolDown;
	private int summonerLevel;
	private String modeAvailable;
	
	public SummonerSpells(int summonerSpellId, String name, String description, int range, int coolDown,
			int summonerLevel, String modeAvailable) {
		this.summonerSpellId = summonerSpellId;
		this.name = name;
		this.description = description;
		this.range = range;
		this.coolDown = coolDown;
		this.summonerLevel = summonerLevel;
		this.modeAvailable = modeAvailable;
	}

	public int getSummonerSpellId() {
		return summonerSpellId;
	}

	public void setSummonerSpellId(int summonerSpellId) {
		this.summonerSpellId = summonerSpellId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getCoolDown() {
		return coolDown;
	}

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}

	public int getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(int summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	public String getModeAvailable() {
		return modeAvailable;
	}

	public void setModeAvailable(String modeAvailable) {
		this.modeAvailable = modeAvailable;
	}
	
	
	
	

}
