<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Find Weather Information</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
    	body { background-color: #eee; font: helvetica; }
    	#container { width: 700px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
    	.green { font-weight: bold; color: green; }
    	.message { margin-bottom: 10px; }
    	label {width:70px; display:inline-block;}
    	input { display:inline-block; margin-right: 10px; }
    	form {line-height: 160%; }
    	.hide { display: none; }
    	.error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>
	
	<div id="container">
	
	<h2>Find Weather Information. Please Enter ZipCode.</h2>
 	<form:form method="POST" commandName="weather">
		<table>
			<tr>
				<td><label for="zipCode">ZipCode: </label></td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset"/> </td>
			</tr>
		</table>
	</form:form>
	<br>
	<c:if test="${empty weather.place}">
 			<br>
 			<h3 class="error">&nbsp;${weather.weather}&nbsp;&nbsp;</h3>
 	</c:if>
	<br>
	<c:if test="${not empty weather.place}">
 		<div class="message green">
 		<br>
 		<h2>Today's Weather !</h2>
 		<table class="result" border="1">
 			<tr>
				<td><h3>ZipCode</h3></td>
				<td><h3>&nbsp;&nbsp;${weather.zipCode}&nbsp;&nbsp;</h3></td>
			</tr>
			<tr>
				<td><h3>City</h3></td>
				<td><h3>&nbsp;&nbsp;${weather.place}&nbsp;&nbsp;</h3></td>
			</tr>
			<tr>
				<td><h3>Weather</h3></td>
				<td><h3>&nbsp;&nbsp;${weather.weather}&nbsp;&nbsp;</h3></td>
			</tr>
			<tr>
				<td><h3>Temperature</h3></td>
				<td><h3>&nbsp;&nbsp;${weather.temperature}&nbsp;&nbsp;</h3></td>
			</tr>
		</table>
		</div>
 	</c:if>`
 	<br>
	</div>
</body>
</html>