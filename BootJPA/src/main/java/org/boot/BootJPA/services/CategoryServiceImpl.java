package org.boot.BootJPA.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.boot.BootJPA.dto.CategoryDTO;
import org.boot.BootJPA.entity.Category;
import org.boot.BootJPA.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public Iterator<CategoryDTO> getAllCategories() {
        Iterator<Category> iterEntity = categoryRepo.findAll().iterator();
        ArrayList<CategoryDTO> listCategory = new ArrayList<>();
        while (iterEntity.hasNext()) {
            CategoryDTO dto = new CategoryDTO();
            BeanUtils.copyProperties(iterEntity.next(), dto); // Entity to POJO
            listCategory.add(dto);
        }
        return listCategory.iterator();
    }

    @Override
    public CategoryDTO getCategoryById(int categoryId) {
        Optional<Category> oCategory = categoryRepo.findById(categoryId);
        if (!oCategory.isEmpty()) {
            CategoryDTO dto = new CategoryDTO();
            BeanUtils.copyProperties(oCategory.get(), dto); // POJO
            return dto;
        } else {
            return null;
        }
    }
}