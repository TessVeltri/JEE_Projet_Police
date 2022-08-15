<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check ticket</title>
<style><%@include file="/WEB-INF/CSS/styles.css"%></style>
<script><%@include file="/WEB-INF/JS/javascript.js"%></script>
</head>
<body>
	<%
	String plateNumber = (String) request.getAttribute("plateNumber");
	String date = (String) request.getAttribute("date");
	String hour = (String) request.getAttribute("hour");
	String name = (String) request.getAttribute("name");
	String firstname = (String) request.getAttribute("firstname");
	String email = (String) request.getAttribute("email");
	String vehicleType = (String) request.getAttribute("vehicleType");
	ArrayList<String> lstInfraction = (ArrayList<String>) session.getAttribute("infractions");
	%>
	
	<div class="back">
		<div class="div-center">
			<div class="content">
				<h3>Overview</h3>
				<div class="form-group">
					<label for="getPlate">Plate number : </label>
					<label> ${plateNumber}</label>
				</div>
				<div class="form-group">
					<label for="getDate">Date : </label>
					<label> ${date}</label>
				</div>
				<div class="form-group">
					<label for="gethour">Hour : </label>
					<label> ${hour}</label>
				</div>
				<div class="form-group">
					<label for="getName">Name civil : </label>
					<label> ${name}</label>
				</div>
				<div class="form-group">
					<label for="getFirstname">Firstname civil : </label>
					<label> ${firstname}</label>
				</div>
				<div class="form-group">
					<label for="getEmail">Email civil : </label>
					<label> ${email}</label>
				</div>
				<div class="form-group">
					<label for="getVehicleType">Vehicle type : </label>
					<label> ${vehicleType}</label>
				</div>
				<div class="form-group">
					<label for="getInfractions">Infractions : </label><br/>
					<ul>
						<% for(String inf : lstInfraction){ %>
							<li> <%= inf %> </li>
						<% } %>
					</ul>
				</div>
				<button name="send" id="send" value="send" class="checkButton" onclick="closeCheck()">Send</button>
			</div>
		</div>
	</div>



</body>
</html>