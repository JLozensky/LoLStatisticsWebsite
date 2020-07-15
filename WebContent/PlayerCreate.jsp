<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Player</title>
</head>
<body>
	<h1>Create Player</h1>
	<form action="playercreate" method="post">
		<p>
			<label for="accountid">AccountId</label>
			<input id="accountid" name="accountid" value="">
		</p>
		<p>
			<label for="player">Player</label>
			<input id="player" name="player" value="">
		</p>
		<p>
			<label for="summonername">SummonerName</label>
			<input id="summonername" name="summonername" value="">
		</p>
		<p>
			<label for="summonerid">SummonerId</label>
			<input id="summonerid" name="summonerid" value="">
		</p>

		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>