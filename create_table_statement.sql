DROP SCHEMA IF EXISTS LOL;

CREATE SCHEMA IF NOT EXISTS LOL;
USE LOL;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS SummonerStats;
DROP TABLE IF EXISTS Summoner;
DROP TABLE IF EXISTS ChampionAdvice;
DROP TABLE IF EXISTS Champions;
DROP TABLE IF EXISTS Team;
DROP TABLE IF EXISTS RuneData;
DROP TABLE IF EXISTS Item;
DROP TABLE IF EXISTS SummonerSpells;
DROP TABLE IF EXISTS ItemStats;
DROP TABLE IF EXISTS Game;


CREATE TABLE ItemStats (
 itemStatsId INT AUTO_INCREMENT,
 itemId INT,
 statName VARCHAR(255),
 value DECIMAL(8,4),
 CONSTRAINT pk_ItemStats_itemStatsId PRIMARY KEY (itemStatsId)
);
CREATE TABLE SummonerSpells (
 summonerSpellId INT AUTO_INCREMENT,
 name VARCHAR(255),
 description LONGTEXT,
 spellRange INT,
 cooldown INT,
 summonerLevel INT,
 modesAvailable VARCHAR(255),
 imageFile VARCHAR(255),
 spriteFile VARCHAR(255),
 spriteGroup VARCHAR(255),
 spriteX INT,
 spriteY INT,
 spriteW INT,
 spriteH INT,
 CONSTRAINT pk_SummonerSpells_summonerSpellId PRIMARY KEY (summonerSpellId)
);
CREATE TABLE Item (
 itemId INT,
 name VARCHAR(255),
 description LONGTEXT,
 plaintextDesc LONGTEXT,
 baseCost INT,
 purchasable BOOLEAN,
 totalCost INT,
 sellPrice INT,
 tags VARCHAR(255),
 map11 BOOLEAN,
 map12 BOOLEAN,
 map22 BOOLEAN,
 depth INT DEFAULT NULL,
 maxStack INT,
 consumed BOOLEAN,
 inStore BOOLEAN,
 requiredChampion VARCHAR(255),
 requiredAlly VARCHAR(255),
 imageFile VARCHAR(255),
 spriteFile VARCHAR(255),
 spriteGroup VARCHAR(255),
 spriteX INT,
 spriteY INT,
 spriteW INT,
 spriteH INT,
 CONSTRAINT pk_Item_itemId_tags PRIMARY KEY (itemId, tags)
);
CREATE TABLE RuneData (
 runeId INT,
 name VARCHAR(255),
 pathName VARCHAR(255),
 longDesc LONGTEXT,
 imagePath VARCHAR(255),
 CONSTRAINT pk_RuneData_runeId PRIMARY KEY (runeId)
);
CREATE TABLE Game (
 gameId VARCHAR(255),
 date VARCHAR(255),
 gameDuration INT,
 queueId INT,
 mapId INT,
 seasonId INT,
 gameVersion VARCHAR(255),
 gameMode VARCHAR(255),
 gameType VARCHAR(255),
 CONSTRAINT pk_Game_gameId PRIMARY KEY (gameId)
);
CREATE TABLE Team (
 teamId VARCHAR(255),
 win VARCHAR(255),
 firstBlood BOOLEAN,
 firstTower BOOLEAN,
 firstInhibitor BOOLEAN,
 firstBaron BOOLEAN,
 firstDragon BOOLEAN,
 firstRiftHerald BOOLEAN,
 towerKills INT,
 inhibitorKills INT,
 baronKills INT,
 dragonKills INT,
 vilemawKills INT,
 riftHeraldKills INT,
 dominionVictoryScore INT,
 banOne INT,
 banTwo INT,
 banThree INT,
 banFour INT,
 banFive INT,
 gameId VARCHAR(255),
 CONSTRAINT pk_Team_teamId PRIMARY KEY (teamId),
 CONSTRAINT pk_Team_gameId FOREIGN KEY (gameId)
 REFERENCES Game(gameId)
);
CREATE TABLE Champions (
 championId INT,
 name VARCHAR(255),
 title VARCHAR(255),
 lore LONGTEXT,
 championRole1 ENUM ('FIGHTER', 'MAGE', 'ASSASSIN', 'TANK', 'MARKSMAN', 'SUPPORT'),
 championRole2 ENUM ('FIGHTER', 'MAGE', 'ASSASSIN', 'TANK', 'MARKSMAN', 'SUPPORT', '') DEFAULT NULL,
 attack INT,
 defense INT,
 magic INT,
 difficulty INT,
 hp DECIMAL(8,4),
 hpPerLevel DECIMAL(8,4),
 mp INT,
 mpPerLevel DECIMAL(8,4),
 moveSpeed INT,
 armor DECIMAL(8,4),
 armorPerLevel DECIMAL(8,4),
 spellBlock DECIMAL(8,4),
 spellBlockPerLevel DECIMAL(8,4),
 attackRange INT,
 hpRegen DECIMAL(8,4),
 hpRegenPerLevel DECIMAL(8,4),
 mpRegen DECIMAL(8,4),
 mpRegenPerLevel DECIMAL(8,4),
 attackDamage DECIMAL(8,4),
 attackDamagePerLevel DECIMAL(8,4),
 attackSpeedPerLevel DECIMAL(8,4),
 attackSpeed DECIMAL(8,4),
 passiveName VARCHAR(255),
 passiveDescription LONGTEXT,
 imageFile VARCHAR(255),
 spriteFile VARCHAR(255),
 spriteGroup VARCHAR(255),
 spriteX INT,
 spriteY INT,
 spriteW INT,
 spriteH INT,
 CONSTRAINT pk_Champions_championId PRIMARY KEY (championId)
);
CREATE TABLE ChampionAdvice (
 adviceId INT AUTO_INCREMENT,
 championId INT,
 allyAdvice LONGTEXT,
 enemyAdvice LONGTEXT,
 CONSTRAINT pk_ChampionAdvice_adviceId PRIMARY KEY (adviceId),
 CONSTRAINT fk_ChampionAdvice_championId FOREIGN key (championId)
  REFERENCES Champions (championId)
  ON UPDATE CASCADE ON DELETE SET NULL
);
CREATE TABLE Summoner (
 accountId VARCHAR(255),
 summonerName VARCHAR(255),
 currentPlatformId VARCHAR(255),
 summonerId VARCHAR(255),
 matchHistoryUri VARCHAR(255),
 profileIcon BIGINT,
 CONSTRAINT pk_Summoner_accountId PRIMARY KEY (accountId)
);
CREATE TABLE SummonerStats (
 summonerStatsId VARCHAR(255),
 championId INT,
 spell1Id INT,
 spell2Id INT,
 itemId0 INT,
 itemId1 INT,
 itemId2 INT,
 itemId3 INT,
 itemId4 INT,
 itemId5 INT,
 itemId6 INT,
 kills INT,
 deaths INT,
 assists INT,
 totalDamageDealt BIGINT,
 magicDamageDealt BIGINT,
 physicalDamageDealt BIGINT,
 trueDamageDealt BIGINT,
 largestCriticalStrike BIGINT,
 totalDamageDealtToChampions BIGINT,
 magicDamageDealtToChampions BIGINT,
 physicalDamageDealtToChampions BIGINT,
 trueDamageDealtToChampions BIGINT,
 totalHeal BIGINT,
 totalUnitsHealed BIGINT,
 damageSelfMitigated BIGINT,
 damageDealtToObjectives BIGINT,
 damageDealtToTurrets BIGINT,
 visionScore BIGINT,
 timeCCingOthers BIGINT,
 totalDamageTaken BIGINT,
 magicalDamageTaken BIGINT,
 physicalDamageTaken BIGINT,
 trueDamageTaken BIGINT,
 goldEarned BIGINT,
 goldSpent BIGINT,
 turretKills BIGINT,
 totalMinionsKilled BIGINT,
 neutralMinionsKilled BIGINT,
 neutralMinionsKilledTeamJungle BIGINT,
 neutralMinionsKilledEnemyJungle BIGINT,
 totalTimeCrowdControlDealt BIGINT,
 champLevel INT,
 visionWardsBoughtInGame INT,
 sightWardsBoughtInGame INT,
 wardsPlaced INT,
 wardsKilled INT,
 firstBloodKill BOOLEAN,
 firstBloodAssist BOOLEAN,
 firstTowerKill BOOLEAN,
 firstTowerAssist BOOLEAN,
 firstInhibitorKill BOOLEAN,
 firstInhibitorAssist BOOLEAN,
 combatPlayerScore INT,
 objectivePlayerScore INT,
 totalPlayerScore INT,
 totalScoreRank INT,
 perk0 INT,
 perk1 INT,
 perk2 INT,
 perk3 INT,
 perk4 INT,
 perk5 INT,
 perkPrimaryStyle BIGINT,
 perkSubStyle BIGINT,
 role VARCHAR(255),
 lane VARCHAR(255),
 highestAchievedSeasonTier VARCHAR(255),
 gameId VARCHAR(255),
 teamId VARCHAR(255),
 accountId VARCHAR(255),
 CONSTRAINT pk_summonerStats_summonerStatsId PRIMARY KEY (summonerStatsId),
 CONSTRAINT fk_summonerStats_gameId FOREIGN KEY (gameId)
 REFERENCES Game(gameId),
  CONSTRAINT fk_summonerStats_teamId FOREIGN KEY (teamId)
 REFERENCES Team(teamId),
 CONSTRAINT fk_summonerStats_accountId FOREIGN KEY (accountId)
 REFERENCES Summoner(accountId)
);

CREATE TABLE Users (
 userName VARCHAR(255),
 userPassword VARCHAR(255),
 email VARCHAR(255),
 accountId VARCHAR(255),
 firstName VARCHAR(255),
 lastName VARCHAR(255),
 CONSTRAINT pk_Users_userName
	PRIMARY KEY (userName),
 CONSTRAINT fk_Users_accountId
	FOREIGN KEY (accountId)
	REFERENCES Summoner(accountId)
);


  LOAD DATA INFILE 'SummonerSpellTable.csv' INTO TABLE SummonerSpells
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES
  (SummonerSpells.SummonerSpellId, SummonerSpells.name, SummonerSpells.description, SummonerSpells.spellRange,
  SummonerSpells.cooldown, SummonerSpells.summonerLevel, SummonerSpells.ModesAvailable, SummonerSpells.imageFile,
  SummonerSpells.spriteFile, SummonerSpells.spriteGroup, SummonerSpells.spriteX, SummonerSpells.spriteY,
  SummonerSpells.spriteW, SummonerSpells.spriteH)
  SET summonerSpellId = NULL;
  
  LOAD DATA INFILE 'ItemStatTable.csv' INTO TABLE ItemStats
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES
  (ItemStats.itemId, ItemStats.statName, ItemStats.value)
  SET itemStatsId = NULL;
  
  LOAD DATA INFILE 'ItemTable.csv' INTO TABLE Item
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES;

  LOAD DATA INFILE 'RuneTable.csv' INTO TABLE RuneData
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES;
  
  LOAD DATA INFILE 'ChampionTable.csv' INTO TABLE Champions
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES;
  
  LOAD DATA INFILE 'ChampionAdviceTable.csv' INTO TABLE ChampionAdvice
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES
  (ChampionAdvice.championId, ChampionAdvice.allyAdvice, ChampionAdvice.enemyAdvice)
  SET adviceId = NULL;
