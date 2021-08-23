package com.codeup.demo.web;

import com.codeup.demo.data.post.Post;
import com.codeup.demo.data.user.User;
import com.codeup.demo.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserRepository userRepository;


    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> getUsers() {

        return userRepository.findAll();
    }


    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        userRepository.save(newUser);
    }


    @PutMapping("{id}")
    private void updateUser(@PathVariable long id, @RequestBody User updateUser) {
        System.out.println("Editing user with ID " + id);
        System.out.println(updateUser.getUsername());
        System.out.println(updateUser.getId());
        userRepository.save(updateUser);
    }


    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        System.out.println("The id to be deleted is: " + id);
        userRepository.deleteById(id);
    }


    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }


    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

//    @PutMapping("/{id}/updatePassword")
//    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
//        System.out.println("The old password is:  " + oldPassword);
//        System.out.println("The new password is:  " + newPassword);
//        userRepository.updatePassword(oldPassword, newPassword);
//    }
//

}
