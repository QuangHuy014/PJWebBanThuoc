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
				doAddToCart(request, response);
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
		int soLuong = 1;
		String id;
		if (request.getParameter("thuocId") != null) {
		    id = request.getParameter("thuocId");
		    Thuoc thuoc = thuocdao.findById(id);
		    if (thuoc != null) {
		        if (request.getParameter("soluong") != null) {
		            soLuong = Integer.parseInt(request.getParameter("soluong"));
		        }
		        HttpSession session = request.getSession();
		        hoaDon hoadon =new hoaDon();
		        if (session.getAttribute("gioHang") == null) {
		          List<hoaDonChiTiet> listcthds=new ArrayList<hoaDonChiTiet>();
		          hoaDonChiTiet hdct=new hoaDonChiTiet();
				     // Tính toán và thiết lập giá, thành tiền, v.v. cho mục hàng
				        double gia = thuoc.getGia();
				        double thanhTien = gia * soLuong;
				        String donVi = thuoc.getDonVi();
//				        hdct.setIdThuoc(String.valueOf(id));
				        hdct.setTenThuoc(thuoc.getTen());
				        hdct.setGia(gia);
				        hdct.setThanhTien(thanhTien);
				        hdct.setDonVi(donVi);
				        	
		            session.setAttribute("gioHang", hoadon);
		        } else {
		         hoaDon hoadon2 = (hoaDon) session.getAttribute("gioHang");
		            List<hoaDonChiTiet> listcthds=hoadon2.getChiTietHoaDonList();
		            boolean check=false;
		            for(hoaDonChiTiet hdct:listcthds) {
		            	if(hdct.getIdThuoc()==thuoc.getIdThuoc()) {
		            			hdct.setSoLuong(hdct.getSoLuong()+soLuong);
		            			check=true;
		            	}
		            	if(check=false) {
		            		hoaDonChiTiet hdct2=new hoaDonChiTiet();
		            		hdct.setSoLuong(soLuong);
		            		hdct.setTenThuoc(thuoc.getTen());
		            		hdct.setGia(thuoc.getGia());
		            		listcthds.add(hdct2);
		            	}
		            	session.setAttribute("gioHang", listcthds);
		            }
		        }
		      
		    
		    }
		}

	}
	

}

