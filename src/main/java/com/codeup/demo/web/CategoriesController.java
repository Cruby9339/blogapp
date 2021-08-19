package com.codeup.demo.web;

import com.codeup.demo.data.Category;
import com.codeup.demo.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {



    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName) {
       return null;
    }




}
