

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
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
    	super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("u");
		String pass = request.getParameter("p");
		RequestDispatcher rd = null;
		Usuario u = Usuarios.login(user, pass);
		if (u==null) {
			rd = request.getRequestDispatcher("/error.jsp");//Redirecciona para cargar la pag
		} else {
			
			HttpSession session = request.getSession();
			session.setAttribute("u", u);
			
			//Llama a Private Controller
			response.sendRedirect("/private");//@WebServlet("/private")
		}
		rd.forward(request, response);
	}

}
