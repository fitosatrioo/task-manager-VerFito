package com.task.manager.controller;

import com.task.manager.model.Category;
import com.task.manager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
