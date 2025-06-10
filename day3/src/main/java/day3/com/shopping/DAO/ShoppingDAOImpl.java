package day3.com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDAOImpl implements ShoppingDAO {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/advjavab2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }
    
    /**
     * Get database connection
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    @Override
    public boolean authenticateUser(String username, String password) throws Exception {
        String sql = "SELECT * FROM assign1 WHERE username = ? AND password = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    @Override
    public List<Category> getAllCategories() throws Exception {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category ORDER BY categoryId";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Category category = new Category(
                    rs.getInt("categoryId"),
                    rs.getString("categoryName"),
                    rs.getString("categoryDescription"),
                    rs.getString("categoryImageUrl")
                );
                categories.add(category);
            }
        }
        return categories;
    }
    
    @Override
    public List<Product> getProductsByCategoryId(int categoryId) throws Exception {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE categoryID = ? ORDER BY productID";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, categoryId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product(
                        rs.getInt("productID"),
                        rs.getString("productNAME"),
                        rs.getString("productDESCRIPTION"),
                        rs.getDouble("productPRICE"),
                        rs.getString("productIMAGEURL"),
                        rs.getInt("categoryID")
                    );
                    products.add(product);
                }
            }
        }
        return products;
    }
    
    @Override
    public Category getCategoryById(int categoryId) throws Exception {
        String sql = "SELECT * FROM category WHERE categoryId = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, categoryId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Category(
                        rs.getInt("categoryId"),
                        rs.getString("categoryName"),
                        rs.getString("categoryDescription"),
                        rs.getString("categoryImageUrl")
                    );
                }
            }
        }
        return null;
    }
    
    @Override
    public Product getProductById(int productId) throws Exception {
        String sql = "SELECT * FROM products WHERE productID = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, productId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                        rs.getInt("productID"),
                        rs.getString("productNAME"),
                        rs.getString("productDESCRIPTION"),
                        rs.getDouble("productPRICE"),
                        rs.getString("productIMAGEURL"),
                        rs.getInt("categoryID")
                    );
                }
            }
        }
        return null;
    }
}