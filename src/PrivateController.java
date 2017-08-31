

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.Usuarios;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/private") //Se encarga de todas las llamadas de /private
public class PrivateController extends HttpServlet {
	private static final long serialVersionUID = 2L;
	

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
		
		RequestDispatcher rd = null;
		
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("u");
		if(user==null) {
			
			rd = request.getRequestDispatcher("/login.jsp");
		}
		else {
			int tipo =user.get_tipo();
			
		}
		//dependiendo de la sesion coge un menu u otro
		
		
	}
	
}
