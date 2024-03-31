package vn.webbanthuoc.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.webbanthuoc.entity.Thuoc;
import vn.webbanthuoc.entity.hoaDon;
import vn.webbanthuoc.entity.hoaDonChiTiet;
import vn.webbanthuocdao.dao.implement.thuocDao;

/**
 * Servlet implementation class homeController
 */
@WebServlet({"/homeController","/product-Detail","/cart","/client/addToCart"})
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	thuocDao thuocdao=new thuocDao();
       
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
			case "/client/addToCart": {
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
	protected void doAddToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int soluong=1;
		String id;
		if(request.getParameter("thuocId")!=null) {
			id=request.getParameter("thuocId");
			Thuoc thuoc=thuocdao.findById(id);
			if(thuoc!=null) {
				if(request.getParameter("soluong")!=null) {
					soluong=Integer.parseInt(request.getParameter("soluong"));
				}
				HttpSession session=request.getSession();
				if(session.getAttribute("hoadon")==null) {
					hoaDon hd=new hoaDon();
					List<Thuoc> listThuocs=new ArrayList<Thuoc>();
					hoaDonChiTiet hdct=new hoaDonChiTiet();
					
				}
			}
		}
	}
	

}

