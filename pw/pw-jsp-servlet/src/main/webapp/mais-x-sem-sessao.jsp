<!DOCTYPE html>
<html>
	<head>
		<title>PW - JSP e Servlet - Mais X (sem sessão)</title>
		<meta charset="utf-8">
		<!-- CSS do Bootstrap. -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- CSS da aplicação. -->
		<link rel="stylesheet" type="text/css" href="css/pw-jsp-servlet.css">
  </head>
	<body>
		<h1>Mais X (sem sessão)</h1>
		<%
		String numeroString = request.getParameter("numero");
		if (numeroString == null) {
			numeroString = "0.0";
		}
		Double numero = Double.parseDouble(numeroString);

		String resultadoString = request.getParameter("resultado");
		if (resultadoString == null) {
			resultadoString = "0.0";
		}
		Double resultado = Double.parseDouble(resultadoString);

		resultado += numero;
		%>
		<form method="post">
			X: <input type="text" name="numero">
			<button>Mais X</button>
			<input type="hidden" name="resultado" value="<%out.print(resultado);%>">
		</form>
		<h2>Resultado = <%out.print(resultado);%></h2>
	</body>
</html>