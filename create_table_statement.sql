CREATE SCHEMA IF NOT EXISTS LOL;
USE LOL;

DROP TABLE IF EXISTS SummonerStats;
DROP TABLE IF EXISTS Summoner;
DROP TABLE IF EXISTS ChampionAdvice;
DROP TABLE IF EXISTS Champions;
DROP TABLE IF EXISTS TeamStats;
DROP TABLE IF EXISTS RuneData;
DROP TABLE IF EXISTS Item;
DROP TABLE IF EXISTS SummonerSpells;
DROP TABLE IF EXISTS ItemStats;
DROP TABLE IF EXISTS Game;

CREATE TABLE ItemStats (
 itemStatsId INT AUTO_INCREMENT,
 itemId INT,
 statName VARCHAR(225),
 value DECIMAL(8,4),
 CONSTRAINT pk_ItemStats_itemStatsId PRIMARY KEY (itemStatsId)
);

CREATE TABLE SummonerSpells (
 summonerSpellId INT AUTO_INCREMENT,
 name VARCHAR(225),
 description LONGTEXT,
 spellRange INT,
 cooldown INT,
 summonerLevel INT,
 modesAvailable VARCHAR(225),
 CONSTRAINT pk_SummonerSpells_summonerSpellId PRIMARY KEY (summonerSpellId)
);

CREATE TABLE Item (
 itemId INT,
 name VARCHAR(225),
 description LONGTEXT,
 plaintextDesc LONGTEXT,
 baseCost INT,
 purchasable BOOLEAN,
 totalCost INT,
 sellPrice INT,
 tags VARCHAR(225),
 map11 BOOLEAN,
 map12 BOOLEAN,
 map22 BOOLEAN,
 depth INT DEFAULT NULL,
 maxStack INT,
 consumed BOOLEAN,
 inStore BOOLEAN,
 requiredChampion VARCHAR(225),
 requiredAlly VARCHAR(225),
 CONSTRAINT pk_Item_itemId_tags PRIMARY KEY (itemId, tags)
);
 
CREATE TABLE RuneData (
 runeId INT,
 name VARCHAR(225),
 pathName VARCHAR(225),
 longDesc LONGTEXT,
 CONSTRAINT pk_RuneData_runeId PRIMARY KEY (runeId)
);

CREATE TABLE Game (
 gameId VARCHAR(225),
 date VARCHAR(225),
 gameDuration INT,
 queueId INT,
 mapId INT,
 seasonId INT,
 gameVersion VARCHAR(225),
 gameMode VARCHAR(225),
 gameType VARCHAR(225),
 CONSTRAINT pk_Game_gameId PRIMARY KEY (gameId)
);

CREATE TABLE TeamStats (
 teamStatsId VARCHAR(225),
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
 CONSTRAINT pk_TeamStats PRIMARY KEY (teamStatsId),
 CONSTRAINT pk_TeamStats FOREIGN KEY (gameId)
 REFERENCES Game(gameId)
);



CREATE TABLE Champions (
 championId INT,
 name VARCHAR(225),
 title VARCHAR(225),
 lore LONGTEXT,
 championRole1 ENUM ('FIGHTER', 'MAGE', 'ASSASSIN', 'TANK', 'MARKSMAN', 'SUPPORT'),
 championRole2 ENUM ('FIGHTER', 'MAGE', 'ASSASSIN', 'TANK', 'MARKSMAN', 'SUPPORT', '') DEFAULT NULL,
 attack INT,
 defense INT,
 magic INT,
 difficult INT,
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
 teamStatsId VARCHAR(255),
 CONSTRAINT pk_Summoner_accountId PRIMARY KEY (summonerName),
 CONSTRAINT fk_Summoner_teamStatsId FOREIGN KEY (teamStatsId)
 REFERENCES TeamStats(teamStatsId)
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
 summonerName VARCHAR(255),
 CONSTRAINT pk_summonerStats_summonerStatsId PRIMARY KEY (summonerStatsId),
 CONSTRAINT fk_summonerStats_summonerName FOREIGN KEY (summonerName)
 REFERENCES Summoner(summonerName)
);




















