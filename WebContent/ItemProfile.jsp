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
<link href="css/bootstrap-grid.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<title>Item Profile</title>
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
	<div class="jumbotron">
		<div class="row">
			<div class="col-sm-4">
				<img src="img/item/${item.getImageFile()}" class="img-thumbnail" alt="200x200" style="width: 200px; height: 200px;" 
				/>
			</div>
			<div class="col-sm-8">
				<h1>${item.getName()}</h1>
				<h3>${item.getPlainTextDesc()}</h3>
			</div>
		</div>
		<br>
		<p class="lead">${item.getDescription()}</p>
	</div>
	<div class="list-group">
		<div class="list-group-item">
			<h4 class=list-group-item-heading>Item Stats</h4>
		</div>
		<div class="list-group-item">
				<div class="row">
					<div class="col-sm-3">
						<span>Purchaseable</span>
					</div>
					<div class="col-sm-9">
						<p class="list-group-item-text">${item.isPurchasable()}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<span>Base Cost</span>
					</div>
					<div class="col-sm-9">
						<div class="progress">
							<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${item.getBaseCost()}" 
									aria-valuemin="0" aria-valuemax="3200" 
							style="width: ${item.getBaseCost() / 3200 * 100}%">${item.getBaseCost()} / 3200</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<span>Total Cost</span>
					</div>
					<div class="col-sm-9">
						<div class="progress">
							<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${item.getTotalCost()}" 
									aria-valuemin="0" aria-valuemax="3733" 
							style="width: ${item.getTotalCost() / 3733 * 100}%">${item.getTotalCost()} / 3733</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<span>Sell Price</span>
					</div>
					<div class="col-sm-9">
						<div class="progress">
							<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="${item.getSellPrice()}" 
									aria-valuemin="0" aria-valuemax="2613" 
							style="width: ${item.getSellPrice() / 2613 * 100}%">${item.getSellPrice()} / 2613</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<span>Tags</span>
					</div>
					<div class="col-sm-9">
					
						<c:forEach items="${item.getTagList()}" var="tag" >
							<p class="list-group-item-text"><c:out value="${tag}"/> 						</p>
							
							
						</c:forEach>
					</div>
				</div>
		</div>
	</div>
  </div>
  
  
  </div>
     <br/><br/><br/>
  
	<div class="text-left cover-container d-flex w-75 h-100 p-3 mx-auto flex-column">

   <br/><br/><br/>
   
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