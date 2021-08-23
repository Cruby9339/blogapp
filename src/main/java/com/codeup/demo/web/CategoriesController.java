package com.codeup.demo.web;

import com.codeup.demo.data.category.Category;
import com.codeup.demo.data.category.CategoryRepository;
import com.codeup.demo.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {


    private final CategoryRepository categoryRepository;


    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("{name}")
    private Category getPostsByCategory(@PathVariable String name) {
       return categoryRepository.findByName(name);
    }



    @GetMapping
    private List<Category> getCategories(){
        return categoryRepository.findAll();
    }




}
