<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado do Cadastro</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
     
    <div class="container">
		<form action="Cadastro" method="post">
			<div class="card">
				<div class="card-header text-left font-weight-bold">Cadastro</div>
				<div class="card-body">
					<!-- 
					descomentar caso implemtar isso
					<div class="form-group">
						<input type="text" name="nome" required class="form-control"
							placeholder="Digite o Nome" />
					</div>
					
					<div class="form-group">
						<input type="text" name="sobrenome" required class="form-control"
							placeholder="Digite o Sobrenome" />
					</div>
					-->
					
					<div class="form-group">
						<input type="text" name="email" required class="form-control"
							placeholder="Digite o E-mail" />
					</div>
					
					<div class="form-group">
						<input type="password" name="password" required
							class="form-control" placeholder="Digite a Senha" />
					</div>

				</div>
				<div class="card-footer text-left">
					<input type="submit" value="Cadastrar" class="btn btn-primary" />
				</div>
				
				
			</div>
		</form>
		
		<div class="card-footer text-left">
				<a href="index.jsp">ir para login</a>
			</div>
		
	</div>

</body>
</html>