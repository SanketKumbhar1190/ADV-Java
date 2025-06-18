package org.boot.BootJPA.dto;

public class CategoryDTO {
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImageUrl;

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryName, String categoryDescription, String categoryImageUrl) {
        super();
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImageUrl = categoryImageUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
                + categoryDescription + ", categoryImageUrl=" + categoryImageUrl + "]";
    }
}