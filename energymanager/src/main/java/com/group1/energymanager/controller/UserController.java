package com.group1.energymanager.controller;

import com.group1.energymanager.exceptions.InsufficientFundsException;
import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.request.DepositMoneyRequest;
import com.group1.energymanager.request.UpdateRequest;
import com.group1.energymanager.response.DeleteUserResponse;
import com.group1.energymanager.response.DepositOnWalletResponse;
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

    /*

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
                user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }


    @PostMapping("/registration")
    private ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<RegistrationResponse>(userService.addUser(registrationRequest), HttpStatus.CREATED);
    }

     */

    @PutMapping("/update")
    private ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateRequest updateRequest) throws UserNotFoundException {
        return new ResponseEntity<UpdateUserResponse>(userService.updateUser(updateRequest), HttpStatus.OK);
    }

    @PutMapping("/deposit")
    private ResponseEntity<DepositOnWalletResponse> deposit(@RequestBody DepositMoneyRequest depositMoneyRequest) throws UserNotFoundException, InsufficientFundsException {//throws UserNotFoundException, InsufficientFundsException {
        return new ResponseEntity<DepositOnWalletResponse>(userService.depositMoney(depositMoneyRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable("userID") String userID) throws UserNotFoundException {
        return new ResponseEntity<DeleteUserResponse>(userService.deleteUser(userID), HttpStatus.OK);
    }



}