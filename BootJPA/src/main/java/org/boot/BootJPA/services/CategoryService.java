package org.boot.BootJPA.services;


import java.util.Iterator;

import org.boot.BootJPA.dto.CategoryDTO;

public interface CategoryService {
    Iterator<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(int categoryId);
}