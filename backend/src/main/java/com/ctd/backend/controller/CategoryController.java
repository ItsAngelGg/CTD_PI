package com.ctd.backend.controller;

import com.ctd.backend.exceptions.DuplicatedValueException;
import com.ctd.backend.exceptions.ResourceNotFoundException;
import com.ctd.backend.model.Category;
import com.ctd.backend.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController (CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    /* Search methods */
    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Category> categoryRequired = categoryService.findCategoryById(id);
        if(categoryRequired.isPresent()) {
            return ResponseEntity.ok(categoryRequired);
        } else {
            throw new ResourceNotFoundException("The category with the given ID wasn't found");
        }
    }

    /* Create */
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws DuplicatedValueException {
        return null;
    }

}
