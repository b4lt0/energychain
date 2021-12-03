package com.group1.energymanager.controller;

import com.group1.energymanager.request.UserRequest;
import com.group1.energymanager.response.RegistrationResponse;
import com.group1.energymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    private ResponseEntity<RegistrationResponse> registration(@RequestBody UserRequest userRequest){
        return new ResponseEntity<RegistrationResponse>(userService.addUser(userRequest), HttpStatus.OK);
    }
}
