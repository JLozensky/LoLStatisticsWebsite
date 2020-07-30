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
         <a class="nav-link" href="finditems">Find Items</a>
        <c:if test="${messages.showError}">
        	<a class="nav-link" href="userlogin">Login</a>
        </c:if>
        <c:if test="${!messages.showError}">
        	<a class="nav-link" href="userprofile">My Profile</a>
        </c:if>
      </nav>
    </div>
  </header>
  
<c:if test="${messages.showError}">
  	<div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center" style="display:none">
  		<div class="alert alert-danger">${messages.result}</div>
	</div>
</c:if>

</div>
<div <c:if test="${messages.showError}">style="display:none"</c:if>>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column" >
  <div class="inner-cover d-flex p-3 mx-auto flex-column w-50 justify-content-center">

	<div class="text-center">
		<h1 class="cover-heading">Update Account Details</h1>
	</div>
	<form action="userupdate" method="post" class="needs-validation" novalidate>
	<div class="form-row">
	      	<label for="username">Username</label>
	        <input type="text" readonly class="form-control" id="username" name="username" 
	        value="${user.getUsername()}">
		 </div>
		<div class="form-row">
		    <div class="col-md-6">
		      <label for="firstname">First name</label>
		      <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter your first name"
		      value="${user.getFirstName()}" required>
		      <div class="invalid-feedback">
		        First name is required
		      </div>
		    </div>
		    <div class="col-md-6">
		      <label for="lastname">Last name</label>
		      <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter your last name"
		      value="${user.getLastName()}" required>
		      <div class="invalid-feedback">
		        Last name is required
		      </div>
		    </div>
		   </div>
		 <div class="form-row">
		 	<label for="email">Email Address</label>
	        <input type="text" class="form-control" id="email" name="email" placeholder="Enter your email" 
	        value="${user.getEmail()}" required>
	        <div class="invalid-feedback">
	        	Email is required
	        </div>
		 </div>
		 
		 
		 <div class="form-row">
		 	<label for="password">Password</label>
	        <input type="password" class="form-control" id="password" name="password" placeholder="Choose a password"
	        value="${user.getPassword() }" required>
	        <div class="invalid-feedback">
	        	Please choose a password.
	        </div>
		 </div>
		 <div class="form-row">
		 	<label for="summonername">Summoner Name</label>
	        <input type="text" class="form-control" id="summonername" name="summonername" placeholder="Enter your summoner name" 
	        value="${user.getSummoner().getSummonerName()}" required>
	        <div class="invalid-feedback">
	        	Please enter the summoner name to link to your account
	        </div>
		 </div>
		  <br/>
		<div class="lead text-center">
			<input class="btn btn-lg btn-secondary" type="submit">
		</div>
	</form>
	<br/><br/>
	<div class="alert ${messages.resultType}" <c:if test="${!messages.showResult}">style="display:none"</c:if>>
		<span id="resultMessage">${messages.result}</span>
	</div>
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