<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-grid.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<title>Champion Profile</title>
</head>
<body>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
  <header class="text-center masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">LolDB</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="findchampions">Find Champions</a>
        <a class="nav-link" href="findplayers">Find Players</a>
        <a class="nav-link" href="playercreate">Create</a>
        <a class="nav-link" href="playerdelete">Delete</a>
        <a class="nav-link" href="playerupdate">Update</a>
      </nav>
    </div>
  </header>
	
  <div>
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	<div class="jumbotron">
		<div class="row">
			<div class="col-sm-4">
				<img src="img/champion/${champion.getImageFile()}" class="img-thumbnail" alt="200x200" style="width: 200px; height: 200px;" 
				/>
			</div>
			<div class="col-sm-8">
				<h1>${champion.getName()}</h1>
				<h3>${champion.getTitle()}</h3>
			</div>
		</div>
		<br>
		<p class="lead">${champion.getLore()}</p>
	</div>
	<div class="list-group">
		<div class="list-group-item">
			<h4 class=list-group-item-heading><span>${champion.getChampionRoleDisplayStringFull()}</span> (Champion Roles)</h4>
			
		</div>
		<div class="list-group-item">
			<h4 class=list-group-item-heading>${champion.getPassiveName()} (Passive Ability)</h4>
			<p class="list-group-item-text">${champion.getPassiveDescription()}</p>
		</div>
	</div>
  </div>
  
  
  </div>
     <br/><br/><br/>
  
	<div class="text-left cover-container d-flex w-75 h-100 p-3 mx-auto flex-column">
	<div class="alert alert-info">
		<h3>Stats</h3>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<!-- Attack, defense, magic, difficulty  -->
			<p class="lead">Combat Stats</p>
			<div class="row">
				<div class="col-sm-4">
					<span>Attack</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
				<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${champion.getAttack()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxAttack()}" 
		style="width: ${champion.getPercentage(champion.getAttack(), champion.getMaxAttack())}%">${champion.getAttack()} 
		/ ${champion.getMaxAttack()}</div>
			</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<span>Attack Range</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
						<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${champion.getAttackRange()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxAttackRange()}" 
		style="width: ${champion.getPercentage(champion.getAttackRange(), champion.getMaxAttackRange())}%">${champion.getAttackRange()} 
		/ ${champion.getMaxAttackRange()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<span>Defense</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
				<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getDefense()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxDefense()}" 
		style="width: ${champion.getPercentage(champion.getDefense(), champion.getMaxDefense())}%">${champion.getDefense()} 
		/ ${champion.getMaxDefense()}
		</div>
			</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<span>Magic</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
				<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getMagic()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxMagic()}" 
		style="width: ${champion.getPercentage(champion.getMagic(), champion.getMaxMagic())}%">${champion.getMagic()} 
		/ ${champion.getMaxMagic()}</div>
			</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<span>Difficulty</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
				<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${champion.getDifficulty()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxDifficulty()}" 
		style="width: ${champion.getPercentage(champion.getDifficulty(), champion.getMaxDifficulty())}%">${champion.getDifficulty()} 
		/ ${champion.getMaxDifficulty()}</div>
			</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<span>Attack Damage</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
						<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${champion.getAttackDamage()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxAttackDamage()}" 
		style="width: ${champion.getPercentage(champion.getAttackDamage(), champion.getMaxAttackDamage())}%">${champion.getAttackDamage()} 
		/ ${champion.getMaxAttackDamage()}</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-4">
					<span>Attack Speed</span>
				</div>
				<div class="col-sm-8">
					<div class="progress">
						<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${champion.getAttackSpeed()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxAttackSpeed()}" 
		style="width: ${champion.getPercentage(champion.getAttackSpeed(), champion.getMaxAttackSpeed())}%">${champion.getAttackSpeed()} 
		/ ${champion.getMaxAttackSpeed()}</div>
					</div>
				</div>
			</div>
			
		</div>
		<div class="col-lg-6">
			<!-- Attack, defense, magic, difficulty  -->
			<p class="lead">Defensive Stats</p>
			<div class="row">
				<div class="col-sm-3">
					<span>HP</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${champion.getHp()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxHp()}" 
		style="width: ${champion.getPercentage(champion.getHp(), champion.getMaxHp())}%">${champion.getHp()} 
		/ ${champion.getMaxHp()}</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<span>MP</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getMp()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxMp()}" 
		style="width: ${champion.getPercentage(champion.getMp(), champion.getMaxMp())}%">${champion.getMp()} 
		/ ${champion.getMaxMp()}</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<span>Move Speed</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${champion.getMoveSpeed()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxMoveSpeed()}" 
		style="width: ${champion.getPercentage(champion.getMoveSpeed(), champion.getMaxMoveSpeed())}%">${champion.getMoveSpeed()} 
		/ ${champion.getMaxMoveSpeed()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<span>Armor</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getArmor()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxArmor()}" 
		style="width: ${champion.getPercentage(champion.getArmor(), champion.getMaxArmor())}%">${champion.getArmor()} 
		/ ${champion.getMaxArmor()}</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<span>Spell Block</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getSpellBlock()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxSpellBlock()}" 
		style="width: ${champion.getPercentage(champion.getSpellBlock(), champion.getMaxSpellBlock())}%">${champion.getSpellBlock()} 
		/ ${champion.getMaxSpellBlock()}</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-sm-3">
					<span>HP Regen</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${champion.getHpRegen()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxHpRegen()}" 
		style="width: ${champion.getPercentage(champion.getHpRegen(), champion.getMaxHpRegen())}%">${champion.getHpRegen()} 
		/ ${champion.getMaxHpRegen()}</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3">
					<span>MP Regen</span>
				</div>
				<div class="col-sm-9">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getMpRegen()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxMpRegen()}" 
		style="width: ${champion.getPercentage(champion.getMpRegen(), champion.getMaxMpRegen())}%">${champion.getMpRegen()} 
		/ ${champion.getMaxMpRegen()}</div>
					</div>
				</div>
			</div>
			
			
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<!-- Per Level  -->
			<p class="lead">Per Level Stats</p>
			<div class="row">
				<div class="col-sm-5">
					<span>Attack Damage Per Level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${champion.getAttackDamagePerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxAttackDamagePerLevel()}" 
		style="width: ${champion.getPercentage(champion.getAttackDamagePerLevel(), champion.getMaxAttackDamagePerLevel())}%">${champion.getAttackDamagePerLevel()} 
		/ ${champion.getMaxAttackDamagePerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>Attack Speed Per Level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${champion.getAttackSpeedPerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxAttackSpeedPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getAttackSpeedPerLevel(), champion.getMaxAttackSpeedPerLevel())}%">${champion.getAttackSpeedPerLevel()} 
		/ ${champion.getMaxAttackSpeedPerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>Armor Per Level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getArmorPerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxArmorPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getArmorPerLevel(), champion.getMaxArmorPerLevel())}%">${champion.getArmorPerLevel()} 
		/ ${champion.getMaxArmorPerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>HP per level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${champion.getHpPerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxHpPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getHpPerLevel(), champion.getMaxHpPerLevel())}%">${champion.getHpPerLevel()} 
		/ ${champion.getMaxHpPerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>HP Regen Per Level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${champion.getHpRegenPerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxHpRegenPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getHpRegenPerLevel(), champion.getMaxHpRegenPerLevel())}%">${champion.getHpRegenPerLevel()} 
		/ ${champion.getMaxHpRegenPerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>MP per level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getMpPerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxMpPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getMpPerLevel(), champion.getMaxMpPerLevel())}%">${champion.getMpPerLevel()} 
		/ ${champion.getMaxMpPerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>MP Regen Per Level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${champion.getMpRegenLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxMpRegenPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getMpRegenLevel(), champion.getMaxMpRegenPerLevel())}%">${champion.getMpRegenLevel()} 
		/ ${champion.getMaxMpRegenPerLevel()}</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>Spell Block Per Level</span>
				</div>
				<div class="col-sm-7">
					<div class="progress">
						<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${champion.getSpellBlockPerLevel()}" 
		aria-valuemin="0" aria-valuemax="${champion.getMaxSpellBlockPerLevel()}" 
		style="width: ${champion.getPercentage(champion.getSpellBlockPerLevel(), champion.getMaxSpellBlockPerLevel())}%">${champion.getSpellBlockPerLevel()} 
		/ ${champion.getMaxSpellBlockPerLevel()}</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
		</div>
	</div>
   <br/><br/><br/>
   <div class="alert alert-info">
   		<h3>Champion Advice</h3>
   </div>
   <div class="row">
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Top 10 best champions to fight against</h5>
					
				</div>
				<div class="list-group-item">
					<p class="list-group-item-text">
						<a href="championprofile?id=<c:out value="${champion.getChampionId()}"/>">
	                		<img src="img/champion/<c:out value="${champion.getImageFile()}"/>" class="img-thumbnail" 
	                		alt="100x100" style="width: 100px; height: 100px;" />
	                	</a>
						<a href="championprofile?id=<c:out value="${champion.getChampionId()}"/>">
							${champion.getName()}
						</a>
					</p>
				</div>
			</div>
 		</div>
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Top 10 worst champions to fight against</h5>
					
				</div>
				<div class="list-group-item">
					<p class="list-group-item-text">${champion.getPassiveDescription()}</p>
				</div>
			</div>
 		</div>
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Best Items to use</h5>
					
				</div>
				<div class="list-group-item">
					<p class="list-group-item-text">${champion.getPassiveDescription()}</p>
				</div>
			</div>
 		</div>
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Best Summoner Spells to use</h5>
					
				</div>
				<div class="list-group-item">
					<p class="list-group-item-text">${champion.getPassiveDescription()}</p>
				</div>
			</div>
 		</div>
 	</div>
 </div>
 

  <footer class="mastfoot mt-auto d-flex p-3 mx-auto flex-column w-50 justify-content-center">

  </footer>
</div>
	
       
    <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>