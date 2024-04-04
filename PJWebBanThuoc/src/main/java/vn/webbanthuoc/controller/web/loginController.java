package vn.webbanthuoc.controller.web;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import test.User;
import test.UserDAO;

@WebServlet({"/Login","/homeController"})
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
				Login(request, response);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		case "/homeController":
			try {
				trangchu(request, response);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		}
	}

    private void trangchu(HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
		request.getRequestDispatcher("/views/web/trangchu.jsp").forward(request, response);
	}

	private void Login(HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
		UserDAO userDao = new UserDAO();
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (request.getParameter("buttonLogin") != null) {
				String tenDN = request.getParameter("tendangnhap");
				String pass = request.getParameter("matkhau");
				User user = userDao.findById(tenDN);
				if (!user.getMatkhau().equals(pass)) {
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
