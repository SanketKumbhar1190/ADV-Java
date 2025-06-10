//package day3.com.shopping; // Package declaration
//
//// Import necessary servlet and JDBC classes
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
//// Servlet annotation to map the servlet to URL pattern "/Category"
//@WebServlet("/Category")
//public class Category extends HttpServlet {
//	private static final long serialVersionUID = 1L; // Serialization ID
//
//	// Default constructor
//	public Category() {
//		super();
//	}
//
//	// Handles HTTP GET requests
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		// Declare JDBC and output stream variables
//		Connection dbConnection = null;
//		PreparedStatement psGetCategory = null;
//		ResultSet resultCategory = null;
//		PrintWriter out = response.getWriter(); // To write HTML response
//
//		// Start generating HTML output
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<table border='1'>");
//		out.println("<tr>");
//		out.println("<th>Name</th>");
//		out.println("<th>Description</th>");
//		out.println("<th>Image</th>");
//		out.println("</tr>");
//
//		try {
//			// Load MySQL JDBC driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// Establish connection to the database
//			dbConnection = DriverManager.getConnection(
//				"jdbc:mysql://127.0.0.1:3306/advjavab2", "root", "root"
//			);
//
//			// Prepare SQL statement to fetch all categories
//			psGetCategory = dbConnection.prepareStatement("SELECT * FROM category");
//
//			// Execute the query
//			resultCategory = psGetCategory.executeQuery();
//
//			// Iterate through the result set
//			while (resultCategory.next()) {
//				out.println("<tr>");
//				// Create a link to 'products' servlet passing the categoryId as query parameter
//				out.println("<td><a href='products?categoryId=" 
//					+ resultCategory.getInt("categoryId") + "'>"
//					+ resultCategory.getString("categoryName") + "</a></td>");
//
//				// Display category description
//				out.println("<td>" + resultCategory.getString("categoryDescription") + "</td>");
//
//				// Display category image
//				out.println("<td><img src='" 
//					+ resultCategory.getString("categoryImageUrl") 
//					+ "' height='60px' width='60px' /></td>");
//				out.println("</tr>");
//			}
//
//			// End of HTML content
//			out.println("</table>");
//			out.println("</body>");
//			out.println("</html>");
//
//		} catch (ClassNotFoundException e) {
//			// Handle JDBC driver not found error
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// Handle SQL related errors
//			e.printStackTrace();
//		} finally {
//			// Clean up JDBC resources
//			try {
//				if (resultCategory != null)
//					resultCategory.close();
//				if (psGetCategory != null)
//					psGetCategory.close();
//				if (dbConnection != null)
//					dbConnection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
