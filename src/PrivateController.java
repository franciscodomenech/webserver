

import java.awt.MenuItem;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet implementation class PrivateController
 */
@WebServlet("/private")
public class PrivateController extends HttpServlet {
	private int opcionArticulos=0;
	private int cerrarSesion=1;
	private int usuarios=2;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivateController() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/private.jsp");
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("u");
		
		ArrayList<MenuItem> menu=new ArrayList<>();
		
		menu.add(new MenuItem("ARTICULOS"));
		menu.add(new MenuItem("CERRAR SESION"));

		if (user.get_tipo()==0)
			menu.add(new MenuItem("USUARIOS"));
		
		String op = request.getParameter("op");
		if(op==null)
			request.setAttribute("op", -1);
		else
			request.setAttribute("op", op);
		
		request.setAttribute("menu", menu);
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
