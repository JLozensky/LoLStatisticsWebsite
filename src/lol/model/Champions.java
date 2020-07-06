package lol.model;

public class Champions {
	
	private int championId;
	private String name;
	private String title;
	private String lore;
	private championRole championRole1;
	private championRole championRole2;
	private int attack;
	private int defense;
	private int magic;
	private int difficulty;
	private double hp;
	private double hpPerLevel;
	private int mp;
	private double mpPerLevel;
	private int moveSpeed;
	private double armor;
	private double armorPerLevel;
	private double spellBlock;
	private double spellBlockPerLevel;
	private int attackRange;
	private double hpRegen;
	private double hpRegenPerLevel;
	private double mpRegen;
	private double mpRegenLevel;
	private double attackDamage;
	private double attackDamagePerLevel;
	private double attackSpeedPerLevel;
	private double attackSpeed;
	private String passiveName;
	private String passiveDescription;
	
	private enum championRole {
		FIGHTER, MARKSMAN, SUPPORT, MAGE,ASSASSIN, TANK
	}

	public Champions(int championId, String name, String title, String lore, championRole championRole1,
			championRole championRole2, int attack, int defense, int magic, int difficulty, double hp,
			double hpPerLevel, int mp, double mpPerLevel, int moveSpeed, double armor, double armorPerLevel,
			double spellBlock, double spellBlockPerLevel, int attackRange, double hpRegen, double hpRegenPerLevel,
			double mpRegen, double mpRegenLevel, double attackDamage, double attackDamagePerLevel,
			double attackSpeedPerLevel, double attackSpeed, String passiveName, String passiveDescription) {
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

	public int getMp() {
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
	
	
	
	
	
	

}
