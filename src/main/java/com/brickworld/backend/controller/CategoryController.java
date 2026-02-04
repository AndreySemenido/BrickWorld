package com.brickworld.backend.controller;

import com.brickworld.backend.entity.Category;
import com.brickworld.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    // 🔹 тестовый эндпоинт
    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
