package com.ctd.backend.service.impl;

import com.ctd.backend.model.Category;
import com.ctd.backend.repository.CategoryRepository;
import com.ctd.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
