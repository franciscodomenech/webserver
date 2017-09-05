

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.Articulos;
import model.Cliente;
import model.Clientes;
import model.ItemMenu;
import model.Menu;
import model.RowTable;

/**
 * Servlet implementation class PrivateController
 */
@WebServlet("/private")
public class PrivateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario user;
       
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
		
		HttpSession session = request.getSession();
		user = (Usuario) session.getAttribute("u");
		if(user==null)
			logout(request,response);
		else
			manageOp(request.getParameter("op"),request,response);
		
	}
	
	private void manageOp(String op,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ItemMenu> menu = Menu.get(user.get_tipo());
		int status = op==null?menu.get(0).getOp():Integer.parseInt(op);
		RequestDispatcher rd = request.getRequestDispatcher("/private.jsp");
		switch(status) {
		case ItemMenu.CLIENTES:
			showclientes(menu,request,response);
			break;
		case ItemMenu.ARTICULOS:
			showarts(menu,request,response);
			break;
		case ItemMenu.LOGOUT:
			logout(request,response);
			break;
		}
	}
	
	private void loadviewprivate(List<ItemMenu> menu,String[] strings,RowTable[] table,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/private.jsp");
		request.setAttribute("menu", menu);
		request.setAttribute("columns", strings);
		request.setAttribute("table", table);
		rd.forward(request, response);
	}
	
	private void showclientes(List<ItemMenu> menu,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Clientes clientes = new Clientes();
		loadviewprivate(menu,clientes.getColumns(),clientes.list(),request,response);
	}
	
	private void showarts(List<ItemMenu> menu,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Articulos articulos = new Articulos();
		if(user.get_tipo()==Usuario.ADMIN)
			loadviewprivate(menu,articulos.getColumns(),articulos.listAll(),request,response);
		else
			loadviewprivate(menu,articulos.getColumns(),articulos.filterCats(((Cliente)user).getPrefs()),request,response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		request.getSession().setAttribute("u", null);
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
