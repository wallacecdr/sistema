<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/css_login.css" rel="stylesheet">
<link href="bootstrap-4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<!-- <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="User Icon" /> -->
				Bem vindo!
			</div>

			<!-- Login Form -->
			<form>
				<input type="text" id="login" class="fadeIn second" name="login"
					placeholder="Login"> 
					
				<input type="text" id="senha"
					class="fadeIn third" name="senha" placeholder="Senha"> 
					
				<input
					type="submit" class="fadeIn fourth" value="Entrar">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Esqueceu a Senha?</a>
			</div>

		</div>
	</div>

	<script type="text/javascript"
		src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
	<script src="jquery/jquery.min.js"></script>
</body>
</html>