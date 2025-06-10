package day3.com.shopping.DAO;

import java.util.List;

public interface ShoppingDAO {
    /**
     * Authenticates user with username and password
     * @param username User's username
     * @param password User's password
     * @return true if authentication successful, false otherwise
     * @throws Exception if database error occurs
     */
    boolean authenticateUser(String username, String password) throws Exception;
    
    /**
     * Retrieves all categories from database
     * @return List of Category objects
     * @throws Exception if database error occurs
     */
    List<Category> getAllCategories() throws Exception;
    
    /**
     * Retrieves products by category ID
     * @param categoryId ID of the category
     * @return List of Product objects belonging to the category
     * @throws Exception if database error occurs
     */
    List<Product> getProductsByCategoryId(int categoryId) throws Exception;
    
    /**
     * Retrieves a specific category by ID
     * @param categoryId ID of the category
     * @return Category object or null if not found
     * @throws Exception if database error occurs
     */
    Category getCategoryById(int categoryId) throws Exception;
    
    /**
     * Retrieves a specific product by ID
     * @param productId ID of the product
     * @return Product object or null if not found
     * @throws Exception if database error occurs
     */
    Product getProductById(int productId) throws Exception;
}