

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemMenu;
import model.Usuario;
import model.Menu;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/private") //Se encarga de todas las llamadas de /private
public class PrivateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	
	

    /**
     * Default constructor. 
     */
    public PrivateController() {
    	super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("u");
		
		if(user==null) {
			
			rd = request.getRequestDispatcher("/login.jsp");
		}
		else {
			
			rd = request.getRequestDispatcher("/private.jsp");
			
			
			request.setAttribute("menu", new Menu(user).createMenu());

			
		}
		rd.forward(request, response);
		
	}

	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}
	
}
