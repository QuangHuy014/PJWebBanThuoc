package vn.webbanthuoc.controller.web;

import java.io.IOException;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
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
    	doGet(request, response);
    	
	}
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/Login":
                try {
                    login(request, response);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
//        UserDAO userDao = new UserDAO();
//        if (request.getMethod().equalsIgnoreCase("POST")) {
//            if (request.getParameter("buttonLogin") != null) {
//                String tenDangNhap = request.getParameter("tenDangNhap");
//                String matKhau = request.getParameter("matKhau");
//                User user = userDao.findById(tenDangNhap);
//                if (user == null || !user.getMatKhau().equals(matKhau)) {
//                    request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
//                    request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
//                } else {
//                    request.getSession().setAttribute("user", user);
//                    response.sendRedirect("/homeController");
//                }
//            }
//        }
    	UserDAO userDao = new UserDAO();
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (request.getParameter("buttonLogin") != null) {
				String tenDN = request.getParameter("tenDangNhap");
				String pass = request.getParameter("matKhau");
				User user = userDao.findById(tenDN);
				if (!user.getMatKhau().equals(pass)) {
					request.setAttribute("message", "Please fill right");
				} else {
					request.setAttribute("message", "Login succeed");
					request.getSession().setAttribute("user", user);
				}

			}

		}
		request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);

	}
    }

