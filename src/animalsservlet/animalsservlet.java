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

import Animals.Animals;
import AnimalsDao.animalsquery;

/**
 * Servlet implementation class animalsservlet
 */
@WebServlet("/Animalsservlet")
public class animalsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseAccess(request, response);
		PrintWriter out = response.getWriter();
		out.println("DoOptions");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseAccess(request, response);
		response.setContentType("text/html;charset=utf-8");

		animalsquery animal = new animalsquery();
		List<Animals> animals = animal.Query();

		PrintWriter out = response.getWriter();
		JSONObject jo = null;
		JSONArray ja = new JSONArray();

		if (animals.size() > 0) {
			for (Animals animal1 : animals) {
				jo = new JSONObject(animal1);
				ja.put(jo);
			}
		}
		out.println(ja.toString());

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
		String name = request.getParameter("name");
		if (name == null || name.length() <= 0) {
			out.println(String.format(messageFormat, "id"));
			return;
		}
		String cover = request.getParameter("cover");
		if (cover == null || cover.length() <= 0) {
			out.println(String.format(messageFormat, "cover"));
			return;
		}
		String description = request.getParameter("description");
		if (description == null || description.length() <= 0) {
			out.println(String.format(messageFormat, "description"));
			return;
		}
		String distanceStr = request.getParameter("distance");
		if (distanceStr == null || distanceStr.length() <= 0) {
			out.println(String.format(messageFormat, "distance"));
			return;
		}
		int distance = 0;
		try {
			distance = Integer.parseInt(distanceStr);
		} catch (Exception e) {
			out.println("distance is not a number");
			return;
		}
		String ageStr = request.getParameter("age");
		if (ageStr == null || ageStr.length() <= 0) {
			out.println(String.format(messageFormat, "age"));
			return;
		}
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (Exception e) {
			out.println("age is not a number");
			return;
		}
		String hotStr = request.getParameter("hot");
		if (hotStr == null || hotStr.length() <= 0) {
			out.println(String.format(messageFormat, "hot"));
			return;
		}
		int hot = 0;
		try {
			hot = Integer.parseInt(hotStr);
		} catch (Exception e) {
			out.println("hot is not a number");
			return;
		}
		Animals animal = new Animals();
		animal.setName(name);
		animal.setAge(age);
		animal.setCover(cover);
		animal.setDescription(description);
		animal.setHot(hot);
		animal.setDistance(distance);
		animalsquery aq = new animalsquery();
		out.println(aq.insert(animal));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseAccess(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String messageFormat = "%s is empty";

		String idStr = request.getParameter("id");
		if (idStr == null || idStr.length() <= 0) {
			out.println(String.format(messageFormat, "id"));
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			out.println("id is not a number");
			return;
		}
		String name = request.getParameter("name");
		if (name == null || name.length() <= 0) {
			out.println(String.format(messageFormat, "id"));
			return;
		}
		String cover = request.getParameter("cover");
		if (cover == null || cover.length() <= 0) {
			out.println(String.format(messageFormat, "cover"));
			return;
		}
		String description = request.getParameter("description");
		if (description == null || description.length() <= 0) {
			out.println(String.format(messageFormat, "description"));
			return;
		}
		String distanceStr = request.getParameter("distance");
		if (distanceStr == null || distanceStr.length() <= 0) {
			out.println(String.format(messageFormat, "distance"));
			return;
		}
		int distance = 0;
		try {
			distance = Integer.parseInt(distanceStr);
		} catch (Exception e) {
			out.println("distance is not a number");
			return;
		}
		String ageStr = request.getParameter("age");
		if (ageStr == null || ageStr.length() <= 0) {
			out.println(String.format(messageFormat, "age"));
			return;
		}
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (Exception e) {
			out.println("age is not a number");
			return;
		}
		String hotStr = request.getParameter("hot");
		if (hotStr == null || hotStr.length() <= 0) {
			out.println(String.format(messageFormat, "hot"));
			return;
		}
		int hot = 0;
		try {
			hot = Integer.parseInt(hotStr);
		} catch (Exception e) {
			out.println("hot is not a number");
			return;
		}
		Animals animal = new Animals();
		animal.setId(id);
		animal.setName(name);
		animal.setAge(age);
		animal.setCover(cover);
		animal.setDescription(description);
		animal.setHot(hot);
		animal.setDistance(distance);
		animalsquery aq = new animalsquery();
		out.println(aq.update(animal));
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setResponseAccess(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String messageFormat = "%s is empty";

		String idStr = request.getParameter("id");
		if (idStr == null || idStr.length() <= 0) {
			out.println(String.format(messageFormat, "id"));
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			out.println("id is not a number");
			return;
		}

		animalsquery aq = new animalsquery();
		out.println(aq.delete(id));
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
