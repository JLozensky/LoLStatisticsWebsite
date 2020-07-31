package lol.model;

public class Champions {
	
	private int championId;
	private String name;
	private String title;
	private String lore;
	private championRole championRole1;
	private championRole championRole2;
	private int attack, minAttack, maxAttack;
	private int defense, minDefense, maxDefense;
	private int magic, minMagic, maxMagic;
	private int difficulty, minDifficulty, maxDifficulty;
	private double hp, minHp, maxHp;
	private double hpPerLevel, minHpPerLevel, maxHpPerLevel;
	private double mp, minMp, maxMp;
	private double mpPerLevel, minMpPerLevel, maxMpPerLevel;
	private int moveSpeed, minMoveSpeed, maxMoveSpeed;
	private double armor, minArmor, maxArmor;
	private double armorPerLevel, minArmorPerLevel, maxArmorPerLevel;
	private double spellBlock, minSpellBlock, maxSpellBlock;
	private double spellBlockPerLevel, minSpellBlockPerLevel, maxSpellBlockPerLevel;
	private int attackRange, minAttackRange, maxAttackRange;
	private double hpRegen, minHpRegen, maxHpRegen;
	private double hpRegenPerLevel, minHpRegenPerLevel, maxHpRegenPerLevel;
	private double mpRegen, minMpRegen, maxMpRegen;
	private double mpRegenLevel, minMpRegenPerLevel, maxMpRegenPerLevel;
	private double attackDamage, minAttackDamage, maxAttackDamage;
	private double attackDamagePerLevel, minAttackDamagePerLevel, maxAttackDamagePerLevel;
	private double attackSpeedPerLevel, minAttackSpeedPerLevel, maxAttackSpeedPerLevel;
	private double attackSpeed, minAttackSpeed, maxAttackSpeed;
	private String passiveName;
	private String passiveDescription;
	private String imageFile;
	
	public enum championRole {
		NONE, FIGHTER, MARKSMAN, SUPPORT, MAGE, ASSASSIN, TANK
	}

	public Champions(int championId, String name, String title, String lore, championRole championRole1,
			championRole championRole2, int attack, int defense, int magic, int difficulty, double hp,
			double hpPerLevel, double mp, double mpPerLevel, int moveSpeed, double armor, double armorPerLevel,
			double spellBlock, double spellBlockPerLevel, int attackRange, double hpRegen, double hpRegenPerLevel,
			double mpRegen, double mpRegenLevel, double attackDamage, double attackDamagePerLevel,
			double attackSpeedPerLevel, double attackSpeed, String passiveName, String passiveDescription, String imageFile) {
		this.championId = championId;
		this.name = name;
		this.title = title;
		this.lore = lore;
		this.championRole1 = championRole1;
		this.championRole2 = championRole2;
		this.attack = attack;
		this.defense = defense;
		this.magic = magic;
		this.difficulty = difficulty;
		this.hp = hp;
		this.hpPerLevel = hpPerLevel;
		this.mp = mp;
		this.mpPerLevel = mpPerLevel;
		this.moveSpeed = moveSpeed;
		this.armor = armor;
		this.armorPerLevel = armorPerLevel;
		this.spellBlock = spellBlock;
		this.spellBlockPerLevel = spellBlockPerLevel;
		this.attackRange = attackRange;
		this.hpRegen = hpRegen;
		this.hpRegenPerLevel = hpRegenPerLevel;
		this.mpRegen = mpRegen;
		this.mpRegenLevel = mpRegenLevel;
		this.attackDamage = attackDamage;
		this.attackDamagePerLevel = attackDamagePerLevel;
		this.attackSpeedPerLevel = attackSpeedPerLevel;
		this.attackSpeed = attackSpeed;
		this.passiveName = passiveName;
		this.passiveDescription = passiveDescription;
		this.imageFile = imageFile;
	}
	
	public void setMinMaxFields(int minAttack, int maxAttack, int minDefense, int maxDefense, int minMagic, int maxMagic, 
			int minDifficulty, int maxDifficulty, double minHp, double maxHp, double minHpPerLevel, double maxHpPerLevel, 
			double minMp, double maxMp, double minMpPerLevel, double maxMpPerLevel, int minMoveSpeed, int maxMoveSpeed,
			double minArmor, double maxArmor, double minArmorPerLevel, double maxArmorPerLevel, double minSpellBlock,
			double  maxSpellBlock, double minSpellBlockPerLevel, double maxSpellBlockPerLevel,
			int minAttackRange, int maxAttackRange, double minHpRegen, double maxHpRegen, double minHpRegenPerLevel, 
			double maxHpRegenPerLevel, double minMpRegen, double maxMpRegen, double minMpRegenPerLevel, double maxMpRegenPerLevel,
			double minAttackDamage, double maxAttackDamage,
			double minAttackDamagePerLevel, double maxAttackDamagePerLevel, double minAttackSpeed, double maxAttackSpeed,
			double minAttackSpeedPerLevel, double maxAttackSpeedPerLevel) {
		this.minAttack = minAttack;
		this.maxAttack = maxAttack;
		this.minDefense = minDefense;
		this.maxDefense = maxDefense;
		this.minMagic = minMagic;
		this.maxMagic = maxMagic;
		this.minDifficulty = minDifficulty;
		this.maxDifficulty = maxDifficulty;
		this.minHp = minHp;
		this.maxHp = maxHp;
		this.minHpPerLevel = minHpPerLevel;
		this.maxHpPerLevel = maxHpPerLevel;
		this.minMp = minMp;
		this.maxMp = maxMp;
		this.minMpPerLevel = minMpPerLevel;
		this.maxMpPerLevel = maxMpPerLevel;
		this.minMoveSpeed = minMoveSpeed;
		this.maxMoveSpeed = maxMoveSpeed;
		this.minArmor = minArmor;
		this.maxArmor = maxArmor;
		this.minArmorPerLevel = minArmorPerLevel;
		this.maxArmorPerLevel = maxArmorPerLevel;
		this.minSpellBlock = minSpellBlock;
		this.maxSpellBlock = maxSpellBlock;
		this.minSpellBlockPerLevel = minSpellBlockPerLevel;
		this.maxSpellBlockPerLevel = maxSpellBlockPerLevel;
		this.minAttackRange = minAttackRange;
		this.maxAttackRange = maxAttackRange;
		this.minHpRegen = minHpRegen;
		this.maxHpRegen = maxHpRegen;
		this.minHpRegenPerLevel = minHpRegenPerLevel;
		this.maxHpRegenPerLevel = maxHpRegenPerLevel;
		this.minMpRegen = minMpRegen;
		this.maxMpRegen = maxMpRegen;
		this.minMpRegenPerLevel = minMpRegenPerLevel;
		this.maxMpRegenPerLevel = maxMpRegenPerLevel;
	    this.minAttackDamage = minAttackDamage;
	    this.maxAttackDamage = maxAttackDamage;
		this.minAttackDamagePerLevel = minAttackDamagePerLevel;
		this.maxAttackDamagePerLevel = maxAttackDamagePerLevel;
		this.minAttackSpeed = minAttackSpeed;
		this.maxAttackSpeed = maxAttackSpeed;
		this.minAttackSpeedPerLevel = minAttackSpeedPerLevel;
		this.maxAttackSpeedPerLevel = maxAttackSpeedPerLevel;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public championRole getChampionRole1() {
		return championRole1;
	}
	
	public String getChampionRoleDisplayString(championRole role) {
		String display = "";
		switch(role) {
		case ASSASSIN:
			display = "Assassin";
			break;
		case FIGHTER:
			display = "Fighter";
			break;
		case MAGE:
			display = "Mage";
			break;
		case MARKSMAN:
			display = "Marksman";
			break;
		case NONE:
			break;
		case SUPPORT:
			display = "Support";
			break;
		case TANK:
			display = "Tank";
			break;
		default:
			break;
		}
		return display;
	}
	
	public String getChampionRoleDisplayStringFull() {
		String role1 = getChampionRoleDisplayString(championRole1);
		String role2 = getChampionRoleDisplayString(championRole2);
		
		StringBuilder sb = new StringBuilder();
		sb.append(role1);
		if (!role2.isEmpty()) {
			sb.append(", ");
			sb.append(role2);
		}
		return sb.toString();
	}

	public void setChampionRole1(championRole championRole1) {
		this.championRole1 = championRole1;
	}

	public championRole getChampionRole2() {
		return championRole2;
	}

	public void setChampionRole2(championRole championRole2) {
		this.championRole2 = championRole2;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getHpPerLevel() {
		return hpPerLevel;
	}

	public void setHpPerLevel(double hpPerLevel) {
		this.hpPerLevel = hpPerLevel;
	}

	public double getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public double getMpPerLevel() {
		return mpPerLevel;
	}

	public void setMpPerLevel(double mpPerLevel) {
		this.mpPerLevel = mpPerLevel;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}

	public double getArmorPerLevel() {
		return armorPerLevel;
	}

	public void setArmorPerLevel(double armorPerLevel) {
		this.armorPerLevel = armorPerLevel;
	}

	public double getSpellBlock() {
		return spellBlock;
	}

	public void setSpellBlock(double spellBlock) {
		this.spellBlock = spellBlock;
	}

	public double getSpellBlockPerLevel() {
		return spellBlockPerLevel;
	}

	public void setSpellBlockPerLevel(double spellBlockPerLevel) {
		this.spellBlockPerLevel = spellBlockPerLevel;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public double getHpRegen() {
		return hpRegen;
	}

	public void setHpRegen(double hpRegen) {
		this.hpRegen = hpRegen;
	}

	public double getHpRegenPerLevel() {
		return hpRegenPerLevel;
	}

	public void setHpRegenPerLevel(double hpRegenPerLevel) {
		this.hpRegenPerLevel = hpRegenPerLevel;
	}

	public double getMpRegen() {
		return mpRegen;
	}

	public void setMpRegen(double mpRegen) {
		this.mpRegen = mpRegen;
	}

	public double getMpRegenLevel() {
		return mpRegenLevel;
	}

	public void setMpRegenLevel(double mpRegenLevel) {
		this.mpRegenLevel = mpRegenLevel;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public double getAttackDamagePerLevel() {
		return attackDamagePerLevel;
	}

	public void setAttackDamagePerLevel(double attackDamagePerLevel) {
		this.attackDamagePerLevel = attackDamagePerLevel;
	}

	public double getAttackSpeedPerLevel() {
		return attackSpeedPerLevel;
	}

	public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
		this.attackSpeedPerLevel = attackSpeedPerLevel;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public String getPassiveName() {
		return passiveName;
	}

	public void setPassiveName(String passiveName) {
		this.passiveName = passiveName;
	}

	public String getPassiveDescription() {
		return passiveDescription;
	}

	public void setPassiveDescription(String passiveDescription) {
		this.passiveDescription = passiveDescription;
	}
	
	public double getPercentage(double amount, double max) {
		return (amount / max) * 100;
	}

	public int getMinAttack() {
		return minAttack;
	}

	public void setMinAttack(int minAttack) {
		this.minAttack = minAttack;
	}

	public int getMaxAttack() {
		return maxAttack;
	}

	public void setMaxAttack(int maxAttack) {
		this.maxAttack = maxAttack;
	}

	public int getMinDefense() {
		return minDefense;
	}

	public void setMinDefense(int minDefense) {
		this.minDefense = minDefense;
	}

	public int getMaxDefense() {
		return maxDefense;
	}

	public void setMaxDefense(int maxDefense) {
		this.maxDefense = maxDefense;
	}

	public int getMinMagic() {
		return minMagic;
	}

	public void setMinMagic(int minMagic) {
		this.minMagic = minMagic;
	}

	public int getMaxMagic() {
		return maxMagic;
	}

	public void setMaxMagic(int maxMagic) {
		this.maxMagic = maxMagic;
	}

	public int getMinDifficulty() {
		return minDifficulty;
	}

	public void setMinDifficulty(int minDifficulty) {
		this.minDifficulty = minDifficulty;
	}

	public int getMaxDifficulty() {
		return maxDifficulty;
	}

	public void setMaxDifficulty(int maxDifficulty) {
		this.maxDifficulty = maxDifficulty;
	}

	public double getMinHp() {
		return minHp;
	}

	public void setMinHp(double minHp) {
		this.minHp = minHp;
	}

	public double getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(double maxHp) {
		this.maxHp = maxHp;
	}

	public double getMinHpPerLevel() {
		return minHpPerLevel;
	}

	public void setMinHpPerLevel(double minHpPerLevel) {
		this.minHpPerLevel = minHpPerLevel;
	}

	public double getMaxHpPerLevel() {
		return maxHpPerLevel;
	}

	public void setMaxHpPerLevel(double maxHpPerLevel) {
		this.maxHpPerLevel = maxHpPerLevel;
	}

	public double getMinMp() {
		return minMp;
	}

	public void setMinMp(double minMp) {
		this.minMp = minMp;
	}

	public double getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(double maxMp) {
		this.maxMp = maxMp;
	}

	public double getMinMpPerLevel() {
		return minMpPerLevel;
	}

	public void setMinMpPerLevel(double minMpPerLevel) {
		this.minMpPerLevel = minMpPerLevel;
	}

	public double getMaxMpPerLevel() {
		return maxMpPerLevel;
	}

	public void setMaxMpPerLevel(double maxMpPerLevel) {
		this.maxMpPerLevel = maxMpPerLevel;
	}

	public int getMinMoveSpeed() {
		return minMoveSpeed;
	}

	public void setMinMoveSpeed(int minMoveSpeed) {
		this.minMoveSpeed = minMoveSpeed;
	}

	public int getMaxMoveSpeed() {
		return maxMoveSpeed;
	}

	public void setMaxMoveSpeed(int maxMoveSpeed) {
		this.maxMoveSpeed = maxMoveSpeed;
	}

	public double getMinArmor() {
		return minArmor;
	}

	public void setMinArmor(double minArmor) {
		this.minArmor = minArmor;
	}

	public double getMaxArmor() {
		return maxArmor;
	}

	public void setMaxArmor(double maxArmor) {
		this.maxArmor = maxArmor;
	}

	public double getMinArmorPerLevel() {
		return minArmorPerLevel;
	}

	public void setMinArmorPerLevel(double minArmorPerLevel) {
		this.minArmorPerLevel = minArmorPerLevel;
	}

	public double getMaxArmorPerLevel() {
		return maxArmorPerLevel;
	}

	public void setMaxArmorPerLevel(double maxArmorPerLevel) {
		this.maxArmorPerLevel = maxArmorPerLevel;
	}

	public double getMinSpellBlock() {
		return minSpellBlock;
	}

	public void setMinSpellBlock(double minSpellBlock) {
		this.minSpellBlock = minSpellBlock;
	}

	public double getMaxSpellBlock() {
		return maxSpellBlock;
	}

	public void setMaxSpellBlock(double maxSpellBlock) {
		this.maxSpellBlock = maxSpellBlock;
	}

	public double getMinSpellBlockPerLevel() {
		return minSpellBlockPerLevel;
	}

	public void setMinSpellBlockPerLevel(double minSpellBlockPerLevel) {
		this.minSpellBlockPerLevel = minSpellBlockPerLevel;
	}

	public double getMaxSpellBlockPerLevel() {
		return maxSpellBlockPerLevel;
	}

	public void setMaxSpellBlockPerLevel(double maxSpellBlockPerLevel) {
		this.maxSpellBlockPerLevel = maxSpellBlockPerLevel;
	}

	public int getMinAttackRange() {
		return minAttackRange;
	}

	public void setMinAttackRange(int minAttackRange) {
		this.minAttackRange = minAttackRange;
	}

	public int getMaxAttackRange() {
		return maxAttackRange;
	}

	public void setMaxAttackRange(int maxAttackRange) {
		this.maxAttackRange = maxAttackRange;
	}

	public double getMinHpRegen() {
		return minHpRegen;
	}

	public void setMinHpRegen(double minHpRegen) {
		this.minHpRegen = minHpRegen;
	}

	public double getMaxHpRegen() {
		return maxHpRegen;
	}

	public void setMaxHpRegen(double maxHpRegen) {
		this.maxHpRegen = maxHpRegen;
	}

	public double getMinHpRegenPerLevel() {
		return minHpRegenPerLevel;
	}

	public void setMinHpRegenPerLevel(double minHpRegenPerLevel) {
		this.minHpRegenPerLevel = minHpRegenPerLevel;
	}

	public double getMaxHpRegenPerLevel() {
		return maxHpRegenPerLevel;
	}

	public void setMaxHpRegenPerLevel(double maxHpRegenPerLevel) {
		this.maxHpRegenPerLevel = maxHpRegenPerLevel;
	}

	public double getMinMpRegen() {
		return minMpRegen;
	}

	public void setMinMpRegen(double minMpRegen) {
		this.minMpRegen = minMpRegen;
	}

	public double getMaxMpRegen() {
		return maxMpRegen;
	}

	public void setMaxMpRegen(double maxMpRegen) {
		this.maxMpRegen = maxMpRegen;
	}

	public double getMinMpRegenPerLevel() {
		return minMpRegenPerLevel;
	}

	public void setMinMpRegenPerLevel(double minMpRegenPerLevel) {
		this.minMpRegenPerLevel = minMpRegenPerLevel;
	}

	public double getMaxMpRegenPerLevel() {
		return maxMpRegenPerLevel;
	}

	public void setMaxMpRegenPerLevel(double maxMpRegenPerLevel) {
		this.maxMpRegenPerLevel = maxMpRegenPerLevel;
	}

	public double getMinAttackDamage() {
		return minAttackDamage;
	}

	public void setMinAttackDamage(double minAttackDamage) {
		this.minAttackDamage = minAttackDamage;
	}

	public double getMaxAttackDamage() {
		return maxAttackDamage;
	}

	public void setMaxAttackDamage(double maxAttackDamage) {
		this.maxAttackDamage = maxAttackDamage;
	}

	public double getMinAttackDamagePerLevel() {
		return minAttackDamagePerLevel;
	}

	public void setMinAttackDamagePerLevel(double minAttackDamagePerLevel) {
		this.minAttackDamagePerLevel = minAttackDamagePerLevel;
	}

	public double getMaxAttackDamagePerLevel() {
		return maxAttackDamagePerLevel;
	}

	public void setMaxAttackDamagePerLevel(double maxAttackDamagePerLevel) {
		this.maxAttackDamagePerLevel = maxAttackDamagePerLevel;
	}

	public double getMinAttackSpeedPerLevel() {
		return minAttackSpeedPerLevel;
	}

	public void setMinAttackSpeedPerLevel(double minAttackSpeedPerLevel) {
		this.minAttackSpeedPerLevel = minAttackSpeedPerLevel;
	}

	public double getMaxAttackSpeedPerLevel() {
		return maxAttackSpeedPerLevel;
	}

	public void setMaxAttackSpeedPerLevel(double maxAttackSpeedPerLevel) {
		this.maxAttackSpeedPerLevel = maxAttackSpeedPerLevel;
	}

	public double getMinAttackSpeed() {
		return minAttackSpeed;
	}

	public void setMinAttackSpeed(double minAttackSpeed) {
		this.minAttackSpeed = minAttackSpeed;
	}

	public double getMaxAttackSpeed() {
		return maxAttackSpeed;
	}

	public void setMaxAttackSpeed(double maxAttackSpeed) {
		this.maxAttackSpeed = maxAttackSpeed;
	}

	public void setMp(double mp) {
		this.mp = mp;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
}
