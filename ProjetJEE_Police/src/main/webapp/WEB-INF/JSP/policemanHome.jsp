<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Policeman</title>
<style><%@include file="/WEB-INF/CSS/styles.css"%></style>
<script><%@include file="/WEB-INF/JS/javascript.js"%></script>
</head>
<body>
	<%
	String userName = (String) request.getAttribute("userName");
	ArrayList<String> lstVehicleTypes = (ArrayList<String>) session.getAttribute("lstVehicleTypes");
	ArrayList<String> lstInfractionTypes = (ArrayList<String>) session.getAttribute("lstInfractionTypes");
	ArrayList<String> lstInfraction = (ArrayList<String>) session.getAttribute("infractions");
	%>
	<h2>Hello ${userName}</h2>
	
	<div class="grid-container">
	<form method="POST" action="policemanHome">
		<div class="div-center grid-child">
			<h3>Information</h3>
				<div class="form-group">
					<label for="plateNumber">Plate Number </label> <input type="Text"
						class="form-control" id="plateNumber" name="plateNumber"
						placeholder="Plate Number" required>
				</div>
				<div class="form-group">
					<label for="date">Date </label> <input type="date"
						class="form-control" id="date" name="date" placeholder="Date" required>
				</div>
				<div class="form-group">
					<label for="hour">Hour </label> <input type="time"
						class="form-control" id="hour" name="hour" placeholder="Hour" required>
				</div>
				<div class="form-group">
					<label for="name">Name </label> <input type="Text"
						class="form-control" id="name" name="name" placeholder="Name">
				</div>
				<div class="form-group">
					<label for="firstname">Firstname </label> <input type="Text"
						class="form-control" id="firstname" name="firstname"
						placeholder="Firstname">
				</div>
				<div class="form-group">
					<label for="email">Email </label> <input type="Text"
						class="form-control" id="email" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="vehicleType">Vehicle type </label> <select
						id="vehicleType" name="vehicleType" required>
						<%
							for (String type : lstVehicleTypes) {
						%>
							<option value="<%=type%>"><%=type%></option>
						<%
							}
						%>
					</select>
				</div>
			<button type="submit" name="check" id="check" value="check" class="checkButton">Check</button>
		</div>
	</form>
		<div class="div-center grid-child">
			<h3>Infraction</h3>
			<%
				if (lstInfraction != null) {
			%>
			<div>
				<ul>
					<%
						for (String inf : lstInfraction) {
					%>
						<li><%= inf %></li>
					<%
						}
					%>
				</ul>
			</div>
			<%
				}
			%>
			<button onclick="toggleForm()">+</button>
			
			<form id="infractionForm" method="POST" action="addInfraction" style="display : none">
				<div class="form-group">
					<label for="infractionType">Infraction type </label> <select
						id="infractionType" name="infractionType">
						<%
							for (String type : lstInfractionTypes) {
						%>
							<option value="<%=type%>"><%=type%></option>
						<%
							}
						%>
					</select>
				</div>
				<textarea id="comment" name="comment" rows="4" cols="50" placeholder="Comment"></textarea>
				<button type="submit" name="addInf" id="addInf" value="addInf"
						class="btn btn-primary">Add</button>
			</form>
			
		</div>
	</div>
	
</body>
</html>