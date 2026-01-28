package com.dp.assign1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
Student Name: Daniel Perusse
Student ID: 200551990
Student Email: 200551990@student.georgianc.on.ca
COMP3026 - Application Security Programming
*/

public class RegisterDao {
	
	public int registerForm(RegisterForm registerForm) throws ClassNotFoundException {
		
		String INSERT_USERS_SQL = "INSERT INTO RegisteredUsers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasecdb", "root", "HorseSt@pler12")) {
			
			//setting up our prepared statement and getting all the form data
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
			ps.setString(1, registerForm.getUser_id());
			ps.setString(2, registerForm.getPassword());
			ps.setString(3, registerForm.getName());
			ps.setString(4, registerForm.getAddress());
			ps.setString(5, registerForm.getCountry());
			ps.setString(6, registerForm.getPostal_code());
			ps.setString(7, registerForm.getEmail());
			ps.setString(8, registerForm.getSex());
			//special logic for language once again
			if (registerForm.getLanguage().length == 2 ) {
				ps.setString(9, "Both");
			} else {
				ps.setString(9, registerForm.getLanguage()[0]);
			}
			ps.setString(10, registerForm.getAbout());
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		return 0;
	}
	
}

