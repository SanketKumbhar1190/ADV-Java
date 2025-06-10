package day3.com.shopping.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database configuration constants  jdbc:mysql://127.0.0.1:3306/?user=root
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/advjavab2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Input validation
        if (userName == null || userName.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            out.println("<h3>Username and password are required.</h3>");
            out.println("<a href='login.html'>Go back to login</a>");
            return;
        }
        
        Connection dbConnection = null;
        PreparedStatement psAuthenticateUser = null;
        ResultSet resultAuthenticate = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            psAuthenticateUser = dbConnection.prepareStatement(
                "SELECT * FROM assign1 WHERE username = ? AND password = ?");
            psAuthenticateUser.setString(1, userName.trim());
            psAuthenticateUser.setString(2, password);
            
            resultAuthenticate = psAuthenticateUser.executeQuery();
            
            if (resultAuthenticate.next()) {
                // Create session for authenticated user
                HttpSession session = request.getSession();
                session.setAttribute("uname", userName.trim());
                session.setMaxInactiveInterval(30 * 60); // 30 minutes
                
                response.sendRedirect("CategoryServlet");
            } else {
                out.println("<h3>Invalid username or password.</h3>");
                out.println("<a href='login.html'>Try again</a>");
            }
            
        } catch (ClassNotFoundException e) {
            out.println("<h3>Database driver not found.</h3>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("<h3>Database connection error.</h3>");
            e.printStackTrace();
        } finally {
            // Proper resource cleanup
            try {
                if (resultAuthenticate != null) {
                    resultAuthenticate.close();
                }
                if (psAuthenticateUser != null) {
                    psAuthenticateUser.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}