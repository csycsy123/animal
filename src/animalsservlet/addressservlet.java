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
import Animals.addcall;
import AnimalsDao.address;
import AnimalsDao.animals_cat;

/**
 * Servlet implementation class addressservlet
 */
@WebServlet("/Addressservlet")
public class addressservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		address add=new address();
				List<addcall> adds=add.Query();
				
				PrintWriter out =response.getWriter();
				JSONObject jo=null;
				JSONArray ja=new JSONArray();
				
				if( adds.size()>0){
					for(addcall ad:adds){
						jo=new JSONObject(ad);
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
