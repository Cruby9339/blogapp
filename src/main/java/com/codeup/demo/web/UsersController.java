package com.codeup.demo.web;

import com.codeup.demo.data.Post;
import com.codeup.demo.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    List<Post> posts = new ArrayList<Post>() {{
        add(new Post(1L, "Title1", "This is a post", null));
        add(new Post(2L, "Title2", "This is a post", null));
        add(new Post(3L, "Title3", "This is a post", null));
    }};


    @GetMapping
    private List<User> getUsers() {

        return new ArrayList<User>() {{
            add(new User(1, "Christian", "cruby9339@gmail.com", "pw123", posts));
            add(new User(2, "Marina", "mgarriola@email.com", "pw123", posts));
        }};
    }


    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
    }


    @PutMapping("{id}")
    private void updateUser(@PathVariable long id, @RequestBody User updateUser) {
        System.out.println("Editing user with ID " + id);
        System.out.println(updateUser.getUsername());
        System.out.println(updateUser.getId());
    }


    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable long id) {
        System.out.println("The id to be deleted is: " + id);
    }


    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        return getUsers().stream()
                .filter(t ->
                        id.equals(t.getId())).findFirst().orElse(null);
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username) {
        return getUsers().stream()
                .filter(t ->
                        username.equals(t.getUsername())).findFirst().orElse(null);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email) {
        return getUsers().stream()
                .filter(t ->
                        email.equals(t.getEmail())).findFirst().orElse(null);
    }

    @PutMapping("/{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println("The old password is:  " + oldPassword);
        System.out.println("The new password is:  " + newPassword);
    }


}
