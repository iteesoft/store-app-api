package com.iteesoft.storeapp.controller;

import com.iteesoft.storeapp.dto.CategoryDto;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/new")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> viewAll() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

}
