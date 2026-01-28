package com.dp.assign1;

/*
Student Name: Daniel Perusse
Student ID: 200551990
Student Email: 200551990@student.georgianc.on.ca
COMP3026 - Application Security Programming
*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	// add var for out data access object
	private RegisterDao rtDao;
	private static final long serialVersionUID = 1L;
	
	public void init() {
		rtDao = new RegisterDao();
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name"); 
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String postal_code = request.getParameter("postal");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String[] language = request.getParameterValues("language");
		String about = request.getParameter("about");
		
		RegisterForm rf = new RegisterForm();
		rf.setUser_id(userId);
		rf.setPassword(password);
		rf.setName(name);
		rf.setAddress(address);
		rf.setCountry(country);
		rf.setPostal_code(postal_code);
		rf.setEmail(email);
		rf.setSex(sex);
		rf.setLanguage(language);
		rf.setAbout(about);
		
		try {
			
		//attempt to use our dao to push the form data to db
		rtDao.registerForm(rf);
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
