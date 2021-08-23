package com.codeup.demo.web;

import com.codeup.demo.data.category.Category;
import com.codeup.demo.data.post.Post;
import com.codeup.demo.data.post.PostRepository;
import com.codeup.demo.data.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    private final PostRepository postRepository;

    public PostsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    private List<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id){
        return postRepository.findById(id).get();
    }


    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postRepository.save(newPost);
    }


    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        System.out.println(updatedPost.getTitle());
        System.out.println(updatedPost.getContent());
        postRepository.save(updatedPost);
    }


    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }


}
