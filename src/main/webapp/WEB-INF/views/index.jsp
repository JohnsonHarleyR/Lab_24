<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Core tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Format tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<!-- Style sheets -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<link href="style.css" rel="stylesheet"/>

<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>

<!-- Navigation -->
<section>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Navigation</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
    
      <li class="nav-item">
        <a class="nav-link" href="/vote-all">All Options & Votes</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="/review-all">Review All</a>
      </li>
      
    </ul>
  </div>
</nav>


</section>

<!-- Header -->
<section>
<h1>Parties</h1>
</section>

<!-- Content -->
<section>

<ul>
<c:forEach var="party" items="${partyList}">
<li>${party.name} - ${party.date} 
<a href="/vote?party=${party.id}">Vote</a> 
<a href="/review?party=${party.id}">Review</a>
</li>
</c:forEach>
</ul>

</section>

</body>
</html>