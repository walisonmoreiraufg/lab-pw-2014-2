<!DOCTYPE html>
<html>
	<head>
		<title>PW - JSP e Servlet - Calculadora com Servlet</title>
		<meta charset="utf-8">
		<!-- CSS do Bootstrap. -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- CSS da aplicação. -->
		<link rel="stylesheet" type="text/css" href="css/pw-jsp-servlet.css">
  </head>
  <body>
    <h1>Calculadora com Servlet</h1>
    <form action="calculadora" method="post">
    	Operador 1 <input type="text" name="operador1" value="${param.operador1}">
    	<br>
    	Operação <input type="text" name="operacao" value="${param.operacao}">
    	<br>
    	Operador 2 <input type="text" name="operador2" value="${param.operador2}">
    	<br>
    	<button name="acao" value="calcular">Calcular</button>
    </form>
    <%
    String resultado = (String) request.getAttribute("resultado");
    if (resultado != null) {
    %>
			<h2>Resultado</h2>
			<h3>${param.operador1} ${param.operacao} ${param.operador2} =
				${resultado}</h3>
		<%
		}
		%>
  </body>
</html>