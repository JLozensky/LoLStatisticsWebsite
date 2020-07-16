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
<title>Find Players</title>
</head>
<body>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
  <header class="text-center masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">LolDB</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="findchampions">Find Champions</a>
        <a class="nav-link active" href="findplayers">Find Players</a>
        <a class="nav-link" href="playercreate">Create</a>
        <a class="nav-link" href="playerdelete">Delete</a>
        <a class="nav-link" href="playerupdate">Update</a>
      </nav>
    </div>
  </header>
	
  <div>
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
  <div class="text-center">
	<h1 class="cover-heading">Search for players</h1>
	<p class="lead">Use this page to search for players by summoner name</p>
	</div>
    <form action="findchampions" method="post">
		
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="summonerName">Summoner Name</label>
			<div class="col-sm-9">
				<input class="form-control" id="summonerName" name="summonerName" value="${fn:escapeXml(param.previousStartPrefix)}">
			</div>
		</div>

		<div class="lead text-center">
			<input class="btn btn-lg btn-secondary" type="submit">
		</div>
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
	</form>
  </div>
  </div>
	<br/>
	<br/>
	<div class="text-center cover-container d-flex w-85 h-100 p-3 mx-auto flex-column">
	<h1>Matching Players</h1>
    <table class="lead" border="1">
        <tr>
            <th>AccountID</th>
            <th>Player</th>
            <th>Summoner Name</th>
            <th>Summoner ID</th>
            <th>Current Platform ID</th>
            <th>Current Account ID</th>
            <th>Match History URI</th>
            <th>Delete</th>
            <th>Update</th>
            
        </tr>
        <c:forEach items="${participants}" var="participant" >
            <tr>
                <td><c:out value="${participant.getAccountId()}" /></td>
                <td><c:out value="${participant.getPlayer()}" /></td>
                <td><c:out value="${participant.getSummonerName()}" /></td>
                <td><c:out value="${participant.getSummonerId()}"/></td>
                <td><c:out value="${participant.getCurrentPlatformId()}"/></td>
                <td><c:out value="${participant.getCurrentAccountId()}"/></td>
                <td><c:out value="${participant.getMatchHistoryUri()}"/></td>
                <td><a href="playerdelete?accountId=<c:out value="${participant.getAccountId()}"/>">Delete</a></td>
                <td><a href="playerupdate??accountId=<c:out value="${participant.getAccountId()}"/>">Update</a></td>
            </tr>
        </c:forEach>
   </table>
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