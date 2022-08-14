<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%!private String formatMessage(String message) {
		return "<font color=\"red\">" + message + "</font>";
	}%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Police - Login</title>
<style><%@include file="/WEB-INF/CSS/styles.css"%></style>
</head>
<body>
	<%
	String error = (String) request.getAttribute("error");
	%>
	<div class="back">
		<div class="div-center">
			<div class="content">
				<h3>Police - Login</h3>
				<hr />
				<form action="login" method="POST">
					<div class="form-group">
					<label for="inputMatricule">Matricule   </label> <input type="Text"
						class="form-control" id="inputMatricule" name="inputMatricule"
						placeholder="Matricule"> 
					</div>
					<div class="form-group">
					<label for="inputPassword">Password   </label><input type="password" 
						class="form-control" id="inputPassword" name="inputPassword" 
						placeholder="Password">
					</div>
					<%
					if (error != null ) {
					%>
					<div>
						<ul>
							<li><%=this.formatMessage(error)%></li>
						</ul>
					</div>
					<%
					}
					%>

					<button type="submit" name="submit" id="submit" value="login"
						class="btn btn-primary">Log in</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>