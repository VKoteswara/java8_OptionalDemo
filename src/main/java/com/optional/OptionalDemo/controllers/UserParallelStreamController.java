package com.optional.OptionalDemo.controllers;

import com.optional.OptionalDemo.entities.Phone;
import com.optional.OptionalDemo.entities.User;
import com.optional.OptionalDemo.services.UserParallelStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserParallelStreamController {
    @Autowired
    private UserParallelStreamService userParallelStreamService;

    @GetMapping("/getphonenumberbyuserid/{userId}")
    public ResponseEntity<List<Phone>> getPhonesByUserId(@RequestBody List<User> userList, @PathVariable("userId") Long userId){
        return ResponseEntity.ok(userParallelStreamService.getPhoneNumberByUserId(userList,userId));
    }
    @GetMapping("/getphonenumberforeachuser")
    public ResponseEntity<Map<String,List<Phone>>> getPhoneNumbersForEachUser(@RequestBody List<User> userList){

        return ResponseEntity.ok(userParallelStreamService.getPhoneNumbersForEachUser(userList));

    }
}
