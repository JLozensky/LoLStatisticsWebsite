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
<title>User Login</title>
</head>
<body>
	<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
		<header class="text-center masthead mb-auto">
	    	<div class="inner">
	      		<h3 class="masthead-brand">LolDB</h3>
	      		<nav class="nav nav-masthead justify-content-center">
	        		<a class="nav-link" href="findchampions">Find Champions</a>
	        		 <a class="nav-link" href="finditems">Find Items</a>
	      		</nav>
	    	</div>
	  	</header>
	</div>
	<div>
	  	<div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">
	  		<div class="text-center">
				<h1 class="cover-heading">User Login</h1>
				<p class="lead">Login to see your personal stats and info</p>
			</div>
			    <form action="userlogin" method="post" class="needs-validation" novalidate>
				  <div class="form-row">
				      <label for="username">Username</label>
				      <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" 
				      value="${fn:escapeXml(param.username)}">
				      <div class="invalid-feedback">
				        Please enter your username
				      </div>
				  </div>
				  <div class="form-row">
				      <label for="password">Password</label>
				      <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" 
				      value="${fn:escapeXml(param.password)}">
				      <div class="invalid-feedback">
				        Please enter your password
				      </div>
				  </div>
				  <br>
				  <div class="form-row">
				  	<a href="usercreate">Create a new account</a>
				  </div>
				    <br>
					<div class="lead text-center">
						<input class="btn btn-lg btn-secondary" type="submit">
					</div>
				</form>
		  	
			<br>
			<div <c:if test="${!messages.submitted}">style="display:none"</c:if> class="alert alert-danger">
				<p class="lead">${messages.result}</p>
			</div>
			
	  	</div>
  	</div>
</body>


	<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
	})();
	</script>
</html>

