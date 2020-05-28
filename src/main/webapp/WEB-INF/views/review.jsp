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
<title>Review Page</title>
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
        <a class="nav-link" href="/">Parties</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="/vote?party=${optionList[0].party.id}">Options & Votes</a>
      </li>
      
    </ul>
  </div>
</nav>
</section>

<!-- Header -->
<section>
<h1>Pizza Options for Party:</h1>
</section>

<!-- Table -->
<section>
<h2><c:out value="${optionList[0].party.name}" /></h2>
<table class="table table-borderless">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Votes</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach var="option" items="${optionList}">
    
    <tr>
      <td><c:out value="${option.name}" /></td>
      <td><c:out value="${option.description}" /></td>
      <td><c:out value="${option.votes}" /></td>
      </tr>
      
      </c:forEach>
      
  </tbody>
</table>
</section>


</body>
</html>