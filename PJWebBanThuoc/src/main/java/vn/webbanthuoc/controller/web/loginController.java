package vn.webbanthuoc.controller.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.User;
import test.UserDAO;

@WebServlet("/Login")
public class loginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
            login(request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace(); // In ra stack trace để debug
            throw new ServletException("Error in login process", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/Login":
                request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
                break;
        }
    }

//    public void login(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        UserDAO userDao = new UserDAO();
//        String tenDangNhap = request.getParameter("tenDangNhap");
//        String matKhau = request.getParameter("matKhau");
//
//        User user = userDao.findById(tenDangNhap);
//
//        if (user == null || !user.getMatKhau().equals(matKhau)) {
//            request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
//            request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
//        } else {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + "/homeController");
//        }
//    }
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        UserDAO userDao = new UserDAO();
//        if (request.getMethod().equalsIgnoreCase("POST")) {
//            String tenDangNhap = request.getParameter("tenDangNhap");
//            String matKhau = request.getParameter("matKhau");
//            
//            User user = null;
//            try {
//                user = userDao.findById(tenDangNhap);
//            } catch (NoResultException e) {
//                // Xử lý khi không tìm thấy User
//                request.setAttribute("message", "Tên đăng nhập không tồn tại");
//                request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
//                return;
//            }
//            
//            if (user == null || !user.getMatKhau().equals(matKhau)) {
//                request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
//                request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
//            } else {
//                request.getSession().setAttribute("user", user);
//                response.sendRedirect("/homeController");
//            }
//        }
//    }
    	response.setContentType("text/html;charset=UTF-8");

        UserDAO userDao = new UserDAO();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            
            User user = userDao.checkLogin(tenDangNhap, matKhau);
            
            if (user == null) {
                request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
                request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/homeController");
            }
        }
}
}

