<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style_css/css_login.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<body>
	<div class="main">


		<div class="container">
				<div class="middle">
					<div id="login">

						<form action="login" method="post">

							<fieldset class="clearfix">

								<p>
									<span class="fa fa-user"></span><input type="text" name="username"
										Placeholder="Usuário" required>
								</p>
								<!-- JS because of IE support; better: placeholder="Username" -->
								<p>
									<span class="fa fa-lock"></span><input type="password" name="password"
										Placeholder="Senha" required>
								</p>
								<!-- JS because of IE support; better: placeholder="Password" -->

								<div>
									<!--<span
										style="width: 48%; text-align: left; display: inline-block;"><a
										class="small-text" href="#">Esqueceu sua senha?</a></span>--> <span
										style="width: 100%; text-align: center; display: inline-block;"> <input
										type="submit" value="Entrar"></span>
								</div>

							</fieldset>
							<div class="clearfix"></div>
						</form>

						<div class="clearfix"></div>

					</div>
					<!-- end login -->
					<div class="logo">
						Sistema

						<div class="clearfix"></div>
					</div>

				</div>
		</div>

	</div>
	<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
	<script src="jquery/jquery.min.js"></script>
</body>
</html>