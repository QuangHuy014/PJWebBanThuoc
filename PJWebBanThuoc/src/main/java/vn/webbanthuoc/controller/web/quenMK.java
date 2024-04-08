package vn.webbanthuoc.controller.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.KhachHang;
import test.KhachHangDao;
import test.NhanVien;
import test.NhanVienDao;

/**
 * Servlet implementation class quenMK
 */
@WebServlet({"/quenMK","/xacthuc","/DangNhapMoi"})
public class quenMK extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    private NhanVienDao nvDao;
    private KhachHangDao khDao;
    
    public void init() {
        nvDao = new NhanVienDao();
        khDao = new KhachHangDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/quenMK":
                try {
                    quenMK(request, response);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case "/xacthuc":
                try {
                    xacthuc(request, response);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case "/DangNhapMoi":
                try {
                    DangNhapMoi(request, response);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
        }
    }   
    
    private void quenMK(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
    	
    	 request.getRequestDispatcher("/views/web/quenmk.jsp").forward(request, response);
    }
 
    
    
    
   
    
    private void xacthuc(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
       
    }
    

    private void DangNhapMoi(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
    	request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
    }   
}
