package vn.webbanthuoc.controller.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import test.KhachHang;
import test.KhachHangDao;



@WebServlet({"/DangKy","/DangNhap"})
public class dangkyController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/DangKy": 
			try {
				DangKy(request, response);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		case "/DangNhap":
			try {
				DangNhap(request, response);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		}
	}
   
    private void DangKy(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
        KhachHangDao khDao = new KhachHangDao();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            if (request.getParameter("buttonDangKy") != null) {
                KhachHang user = new KhachHang();
                
                // Kiểm tra và thiết lập giá trị từ form
                int idkhachhang = 0; // Giá trị mặc định
                String idkhachhangStr = request.getParameter("idkhachhang");
                if (idkhachhangStr != null && !idkhachhangStr.isEmpty()) {
                    try {
                        idkhachhang = Integer.parseInt(idkhachhangStr);
                    } catch (NumberFormatException e) {
                        // Xử lý nếu không thể chuyển đổi thành công
                        e.printStackTrace(); // In ra thông báo lỗi
                        // Hoặc có thể gửi thông báo lỗi cho người dùng
                    }
                }
                
                String tendangnhap = request.getParameter("tendangnhap");
                String matkhau = request.getParameter("matkhau");
                String ten = request.getParameter("ten");
                boolean gioitinh = "nam".equals(request.getParameter("gioitinh")); // Nếu "nam" thì true, ngược lại false
                
                // Thiết lập thông tin cho User
                user.setTendangnhap(tendangnhap);
                user.setMatkhau(matkhau);
                user.setTen(ten);
                user.setGioitinh(gioitinh);
                
                // Gọi hàm create để thêm User vào database
                khDao.create(user);
                
                // Chuyển hướng sang trang đăng nhập
                response.sendRedirect(request.getContextPath() + "/DangNhap");
                
                return; // Đảm bảo không tiếp tục thực thi sau khi chuyển hướng
            } else {
                request.setAttribute("message", "Đăng ký thất bại");
            }
        }
        request.getRequestDispatcher("/views/web/trangdangky.jsp").forward(request, response);
    }


    private void DangNhap(HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
    	request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
	}
}
    

