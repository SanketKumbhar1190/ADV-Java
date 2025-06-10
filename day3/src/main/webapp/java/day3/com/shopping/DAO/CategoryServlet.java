package day3.com.shopping.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShoppingDAO shoppingDAO;
    
    @Override
    public void init() throws ServletException {
        shoppingDAO = new ShoppingDAOImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("uname") != null) {
            String name = (String) session.getAttribute("uname");
            
            try {
                List<Category> categories = shoppingDAO.getAllCategories();
                
                // Enhanced HTML output with styling
                out.println("<!DOCTYPE html>");
                out.println("<html><head>");
                out.println("<title>Product Categories</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }");
                out.println(".header { background-color: #4CAF50; color: white; padding: 15px; border-radius: 5px; margin-bottom: 20px; }");
                out.println(".category-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(300px, 1fr)); gap: 20px; }");
                out.println(".category-card { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
                out.println(".category-card h3 { color: #333; margin-top: 0; }");
                out.println(".category-card p { color: #666; }");
                out.println(".view-products-btn { background-color: #008CBA; color: white; padding: 10px 15px; text-decoration: none; border-radius: 5px; display: inline-block; margin-top: 10px; }");
                out.println(".view-products-btn:hover { background-color: #007B9A; }");
                out.println(".logout-btn { background-color: #f44336; color: white; padding: 8px 12px; text-decoration: none; border-radius: 3px; float: right; }");
                out.println("</style>");
                out.println("</head><body>");
                
                out.println("<div class='header'>");
                out.println("<h2>Welcome, " + name + "!</h2>");
                out.println("<a href='#' class='logout-btn'>Logout</a>");
                out.println("<div style='clear: both;'></div>");
                out.println("</div>");
                
                out.println("<h3>Product Categories</h3>");
                
                if (categories != null && !categories.isEmpty()) {
                    out.println("<div class='category-grid'>");
                    for (Category category : categories) {
                        out.println("<div class='category-card'>");
                        out.println("<h3>" + category.getCategoryName() + "</h3>");
                        out.println("<p>" + (category.getCategoryDescription() != null ? 
                                   category.getCategoryDescription() : "No description available") + "</p>");
                        out.println("<a href='products?categoryId=" + category.getCategoryId() + 
                                   "' class='view-products-btn'>View Products</a>");
                        out.println("</div>");
                    }
                    out.println("</div>");
                } else {
                    out.println("<p>No categories available at the moment.</p>");
                }
                
                out.println("</body></html>");
                
            } catch (Exception e) {
                out.println("<h3>Error loading categories: " + e.getMessage() + "</h3>");
                e.printStackTrace();
            }
        } else {
            out.println("<h3>Please login first.</h3>");
            response.sendRedirect("login.html");
        }
    }
}