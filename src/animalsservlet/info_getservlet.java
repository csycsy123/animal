package animalsservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Animals.info;
import AnimalsDao.info_get;

/**
 * Servlet implementation class info_getservlet
 */
@WebServlet("/info_getservlet")
public class info_getservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");

		info_get info = new info_get();
		List<info> infos = info.Query();

		PrintWriter out = response.getWriter();
		JSONObject jo = null;
		JSONArray ja = new JSONArray();

		if (infos.size() > 0) {
			for (info info1 : infos) {
				jo = new JSONObject(info1);
				ja.put(jo);
			}
		}
		out.println(ja.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
