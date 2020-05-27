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
<title>Homepage</title>
</head>
<body>

<!-- Navigation -->
<section>
Navigation: 
<a href="/vote">Options & Votes</a> 
<a href="/review">Review Options</a>
</section>

<!-- Header -->
<section>
<h1>Parties</h1>
</section>

<!-- Content -->
<section>

<ul>
<c:forEach var="party" items="${partyList}">
<li>${party.name} - ${party.date}</li>
</c:forEach>
</ul>

</section>

</body>
</html>