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
<title>Find Champions</title>
</head>
<body>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
  <header class="text-center masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">LolDB</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link active" href="#">Find Champions</a>
        <a class="nav-link" href="#">Create</a>
        <a class="nav-link" href="#">Delete</a>
        <a class="nav-link" href="#">Update</a>
      </nav>
    </div>
  </header>
	
  <div>
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
  <div class="text-center">
	<h1 class="cover-heading">Search for champions</h1>
	<p class="lead">Use this page to search for winning or losing champions from specific seasons</p>
	</div>
    <form action="findchampions" method="post">
		
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="seasonId">Season</label>
			<div class="col-sm-9">
				<input class="form-control" id="seasonId" name="seasonId" value="${fn:escapeXml(param.seasonId)}">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="isWin">Won Game?</label>
			<div class="col-sm-9">
				<input class="form-check-input" id="isWin" type="checkbox" name="isWin" value="${fn:escapeXml(param.isWin)}">
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
	<div class="text-center cover-container d-flex w-75 h-100 p-3 mx-auto flex-column">
	<h1>Matching Champions</h1>
    <table class="lead" border="1">
        <tr>
            <th>Champion</th>
            <th>Title</th>
            <th>Attack</th>
            <th>Defense</th>
            <th>Magic</th>
            <th>Difficulty</th>
            <th>HP</th>
            <th>MP</th>
        </tr>
        <c:forEach items="${champions}" var="champion" >
            <tr>
                <td><c:out value="${champion.getName()}" /></td>
                <td><c:out value="${champion.getTitle()}" /></td>
                <td><c:out value="${champion.getAttack()}" /></td>
                <td><c:out value="${champion.getDefense()}"/></td>
                <td><c:out value="${champion.getMagic()}"/></td>
                <td><c:out value="${champion.getDifficulty()}"/></td>
                <td><c:out value="${champion.getHp()}"/></td>
                <td><c:out value="${champion.getMp()}"/></td>
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