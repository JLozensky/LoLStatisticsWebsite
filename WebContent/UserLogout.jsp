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
<title>User Logout</title>
</head>
<body>
	<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
		<header class="text-center masthead mb-auto">
	    	<div class="inner">
	      		<h3 class="masthead-brand">LolDB</h3>
	      		<nav class="nav nav-masthead justify-content-center">
	        		<a class="nav-link" href="findchampions">Find Champions</a>
	        		 <a class="nav-link" href="finditems">Find Items</a>
	        		<a class="nav-link" href="userlogin">Login</a>
	      		</nav>
	    	</div>
	  	</header>
	</div>
	<div>
	  	<div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	  		
			<div <c:if test="${!messages.submitted}">style="display:none"</c:if> class="alert alert-success">
				<p class="lead">${messages.result}</p>
			</div>
			
	  	</div>
  	</div>
</body>
</html>

