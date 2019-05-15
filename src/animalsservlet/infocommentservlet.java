package animalsservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Animals.infocom;
import AnimalsDao.infocomment;

/**
 * Servlet implementation class infocommentservlet
 */
@WebServlet("/infocommentservlet")
public class infocommentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
				String type=request.getParameter("type");
				System.out.println(type);
				String comment=request.getParameter("comment");
				System.out.println(comment);
				infocom In=new infocom();
				In.setId(id);
				In.setType(type);
				In.setComment(comment);
				
				
				infocomment infocoms=new infocomment();
				try {
					infocoms.Addinfocom(In);
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
