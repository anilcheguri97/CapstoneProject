package com.capstone.retailStore.Customer.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usersapi")
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/addUser")
    public ResponseEntity<UserInfo> addUser(@RequestBody  UserInfo userInfo) {
        UserInfo userInfo1 = service.addUser(userInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
