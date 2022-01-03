package com.group1.energymanager.controller;

import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.request.UserRequest;
import com.group1.energymanager.response.DeleteUserResponse;
import com.group1.energymanager.response.DepositOnWalletResponse;
import com.group1.energymanager.response.RegistrationResponse;
import com.group1.energymanager.response.UpdateUserResponse;
import com.group1.energymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    private ResponseEntity<RegistrationResponse> registration(@RequestParam String username, @RequestParam String password){
        return new ResponseEntity<RegistrationResponse>(userService.addUser(username, password), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    private ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UserRequest userRequest) throws UserNotFoundException {
        return new ResponseEntity<UpdateUserResponse>(userService.updateUser(userRequest), HttpStatus.OK);
    }

    @PutMapping("/deposit/{userID}/{wallet}")
    private ResponseEntity<DepositOnWalletResponse> deposit(@PathVariable String userID, @PathVariable Float wallet) throws UserNotFoundException {
        return new ResponseEntity<DepositOnWalletResponse>(userService.depositMoney(userID, wallet), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable String userID) throws UserNotFoundException {
        return new ResponseEntity<DeleteUserResponse>(userService.deleteUser(userID), HttpStatus.OK);
    }
}