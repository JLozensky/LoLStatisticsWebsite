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
<title>Find Items</title>
</head>
<body>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
  <header class="text-center masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">LolDB</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="findchampions">Find Champions</a>
        <a class="nav-link active" href="finditems">Find Items</a>
        <c:if test="${messages.loggedIn}">
        	<a class="nav-link" href="userprofile">My Profile</a>
        </c:if>
        <c:if test="${!messages.loggedIn}">
        	<a class="nav-link" href="userlogin">Login</a>
        </c:if>
      </nav>
    </div>
  </header>
	
  <div>
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
  <div class="text-center">
	<h1 class="cover-heading">Search for items</h1>
	<p class="lead">Use this page to search for items by name</p>
	</div>
    <form action="finditems" method="post">
		
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="itemName">Item Name</label>
			<div class="col-sm-9">
				<input class="form-control" id="itemName" name="itemName" value="${fn:escapeXml(param.itemName)}">
			</div>
		</div>
		<div class="lead text-center">
			<input class="btn btn-lg btn-secondary" type="submit">
		</div>
	</form>
	<br>
	<br>

  </div>
  </div>
	<br/>
	<br/>
	<div class="text-center cover-container d-flex w-75 h-100 p-3 mx-auto flex-column">
	<c:choose>
		<c:when test="${items.size() > 0}">
			<h1>${messages.success}</h1>
		    <table class="lead" border="1">
		        <tr>
		            <th>Item</th>
		            <th>Name</th>
		            <th>Description</th>
		        </tr>
		        <c:forEach items="${items}" var="item" >
		            <tr>
		            
		                <td>
		                	<a href="itemprofile?id=<c:out value="${item.getItemId()}"/>">
		                		<img src="img/item/<c:out value="${item.getImageFile()}"/>" class="img-thumbnail" 
		                		alt="100x100" style="width: 100px; height: 100px;" />
		                	</a>
		                	
		                </td>
		                <td><a href="itemprofile?id=<c:out value="${item.getItemId()}"/>">${item.getName()}</a></td>
		                <td><c:out value="${item.getPlainTextDesc()}" /></td>
		            </tr>
		        </c:forEach>
		   </table>
		</c:when>
	
	</c:choose>
	
	
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