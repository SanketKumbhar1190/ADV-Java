package org.boot.BootJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "categoryname")
    private String categoryName;

    @Column(name = "categorydescription")
    private String categoryDescription;

    @Column(name = "categoryimageurl")
    private String categoryImageUrl;

    public Category() {
    }

    public Category(String categoryName, String categoryDescription, String categoryImageUrl) {
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