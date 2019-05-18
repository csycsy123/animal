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

import Animals.infocom;

import AnimalsDao.infocomment_get;

/**
 * Servlet implementation class infocomment_getservlet
 */
@WebServlet("/infocomment_getservlet")
public class infocomment_getservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		infocomment_get info = new infocomment_get();
		List<infocom> infocoms = info.Query(id);

		PrintWriter out = response.getWriter();
		JSONObject jo = null;
		JSONArray ja = new JSONArray();

		if (infocoms.size() > 0) {
			for (infocom infocom1 : infocoms) {
				jo = new JSONObject(infocom1);
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
