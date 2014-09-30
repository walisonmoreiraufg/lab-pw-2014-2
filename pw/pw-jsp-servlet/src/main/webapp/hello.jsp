<!DOCTYPE html>
<html>
	<head>
		<title>PW - JSP e Servlet - Hello JSP</title>
		<meta charset="utf-8">
		<!-- CSS do Bootstrap. -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- CSS da aplicação. -->
		<link rel="stylesheet" type="text/css" href="css/pw-jsp-servlet.css">
  </head>
	<body>
		<h1>Hello JSP</h1>
		<p>Aqui é HTML</p>
		<!-- Scriptlet -->
		<p><%
			out.print("Aqui é Java");
		%></p>
		<p><%
			out.print("Agora é: " + new java.util.Date());
		%></p>
	</body>
</html>