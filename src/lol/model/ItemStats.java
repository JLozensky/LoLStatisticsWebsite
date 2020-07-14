package lol.model;

public class ItemStats {
	
	private int itemStatsId;
	private Item item;
	private String statName;
	private double value;
	
	
	public ItemStats(int itemStatsId, Item item, String statName, double value) {
		this.itemStatsId = itemStatsId;
		this.item = item;
		this.statName = statName;
		this.value = value;
	}


	public int getItemStatsId() {
		return itemStatsId;
	}


	public void setItemStatsId(int itemStatsId) {
		this.itemStatsId = itemStatsId;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
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
