package com.spring.restapi.controllers.v1;

import com.spring.restapi.api.v1.model.*;
import com.spring.restapi.services.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getAllCategories() {
        return new ResponseEntity<>(new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
