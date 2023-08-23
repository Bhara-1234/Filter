package example;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoServlet
 */
@WebServlet("/AutoServlet")
public class AutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("userid");
		String  password=request.getParameter("password");
		Jdbc jb=new Jdbc(user, password);
		HashMap<String,String> userdetails = jb.getHash();
		if(userdetails.containsKey(user) && userdetails.get(user)== password) {
			RequestDispatcher rd =  request.getRequestDispatcher("http://localhost:8089/TicketBookings/");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd =  request.getRequestDispatcher("response.jsp");
			rd.forward(request, response);
		}
	}

}
