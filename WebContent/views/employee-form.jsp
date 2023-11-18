
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
		</div>
		<h1>Employee Directory</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/EmployeeController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "name" placeholder = "Coloque o nome da finan�a" value = "${employee.name_finance}"/>
					</div>
				
					<div class = "form-group">
						<input placeholder = "Coloque o valor" type = "number" class = "form-control" name = "dob" value = "${employee.value}"/>
					</div>
				
					<div class="form-group">
				<select class="form-select" aria-label="Default select example" name="employeeType">
				
					    <option value="R" ${employee.type_value == 'R' ? 'selected' : ''}>Receita</option>
					    <option value="D" ${employee.type_value == 'D' ? 'selected' : ''}>Despesa</option>
				</select>
					</div>
				
					<input type = "hidden" name = "id" value = "${employee.id}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/EmployeeController?action=LIST">Back to List</a>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>