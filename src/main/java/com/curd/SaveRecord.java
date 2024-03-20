package com.curd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DbConnection;

/**
 * Servlet implementation class SaveRecord
 */
public class SaveRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveRecord() {
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
		try {
//			if(DbConnection.getDbConnection()!=null) {
//				response.getWriter().append("Connected");
//			}
			String name,password,email,cnum;
			
			name = request.getParameter("name");
			password = request.getParameter("password");
			email = request.getParameter("email");
			cnum = request.getParameter("cnum");
			
			String insertQuery = "insert into student (st_name,st_password,st_email,st_cnum) values (?,?,?,?)";
			
			PreparedStatement preparedStatement = DbConnection.getDbConnection().prepareStatement(insertQuery);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,email);
			preparedStatement.setString(4,cnum);
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) {
				response.getWriter().append("Record Saved");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
