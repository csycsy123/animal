package animalsservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addressservlet
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseAccess(request, response);
		PrintWriter out = response.getWriter();
		out.println("DoOptions");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseAccess(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String messageFormat = "%s is empty";

		String username = request.getParameter("username");
		if (username == null || username.length() <= 0) {
			out.println(String.format(messageFormat, "username"));
			return;
		}
		String password = request.getParameter("password");
		if (password == null || password.length() <= 0) {
			out.println(String.format(messageFormat, "password"));
			return;
		}
		if (username.equals("csy") && password.equals("csy123")) {
			out.println(true);
			return;
		} else {
			out.println(false);
			return;
		}
	}

	private void setResponseAccess(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin",
				request.getHeader("Origin") == null ? "*" : request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Header", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		// 在999999秒内，不需要再发送预检验请求，可以缓存该结果
		response.setHeader("Access-Control-Max-Age", "999999");
	}

}
