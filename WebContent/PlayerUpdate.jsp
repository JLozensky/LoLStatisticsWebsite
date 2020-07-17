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

<title>Update a Player</title>
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
        <a class="nav-link active" href="playerupdate">Update</a>
      </nav>
    </div>
  </header>
</div>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">

	<div class="text-center">
		<h1 class="cover-heading">Update Player</h1>
		<p class="lead">Use this page to update an existing player/participant</p>
	</div>
	<form action="playupdate" method="post">
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="accountid">AccountId</label>
			<div class="col-sm-9">
				<input class="form-control" id="accountid" name="accountid" value="${fn:escapeXml(param.accountid)}">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="summonername">New SummonerName</label>
			<div class="col-sm-9">
				<input class="form-control" id="summonername" name="summonername" value="">
			</div>
		</div>
		<div class="lead text-center">
			<input class="btn btn-lg btn-secondary" type="submit">
		</div>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	</div>
	</div>
	 <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>