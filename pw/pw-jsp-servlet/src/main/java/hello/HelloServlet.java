package hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest req,
			HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getOutputStream().print(
				"<html>"
				+ "<head>"
				+ "<title>Hello!</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Hello</h1>"
				+ "</body>");

	}

}
