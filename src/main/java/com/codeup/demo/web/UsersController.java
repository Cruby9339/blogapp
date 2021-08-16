package com.codeup.demo.web;

import com.codeup.demo.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {




    @GetMapping
    private List<User> getUsers(){
        return new ArrayList<User>(){{
            add(new User(1, "Christian", "cruby9339@gmail.com","pw123", User.Role.USER));
            add(new User(2, "Marina", "mgarriola@email.com", "pw123", User.Role.USER));
        }};
    }


    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
    }


    @PutMapping("{id}")
    private void updateUser(@PathVariable long id, @RequestBody User updateUser){
        System.out.println(updateUser.getUsername());
        System.out.println(updateUser.getId());
    }


    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable long id){
        System.out.println("The id to be deleted is: " + id);
    }


//    @GetMapping("${id}")
//    private User findById(@PathVariable Long id){
//        return
//    }


}
