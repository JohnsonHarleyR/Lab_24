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

<meta charset="ISO-8859-1">
<title>Review Page</title>
</head>
<body>

<!-- Navigation -->
<section>
Navigation: 
<a href="/">Parties</a>
<a href="/vote-all">All Options & Votes</a> 
</section>

<!-- Header -->
<section>
<h1>Pizza Options</h1>
</section>

<!-- Table -->
<c:forEach var="party" items="${partyList}">
<section>
<h2><c:out value="${party.name}" /></h2>
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
    
    
     <!-- If the id matches then display the values -->
	<c:choose>
  <c:when test="${party.id == option.party.id}">
    <tr>
      <td><c:out value="${option.name}" /></td>
      <td><c:out value="${option.description}" /></td>
      <td><c:out value="${option.votes}" /></td>
      </tr>
      </c:when>
	</c:choose>
      </c:forEach>
      
  </tbody>
</table>
</section>
</c:forEach>


</body>
</html>