package day3.com.shopping.DAO;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImageUrl;
    private int categoryId;
    
    // Default constructor
    public Product() {}
    
    // Parameterized constructor
    public Product(int productId, String productName, String productDescription, 
                   double productPrice, String productImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
    }
    
    // Full constructor with categoryId
    public Product(int productId, String productName, String productDescription, 
                   double productPrice, String productImageUrl, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
        this.categoryId = categoryId;
    }
    
    // Getters
    public int getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getProductDescription() {
        return productDescription;
    }
    
    public double getProductPrice() {
        return productPrice;
    }
    
    public String getProductImageUrl() {
        return productImageUrl;
    }
    
    public int getCategoryId() {
        return categoryId;
    }
    
    // Setters
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    
    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}