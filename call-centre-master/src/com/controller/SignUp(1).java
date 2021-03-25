package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algorithm.AES;
import com.constant.Constant;
import com.constant.ConstantMethod;
import com.database.Database;
import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet implements Constant {
	private static final long serialVersionUID = 1L;
	String url_path;
	HttpSession session;
	Connection connection;
	RequestDispatcher rd;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(true);

		String fullName = request.getParameter("full_name_text");
		String mobileNumber = request.getParameter("mobile_number_text");
		String emailId = request.getParameter("email_id_text");
		String password = request.getParameter("password_text");
		
		String userType = request.getParameter("user_type");
		String productName = request.getParameter("product_name");
		
		
		AES aes = new AES(ENCRYPTION_KEY);
		/**
		 * ENCRYPT EMAIL
		 */
//		aes.setKey(ENCRYPTION_KEY);
		aes.encrypt(emailId.trim());
		String emailEncrypted = aes.getEncryptedString();
		System.out.println("Email enc:: "+emailEncrypted);
		/**
		 * ENCRYPT PASSWORD
		 */
		aes.encrypt(password.trim());
		String passwordEncypted = aes.getEncryptedString();
		
		System.out.println("Password enc :: "+passwordEncypted);
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setFullName(fullName);
		user.setMobileNumber(mobileNumber);
		user.setEmailId(emailEncrypted);
		user.setPassword(passwordEncypted);
		user.setRegDate(ConstantMethod.getCurrentDateAndTime());
		user.setUserType(userType);
		user.setProductName(productName);

		if (userService.isRegisterUser(user)) {
			session.setAttribute("msg", "User already registred.");
			session.setAttribute("flag", "0");
			url_path = "./signup.jsp";
		} else {
			if (userService.isRegister(user)) {
				session.setAttribute("msg", "You have registred successfully.");
				session.setAttribute("flag", "1");
				url_path = "./login.jsp";
			} else {
				session.setAttribute("msg", "Somthing is wrong please try again");
				session.setAttribute("falg", "0");
				url_path = "./signup.jsp";
			}

		}
		rd = request.getRequestDispatcher(url_path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}
