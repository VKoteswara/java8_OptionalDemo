package com.optional.OptionalDemo.controllers;

import com.optional.OptionalDemo.entities.Phone;
import com.optional.OptionalDemo.entities.User;
import com.optional.OptionalDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUserS());
    }
    @GetMapping("/getphonenumbersbyuserid/{userId}")
    public ResponseEntity<List<Phone>> getPhonesByUserId(@RequestBody List<User> userList,@PathVariable("userId") Long userId){
        return ResponseEntity.ok(userService.getPhoneNumberByUserId(userList,userId));
    }
    @GetMapping("/getphonenumbersforeachuser")
    public ResponseEntity<Map<String,List<Phone>>> getPhoneNumbersForEachUser(@RequestBody List<User> userList){
        return ResponseEntity.ok(userService.getPhoneNumbersForEachUser(userList));
    }

}
