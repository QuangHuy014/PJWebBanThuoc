package vn.webbanthuoc.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/web/tranglogin.jsp");
		rd.forward(request, response);
	}	

       
	/*
	 * @Override protected void doGet(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * RequestDispatcher rd =
	 * request.getRequestDispatcher("views/web/tranglogin.jsp"); rd.forward(request,
	 * response); }
	 */	
	

//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		String uri = req.getRequestURI();
//		if(uri.contains("sign-in")) {
//			this.doSignIn(req,resp);
//		}
//		else if (uri.contains("sign-up")) {
//			this.doSignUp(req,resp);
//		}
//		else if(uri.contains("sign-out")) {
//			this.doSignOut(req,resp);
//		}
//		else if(uri.contains("forgot-password")) {
//			this.doForgot(req,resp);
//		}
//		else if(uri.contains("change-password")) {
//			this.doChange(req,resp);
//		}
//		else if(uri.contains("edit-profile")) {
//			this.doEdit(req,resp);
//		}
//	}
//
//		private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//			String method = req.getMethod();
//			if(method.equalsIgnoreCase("POST")) {
//				String id = req.getParameter("username");
//				String pass = req.getParameter("password");
//				try {
//					
//				}
//			}
				

				
				
			
		
	}
	
	


