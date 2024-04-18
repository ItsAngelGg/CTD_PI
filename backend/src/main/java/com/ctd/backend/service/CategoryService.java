package com.ctd.backend.service;

import com.ctd.backend.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category saveCategory(Category category);
    Optional<Category> findCategoryById(Long id);
    Optional<Category> findCategoryByName(String name);
    void deleteCategory(Long id);
    void updateCategory(Category category);
    List<Category> getAllCategories();
}
