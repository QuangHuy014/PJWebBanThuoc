package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.clazzImplement;
import entity.Clazz;

/**
 * Servlet implementation class accountController
 */
@WebServlet(urlPatterns = {"/accountController","/sign-in"})
public class accountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/account/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("/sign-in")) {
			doSignIn(request, response);
		} else if (uri.contains("sign-up")) {
//			doSignUp(request, response);
		}
//		else if (uri.contains("sign-out")) {
//			doSignOut(request, response);
//		} else if (uri.contains("edit-profile")) {
//			doEditProfile(request, response);
//		} else if (uri.contains("forgot-password")) {
//
//		} else if (uri.contains("change-password")) {
//
//		}
	}
	
	protected void doSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String method=request.getRequestURI();
		if (method.equalsIgnoreCase("POST")) {
			String user=request.getParameter("userName");
			String pass=request.getParameter("passWord");
			try {
				clazzImplement cl=new clazzImplement();
				Clazz clazz=cl.findById(user);
				if(!clazz.getPassword().equals(pass)) {
					request.setAttribute("message", "Invalid password!");
					System.out.println("fail");
				}else {
					request.setAttribute("message", "Sign-in successfully!");
					System.out.println("Sign-in successfully!");
//					request.getSession().setAttribute("user", user);
//					response.setHeader("Refresh", "1;url=/Slide5Java4Demo1/account/edit-profile");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
