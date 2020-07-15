<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Champions</title>
</head>
<body>
	<form action="findchampions" method="post">
		<h1>Search for champions</h1>
		<p>
			<label for="seasonId">Season</label>
			<input id="seasonId" name="seasonId" value="${fn:escapeXml(param.seasonId)}">
			<label for="isWin">Won Game</label>
			<input id="isWin" name="isWin" value="${fn:escapeXml(param.isWin)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<br/>
	<h1>Matching Champions</h1>
        <table border="1">
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
</body>
</html>