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
<title>Delete Account</title>
</head>
<body>
	<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
		<header class="text-center masthead mb-auto">
	    	<div class="inner">
	      		<h3 class="masthead-brand">LolDB</h3>
	      		<nav class="nav nav-masthead justify-content-center">
	        		<a class="nav-link" href="findchampions">Find Champions</a>
	        		        <a class="nav-link" href="finditems">Find Items</a>
	        		
	        		<c:if test="${messages.loggedIn}">
			        	<a class="nav-link" href="userprofile">My Profile</a>
			        </c:if>
			        <c:if test="${!messages.loggedIn}">
			        	<a class="nav-link" href="userlogin">Login</a>
			        </c:if>
	      		</nav>
	    	</div>
	  	</header>
	</div>
	<c:if test="${!messages.loggedIn}">
		<div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	
			<div class="alert alert-danger">
				You're not logged in!
			</div>
		</div>
	</c:if> 
	<div <c:if test="${messages.submitted || !messages.loggedIn}">style="display:none"</c:if> >
	  	<div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	  		<form action="userdelete" method="post">
				  <div class="form-row">
				      <label for="username">Username</label>
				      <input type="text" readonly class="form-control" id="username" name="username" 
				      value="${user.getUsername()}">
				  </div>
				  <div class="form-row">
				      <p class="lead">Are you sure you want to delete your account? Deleting cannot be undone.</p>
				      <p class="lead">Press submit to delete your account permanently.</p>
				      
				  </div>
				  <br>
				  
				    <br>
					<div class="lead text-center">
						<input class="btn btn-lg btn-secondary" type="submit" value="Delete My Account">
					</div>
				</form>
			
	  	</div>
  	</div>
  	<div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	<div <c:if test="${!messages.submitted}">style="display:none"</c:if> class="alert ${messages.resultType}">
		<p class="lead">${messages.result}</p>
	</div>
	</div>
</body>
</html>

