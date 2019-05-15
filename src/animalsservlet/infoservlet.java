package animalsservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Animals.info;
import AnimalsDao.infoform;

/**
 * Servlet implementation class addressservlet
 */
@WebServlet("/Infoservlet")
public class infoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
				String address=request.getParameter("address");
				String name=request.getParameter("name");
				String description=request.getParameter("description");
				String sex=request.getParameter("sex");
				String image=request.getParameter("image");
				String specise=request.getParameter("specise");
				String weight=request.getParameter("weight");
				info In=new info();
				In.setAddress(address);
				In.setName(name);
				In.setDescription(description);
				In.setImage(image);
				In.setSex(sex);
				In.setWeight(weight);
				In.setSpecise(specise);
				infoform infos=new infoform();
				try {
					infos.Addinfo(In);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			PrintWriter out =response.getWriter();
			out.println(true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
