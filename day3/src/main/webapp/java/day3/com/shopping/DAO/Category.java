package day3.com.shopping.DAO;

public class Category {
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImageUrl;
    
    // Default constructor
    public Category() {}
    
    // Parameterized constructor
    public Category(int categoryId, String categoryName, String categoryDescription, String categoryImageUrl) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImageUrl = categoryImageUrl;
    }
    
    // Getters
    public int getCategoryId() {
        return categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public String getCategoryDescription() {
        return categoryDescription;
    }
    
    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }
    
    // Setters
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    
    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
    
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", categoryImageUrl='" + categoryImageUrl + '\'' +
                '}';
    }
}