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

<title>User Profile</title>
</head>
<body>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
  <header class="text-center masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">LolDB</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="findchampions">Find Champions</a>
         <a class="nav-link" href="finditems">Find Items</a>
        <c:if test="${messages.showError}">
        	<a class="nav-link" href="userlogin">Login</a>
        </c:if>
      </nav>
    </div>
  </header>
  <c:if test="${messages.showError}">
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center" style="display:none">
  	<div class="alert alert-danger">${messages.error}</div>
  	
</div>
</c:if>
<div <c:if test="${messages.showError}">style="display:none"</c:if>>
  <div>
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	<div class="jumbotron">
		<div class="row">
			<div class="col-sm-4">
				
			</div>
			<div class="col-sm-8">
				<h2>@${user.getUsername()}</h2>
				<h4>${user.getSummoner().getSummonerName()}</h4>
				<h4>${user.getFirstName()} ${user.getLastName()}</h4>
				<h5>${user.getEmail()}</h5>
				 	<div class="row">
				 		<a href="userupdate">Update Info</a>
				 	</div>
				 	<div class="row">
				 		<a href="userlogout">Logout</a>
				 	</div>
				 	<div class="row">
				 		<a href="userdelete">Delete Account</a>
				 	</div>
			</div>
		</div>
		<br>
	</div>
  </div>
  
  </div>
     <br/><br/><br/>
  
	<div class="text-left cover-container d-flex w-75 h-100 p-3 mx-auto flex-column">
   <div class="alert alert-info">
   		<h3>User Stats</h3>
   </div>
     <div class="row" id="userStats">
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Top 10 best champions to fight against</h5>
					
				</div>
				<c:forEach items="${top10BestChampions}" var="bestChampion" >
				<div class="list-group-item">
					<p class="list-group-item-text">
						<a href="championprofile?id=<c:out value="${bestChampion.getChampionId()}"/>">
	                		<img src="img/champion/<c:out value="${bestChampion.getImageFile()}"/>" class="img-thumbnail" 
	                		alt="100x100" style="width: 100px; height: 100px;" />
	                	</a>
						<a href="championprofile?id=<c:out value="${bestChampion.getChampionId()}"/>">
							${bestChampion.getName()}
						</a>
					</p>
				</div>
				</c:forEach>
			</div>
 		</div>
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Top 10 worst champions to fight against</h5>
					
				</div>
				<c:forEach items="${top10WorstChampions}" var="worstChampion" >
				<div class="list-group-item">
					<p class="list-group-item-text">
						<a href="championprofile?id=<c:out value="${worstChampion.getChampionId()}"/>">
	                		<img src="img/champion/<c:out value="${worstChampion.getImageFile()}"/>" class="img-thumbnail" 
	                		alt="100x100" style="width: 100px; height: 100px;" />
	                	</a>
						<a href="championprofile?id=<c:out value="${worstChampion.getChampionId()}"/>">
							${worstChampion.getName()}
						</a>
					</p>
				</div>
				</c:forEach>
			</div>
 		</div>
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Best Items to use</h5>
					
				</div>
				<c:forEach items="${bestItems}" var="item" >
				<div class="list-group-item">
					<p class="list-group-item-text">
						<a href="itemprofile?id=<c:out value="${item.getItemId()}"/>&tags=<c:out value="${item.getTags()}"/>">
	                		<img src="img/item/<c:out value="${item.getImageFile()}"/>" class="img-thumbnail" 
	                		alt="100x100" style="width: 100px; height: 100px;" />
	                	</a>
						<a href="itemprofile?id=<c:out value="${item.getItemId()}"/>&tags=<c:out value="${item.getTags()}"/>">
							${item.getName()}
						</a>
					</p>
				</div>
				</c:forEach>
			</div>
 		</div>
 		<div class="col-md-3">
 			<div class="list-group">
				<div class="list-group-item">
					<h5 class=list-group-item-heading>Best Summoner Spells to use</h5>
					
				</div>
				<c:forEach items="${bestSpells}" var="spell" >
				<div class="list-group-item">
					<p class="list-group-item-text">
						<a href="spellprofile?id=<c:out value="${spell.getSummonerSpellId()}"/>">
	                		<img src="img/spell/<c:out value="${spell.getImageFile()}"/>" class="img-thumbnail" 
	                		alt="100x100" style="width: 100px; height: 100px;" />
	                	</a>
						<a href="itemprofile?id=<c:out value="${spell.getSummonerSpellId()}"/>">
							${spell.getName()}
						</a>
					</p>
				</div>
				</c:forEach>
			</div>
 		</div>
 	</div> <!-- end user advice row -->
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