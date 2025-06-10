//package day3.com.shopping;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * Servlet implementation class Authenticate
// */
//@WebServlet("/Authenticate")
//public class Authenticate extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest
//			request, HttpServletResponse response) throws ServletException,IOException{
//
//		PrintWriter out = response.getWriter();
//		String userName = request.getParameter("userName") ;
//		String password = request.getParameter("password");
//		Connection dbConnection= null;
//		PreparedStatement psAuthenticateUser = null;
//		ResultSet resultAuthenticate = null;
//		try {
//			Class.forName("com.mysq1.cj.jdbc.Driver");	
//			dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/advjavab2", "root", "cdac");
//
//			psAuthenticateUser = dbConnection.prepareStatement("select * from assign1 where username=? and password=?");
//			psAuthenticateUser.setString(1, userName);
//			psAuthenticateUser.setString(2, password);
//
//			resultAuthenticate = psAuthenticateUser.executeQuery();
//			if(resultAuthenticate.next())
//				response.sendRedirect("Category");
//			else
//				out.println("Invalid username password");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				if(resultAuthenticate!=null)
//					resultAuthenticate.close();
//				if(psAuthenticateUser != null)
//					psAuthenticateUser.close();
//				if(dbConnection !=null)
//					dbConnection.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//
