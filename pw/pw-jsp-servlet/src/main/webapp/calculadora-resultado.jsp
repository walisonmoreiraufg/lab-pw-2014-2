<!DOCTYPE html>
<%@page import="java.text.DecimalFormat"%>
<html>
	<head>
		<title>PW - JSP e Servlet - Calculadora</title>
		<meta charset="utf-8">
		<!-- CSS do Bootstrap. -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- CSS da aplicação. -->
		<link rel="stylesheet" type="text/css" href="css/pw-jsp-servlet.css">
  </head>
  <body>
    <h1>Resultado</h1>
    <h2><%
	String operador1 = request.getParameter("operador1");
  float operador1Float = Float.parseFloat(operador1);
	String operacao = request.getParameter("operacao");
	String operador2 = request.getParameter("operador2");
	float operador2Float = Float.parseFloat(operador2);
	float resultado = 0;
	if (operacao.equals("+")) {
    	resultado = operador1Float + operador2Float;
	} else if (operacao.equals("-")) {
    	resultado = operador1Float - operador2Float;
	} else if (operacao.equals("*")) {
    	resultado = operador1Float * operador2Float;
	} else if (operacao.equals("/")) {
    	resultado = operador1Float / operador2Float;
	}

	DecimalFormat df = new DecimalFormat("0.00");
	
	out.print(df.format(resultado));
    %></h2>
    
    <%if (operacao.equals("%")) {%>
			<div class="alert alert-danger" role="alert">
	      <strong>Opa!</strong> O operador <strong>%  (porcentagem)</strong> não funciona ainda!
	    </div>
		<%}%>
    <a href="calculadora-formulario.html">Voltar</a>
  </body>
</html>