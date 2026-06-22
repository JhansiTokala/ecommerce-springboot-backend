package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.entity.Category;
import com.jhansi.ecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addCategory(
            @RequestBody Category category) {

        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(
            @PathVariable Long id) {

        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable Long id) {

        categoryService.deleteCategory(id);

        return "Category Deleted Successfully";
    }
}