package com.codeup.demo.web;

import com.codeup.demo.data.category.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {



    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "Spring Boots"));
    }};


    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName) {
       return null;
    }

    @GetMapping
    private List<Category> getCategories(){
        return categories;
    }




}
