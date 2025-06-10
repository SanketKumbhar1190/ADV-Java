package day3.com.shopping.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
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
        
        // Check session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("uname") == null) {
            response.sendRedirect("login.html");
            return;
        }
        
        String userName = (String) session.getAttribute("uname");
        String categoryIdParam = request.getParameter("categoryId");
        
        // Enhanced HTML output with styling
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Products</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }");
        out.println(".header { background-color: #4CAF50; color: white; padding: 15px; border-radius: 5px; margin-bottom: 20px; }");
        out.println("table { border-collapse: collapse; width: 100%; background: white; border-radius: 5px; overflow: hidden; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; font-weight: bold; }");
        out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
        out.println("img { max-width: 60px; max-height: 60px; border-radius: 5px; }");
        out.println(".price { font-weight: bold; color: #4CAF50; }");
        out.println(".back-btn { background-color: #008CBA; color: white; padding: 8px 12px; text-decoration: none; border-radius: 3px; margin-right: 10px; }");
        out.println(".error { color: #f44336; background-color: #ffebee; padding: 15px; border-radius: 5px; margin: 20px 0; }");
        out.println("</style>");
        out.println("</head><body>");
        
        out.println("<div class='header'>");
        out.println("<h2>Products</h2>");
        out.println("<p>Welcome, " + userName + "!</p>");
        out.println("</div>");
        
        out.println("<a href='CategoryServlet' class='back-btn'>Back to Categories</a>");
        out.println("<br><br>");
        
        if (categoryIdParam == null || categoryIdParam.trim().isEmpty()) {
            out.println("<div class='error'>Error: Category ID is missing.</div>");
        } else {
            try {
                int categoryId = Integer.parseInt(categoryIdParam);
                List<Product> products = shoppingDAO.getProductsByCategoryId(categoryId);
                
                if (products != null && !products.isEmpty()) {
                    out.println("<table>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Description</th><th>Price</th><th>Image</th></tr>");
                    
                    for (Product product : products) {
                        out.println("<tr>");
                        out.println("<td>" + product.getProductId() + "</td>");
                        out.println("<td>" + product.getProductName() + "</td>");
                        out.println("<td>" + (product.getProductDescription() != null ? 
                                   product.getProductDescription() : "No description") + "</td>");
                        out.println("<td class='price'>$" + String.format("%.2f", product.getProductPrice()) + "</td>");
                        out.println("<td>");
                        if (product.getProductImageUrl() != null && !product.getProductImageUrl().trim().isEmpty()) {
                            out.println("<img src='" + product.getProductImageUrl() + 
                                       "' alt='" + product.getProductName() + "' />");
                        } else {
                            out.println("No image");
                        }
                        out.println("</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else {
                    out.println("<div class='error'>No products found in this category.</div>");
                }
                
            } catch (NumberFormatException e) {
                out.println("<div class='error'>Error: Invalid Category ID format.</div>");
            } catch (Exception e) {
                out.println("<div class='error'>Error fetching products: " + e.getMessage() + "</div>");
                e.printStackTrace();
            }
        }
        
        out.println("</body></html>");
    }
}