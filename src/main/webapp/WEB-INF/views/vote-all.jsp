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
<title>Vote Page</title>
</head>
<body>

<!-- Navigation -->
<section>
Navigation: 
<a href="/">Parties</a> 
<a href="/review-all">Review All</a>
</section>

<!-- Header -->
<section>
<h1>Pizza Options for All Parties</h1>
</section>

<!-- Tables -->
<c:forEach var="party" items="${partyList}">
<section>
<h2><c:out value="${party.name}" /></h2>
<table class="table table-borderless">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Votes</th>
      <th scope="col"></th>
      <th scope="col"></th>
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
      <td>
      <!-- vote -->
      	<form action="/vote-all/add-vote">
      	<input type="hidden" name="id" value="${option.id}"/>
      	<button class="btn btn-outline-success" type="submit">Vote!</button>
      	</form>
      	</td>
      	<td>
      	<!-- Edit -->
      	<form action="/edit">
      	<input type="hidden" name="option" value="${option.id}"/>
      	<button class="btn btn-outline-light" type="submit">Edit</button>
      	</form>
      </td>
      </tr>
      
  </c:when>
	</c:choose>
      </c:forEach>
      
  </tbody>
</table>
</section>
</c:forEach>

<!-- Add Option -->
<section>

<h2>Add an Option</h2>
<form action="/vote-all/add-option">

<label>Name: </label>
<input type="text" name="name" required/>

<label>Description: </label>
<input type="text" name="description" maxlength=250 required/>
<br>
<label>Party: </label>
<select name="party">
<c:forEach var="p" items="${partyList}">
<option value="${p.id}">${p.name}</option>
</c:forEach>
</select>
<button class="btn btn-outline-success" type="submit">Add</button>

</form>

</section>


</body>
</html>