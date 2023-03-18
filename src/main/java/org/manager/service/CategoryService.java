package org.manager.service;

import org.manager.dto.CategoryDto;
import org.manager.entity.Category;
import org.manager.repository.CategoryRepository;


public class CategoryService {

    private static final CategoryRepository categoryRepository = new CategoryRepository();

    public void addCategory(String categoryName) {
        if (categoryName != null && categoryName.length() > 2) {
            Category category = new Category();
            category.setName(categoryName);
            categoryRepository.insert(category);
        } else {
            throw new IllegalArgumentException("Category name should contain at least two characters!");
        }
    }

    public CategoryDto getByName(String categoryName) {
        if (categoryName != null && categoryName.length() > 2) {
            Category category = categoryRepository.findByName(categoryName);
            if (category != null) {
                CategoryDto categoryDto = new CategoryDto(category.getId(), category.getName());
                return categoryDto;
            } else {
                throw new IllegalArgumentException("Category with name " + categoryName + "not exists");
            }
        } else {
            throw new IllegalArgumentException("Category name should contain at least two characters!");
        }
    }
}
