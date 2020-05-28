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
<title>Edit Page</title>
</head>
<body>
<section>
<h1>Edit Option:</h1>
<form action="/edit-submit">
<input type="hidden" name="optionId" value="${option.id}" required/>
<label>Name: </label>
<input type="text" autocomplete="on" name="name" value="${option.name}" required/>
<br>
<label>Description: </label>
<input type="text" autocomplete="on" name="description" value="${option.description}" 
maxlength=250 required/>
<br>
<button class="btn btn-outline-success" type="submit">Submit</button>

</form>
</section>

</body>
</html>