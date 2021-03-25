package com.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algorithm.AES;
import com.constant.Constant;
import com.database.Database;
import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class User
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet implements Constant{

	private static final long serialVersionUID = 1L;
	private String user_name;
	private String password;
	private String url_path;
	private String user_type;
	User user;
	HttpSession session;
	RequestDispatcher requestDispatcher;
//	Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user_name = request.getParameter("email_id_text");
		password = request.getParameter("password_text");
		AES aes = new AES(ENCRYPTION_KEY);
//		aes.setKey(ENCRYPTION_KEY);
		aes.encrypt(user_name.trim());
		String emailEncrypt = aes.getEncryptedString();
		
		aes.encrypt(password.trim());
		String passwordEncrypt = aes.getEncryptedString();
		
		session = request.getSession(true);
		user = new User();
		user.setEmailId(emailEncrypt);
		user.setPassword(passwordEncrypt);
		
		UserService userService = new UserServiceImpl();
		
		if (userService.isUser(user)) {
			
			User findUser = userService.findByEmailId(user.getEmailId());
			
			if(findUser.getUserType().equals("Manager")) {
			url_path = "./home.jsp";
			session.setAttribute("msg", "you're logged in successfully.");
			session.setAttribute("flag", "1");
			session.setAttribute("user_name_session", user_name);
			session.setAttribute("user_type", findUser.getUserType());
			session.setAttribute("user_id_session",findUser.getUserId());
			}else if(findUser.getUserType().equals("User")) {
				url_path = "./user_home.jsp";
				session.setAttribute("msg", "you're logged in successfully.");
				session.setAttribute("flag", "1");
				session.setAttribute("user_name__session", user_name);
				session.setAttribute("user__type", findUser.getUserType());
				session.setAttribute("user_id__session",findUser.getUserId());
			}
		} else {
			url_path = "./login.jsp";
			session.setAttribute("flag", "0");
			session.setAttribute("msg", "Please check  User name and Password.");
		}
		requestDispatcher = request.getRequestDispatcher(url_path);
		requestDispatcher.forward(request, response);
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
