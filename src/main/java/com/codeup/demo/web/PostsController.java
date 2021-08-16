package com.codeup.demo.web;

import com.codeup.demo.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    @GetMapping
    private List<Post> getPosts() {
        return new ArrayList<Post>() {{
            add(new Post(1L, "Title1", "This is a post"));
            add(new Post(2L, "Title2", "This is a post"));
            add(new Post(3L, "Title3", "This is a post"));
        }};
    }


    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }


    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        System.out.println(updatedPost.getTitle());
        System.out.println(updatedPost.getContent());
    }


    @DeleteMapping("{id}")
    private void deletePost(@PathVariable long id) {
        System.out.println("The id that was deleted was: " + id);
    }


}
