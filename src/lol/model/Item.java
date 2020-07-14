package lol.model;

public class Item {
	
	private int itemId;
	private String name;
	private String description;
	private String plainTextDesc;
	private String baseCost;
	private boolean purchasable;
	private int totalCost;
	private int sellPrice;
	private String tags;
	private boolean map11;
	private boolean map12;
	private boolean map22;
	private int depth;
	private int maxStack;
	private boolean consumed;
	private boolean inStore;
	private String requiredChampion;
	private String requiredAlly;
	
	public Item(int itemId, String name, String description, String plainTextDesc, String baseCost, boolean purchasable,
			int totalCost, int sellPrice, String tags, boolean map11, boolean map12, boolean map22, int depth,
			int maxStack, boolean consumed, boolean inStore, String requiredChampion, String requiredAlly) {
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.plainTextDesc = plainTextDesc;
		this.baseCost = baseCost;
		this.purchasable = purchasable;
		this.totalCost = totalCost;
		this.sellPrice = sellPrice;
		this.tags = tags;
		this.map11 = map11;
		this.map12 = map12;
		this.map22 = map22;
		this.depth = depth;
		this.maxStack = maxStack;
		this.consumed = consumed;
		this.inStore = inStore;
		this.requiredChampion = requiredChampion;
		this.requiredAlly = requiredAlly;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public String getPlainTextDesc() {
		return plainTextDesc;
	}

	public void setPlainTextDesc(String plainTextDesc) {
		this.plainTextDesc = plainTextDesc;
	}

	public String getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(String baseCost) {
		this.baseCost = baseCost;
	}

	public boolean isPurchasable() {
		return purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public boolean isMap11() {
		return map11;
	}

	public void setMap11(boolean map11) {
		this.map11 = map11;
	}

	public boolean isMap12() {
		return map12;
	}

	public void setMap12(boolean map12) {
		this.map12 = map12;
	}

	public boolean isMap22() {
		return map22;
	}

	public void setMap22(boolean map22) {
		this.map22 = map22;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}

	public boolean isConsumed() {
		return consumed;
	}

	public void setConsumed(boolean consumed) {
		this.consumed = consumed;
	}

	public boolean isInStore() {
		return inStore;
	}

	public void setInStore(boolean inStore) {
		this.inStore = inStore;
	}

	public String getRequiredChampion() {
		return requiredChampion;
	}

	public void setRequiredChampion(String requiredChampion) {
		this.requiredChampion = requiredChampion;
	}

	public String getRequiredAlly() {
		return requiredAlly;
	}

	public void setRequiredAlly(String requiredAlly) {
		this.requiredAlly = requiredAlly;
	}
	
	
	
	

}
