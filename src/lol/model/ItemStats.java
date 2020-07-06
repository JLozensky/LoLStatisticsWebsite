package lol.model;

public class ItemStats {
	
	private int itemStatsId;
	private int itemId;
	private String statName;
	private double value;
	
	
	public ItemStats(int itemStatsId, int itemId, String statName, double value) {
		this.itemStatsId = itemStatsId;
		this.itemId = itemId;
		this.statName = statName;
		this.value = value;
	}


	public int getItemStatsId() {
		return itemStatsId;
	}


	public void setItemStatsId(int itemStatsId) {
		this.itemStatsId = itemStatsId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getStatName() {
		return statName;
	}


	public void setStatName(String statName) {
		this.statName = statName;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}
	
	
	
	
	

}
