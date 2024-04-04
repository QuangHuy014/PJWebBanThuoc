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


import test.User;
import test.UserDAO;



@WebServlet("/Dangky")
public class dangkyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Hiển thị form đăng ký
    	RequestDispatcher rd = request.getRequestDispatcher("/views/web/trangdangky.jsp");
		rd.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        }
    }
    private void DangKy(HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
		UserDAO userDao = new UserDAO();
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (request.getParameter("buttonDangKy") != null) {
				User user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				userDao.create(user);
				request.setAttribute("message", "Đăng ký thành công");
				response.setHeader("Refresh", "1;url=/PJWebBanThuoc/Dangky");
			} else {
				request.setAttribute("message", "Đăng ký thất bại");
			}
		}
		request.getRequestDispatcher("/views/web/tranglogin.jsp").forward(request, response);
	}
}

