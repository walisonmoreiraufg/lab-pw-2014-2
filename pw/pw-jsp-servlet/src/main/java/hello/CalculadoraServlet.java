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

	/**
	 * Será chamado ao clicar no link "http://.../calculadora".
	 * Os links (tag "<a href="endereco"></a>") geram requisições HTTP com método "GET".
	 */
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		request
			.getRequestDispatcher("calculadora-servlet.jsp")
			.forward(request, response);
	}
	
	
	/**
	 * Será chamado na submissão do formulário com método HTTP igual a "POST".
	 */
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("calcular")) {
			
			Calculo c = new Calculo();
			
			c.setOperador1(Double.parseDouble(request.getParameter("operador1")));
			c.setOperacao(request.getParameter("operacao"));
			c.setOperador2(Double.parseDouble(request.getParameter("operador2")));
			
			c.calcular();
			
			//Define um objeto no request que pode ser usado no JSP.
			request.setAttribute("resultado", c.getResultadoFormatado());

		}
		// Pedir para o JSP mostrar o resultado.
		request
			.getRequestDispatcher("calculadora-servlet.jsp")
			.forward(request, response);

	}

}
