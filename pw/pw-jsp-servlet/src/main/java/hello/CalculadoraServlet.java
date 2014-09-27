package hello;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		request
			.getRequestDispatcher("calculadora-servlet.jsp")
			.forward(request, response);
	}
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("calcular")) {
			
			String operador1 = request.getParameter("operador1");
			float operador1Float = Float.parseFloat(operador1);
			String operacao = request.getParameter("operacao");
			String operador2 = request.getParameter("operador2");
			float operador2Float = Float.parseFloat(operador2);
			float resultadoFloat = 0;
			if (operacao.equals("+")) {
				resultadoFloat = operador1Float + operador2Float;
			} else if (operacao.equals("-")) {
				resultadoFloat = operador1Float - operador2Float;
			} else if (operacao.equals("*")) {
				resultadoFloat = operador1Float * operador2Float;
			} else if (operacao.equals("/")) {
				resultadoFloat = operador1Float / operador2Float;
			}
	
			DecimalFormat df = new DecimalFormat("0.00");
			String resultado = df.format(resultadoFloat);
			
			//Define um objeto no request que pode ser usado no JSP.
			request.setAttribute("resultado", resultado);

		}
		// Pedir para o JSP mostrar o resultado.
		request
			.getRequestDispatcher("calculadora-servlet.jsp")
			.forward(request, response);

	}

}
