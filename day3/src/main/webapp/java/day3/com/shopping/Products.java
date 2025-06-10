//package day3.com.shopping; // Package declaration
//
//// Importing servlet and JDBC packages
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
//// Servlet annotation to map URL "/products" to this servlet
//@WebServlet("/products")
//public class Products extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    // Handles HTTP GET requests
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        Connection dbConnection = null;
//        PreparedStatement psProducts = null;
//        ResultSet resultProducts = null;
//
//        PrintWriter out = response.getWriter(); // To write HTML output
//
//        // Start building the HTML page
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<table border='1'>");
//        out.println("<tr>");
//        out.println("<th>ID</th>");
//        out.println("<th>Name</th>");
//        out.println("<th>Description</th>");
//        out.println("<th>Price</th>");
//        out.println("<th>Image</th>");
//        out.println("</tr>");
//
//        try {
//            // Get the categoryId from the request parameters
//            String tmpID = request.getParameter("categoryId");
//
//            // If the parameter is missing or empty, show error and exit
//            if (tmpID == null || tmpID.trim().isEmpty()) {
//                out.println("<p>Error: Category ID is missing.</p>");
//                out.println("</table>");
//                out.println("</body>");
//                out.println("</html>");
//                return;
//            }
//
//            // Try converting categoryId to integer
//            int categoryID;
//            try {
//                categoryID = Integer.parseInt(tmpID);
//            } catch (NumberFormatException e) {
//                out.println("<p>Error: Invalid Category ID.</p>");
//                out.println("</table>");
//                out.println("</body>");
//                out.println("</html>");
//                return;
//            }
//
//            // Load MySQL JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Connect to the database
//            dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/advjavab2", "root", "root");
//
//            // Prepare SQL query to get products for given categoryId
//            psProducts = dbConnection.prepareStatement("SELECT * FROM products WHERE categoryID = ?");
//            psProducts.setInt(1, categoryID); // Set the categoryID parameter
//
//            // Execute the query
//            resultProducts = psProducts.executeQuery();
//
//            // Display the product records in the HTML table
//            while (resultProducts.next()) {
//                out.println("<tr>");
//                out.println("<td>" + resultProducts.getString("productID") + "</td>");
//                out.println("<td>" + resultProducts.getString("productNAME") + "</td>");
//                out.println("<td>" + resultProducts.getString("productDESCRIPTION") + "</td>");
//                out.println("<td>" + resultProducts.getString("productPRICE") + "</td>");
//                out.println("<td><img src='" + resultProducts.getString("productIMAGEURL") + "' height='60px' width='60px' /></td>");
//                out.println("</tr>");
//            }
//
//            // End of HTML
//            out.println("</table>");
//            out.println("</body>");
//            out.println("</html>");
//
//        } catch (ClassNotFoundException e) {
//            // If JDBC driver is not found
//            e.printStackTrace();
//        } catch (SQLException e) {
//            // If SQL error occurs
//            e.printStackTrace();
//        } finally {
//            // Clean up resources
//            try {
//                if (resultProducts != null)
//                    resultProducts.close();
//                if (psProducts != null)
//                    psProducts.close();
//                if (dbConnection != null)
//                    dbConnection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
