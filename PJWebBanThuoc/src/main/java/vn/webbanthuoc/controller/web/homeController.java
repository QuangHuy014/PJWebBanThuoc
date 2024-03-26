package vn.webbanthuoc.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class homeController
 */
@WebServlet({"/homeController","/product-Detail","/cart"})
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("/views/web/trangchu.jsp");
//		rd.forward(request, response);
		String action=request.getServletPath();
		try {
			switch (action) {
			case "/homeController": {
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/trangchu.jsp");
				rd.forward(request, response);
				break;
			}
			case "/product-Detail": {
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/productDetail.jsp");
				rd.forward(request, response);
				break;
			}
			case "/cart": {
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
				rd.forward(request, response);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
