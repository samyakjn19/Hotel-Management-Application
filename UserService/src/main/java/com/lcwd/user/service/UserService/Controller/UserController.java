package com.lcwd.user.service.UserService.Controller;


import com.lcwd.user.service.UserService.Entities.Rating;
import com.lcwd.user.service.UserService.Entities.User;
import com.lcwd.user.service.UserService.Service.UserService;
import com.sun.net.httpserver.Authenticator;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")



public class UserController {




    @Autowired
    private UserService userService;

@PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);


    }

        @GetMapping("/{userId}")
    public ResponseEntity<User> GetSingleUser(@PathVariable String userId){
            User user = userService.getUser(userId);

            return ResponseEntity.ok(user);



    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
    List<User> Alluser = userService.getAllUser();
    return ResponseEntity.ok(Alluser);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    public  ResponseEntity<String> DeleteUser(@PathVariable String userId){
    userService.deleteUser(userId);
    return ResponseEntity.ok(userId);

    }

//    @RequestMapping(method = RequestMethod.PUT)
//    public  ResponseEntity<User> Updateuser(User user){
//        userService.UpadateUser(user);
//        return ResponseEntity.ok(user);
//
//    }






}
