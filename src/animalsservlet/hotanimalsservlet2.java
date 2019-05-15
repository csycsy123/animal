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
import AnimalsDao.animals_selectid;
import AnimalsDao.animals_jin;


/**
 * Servlet implementation class animalsservlet
 */
@WebServlet("/Animals_hotservlet2")
public class hotanimalsservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html;charset=utf-8");


//		int id=2;
int id=Integer.parseInt(request.getParameter("id"));
System.out.println(id);
animals_selectid animal=new animals_selectid();
		List<Animals> animals=animal.Hot(id);
		
		PrintWriter out =response.getWriter();
		JSONObject jo=null;
		JSONArray ja=new JSONArray();
		
		if( animals.size()>0){
			for(Animals animal1:animals){
				jo=new JSONObject(animal1);
				ja.put(jo);
			}
		}
		out.println(ja.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
