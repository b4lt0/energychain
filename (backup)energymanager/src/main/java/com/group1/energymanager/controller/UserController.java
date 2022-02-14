package com.group1.energymanager.controller;

//import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.request.DepositRequest;
import com.group1.energymanager.request.RegistrationRequest;
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

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/registration")
    private ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<RegistrationResponse>(userService.addUser(registrationRequest), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    private ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UserRequest userRequest) {//throws UserNotFoundException {
        return new ResponseEntity<UpdateUserResponse>(userService.updateUser(userRequest), HttpStatus.OK);
    }
    @PutMapping("/deposit")
    private ResponseEntity<DepositOnWalletResponse> deposit(@RequestBody DepositRequest depositRequest) {//throws UserNotFoundException {
        return new ResponseEntity<DepositOnWalletResponse>(userService.depositMoney(depositRequest), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable String userID) {//throws UserNotFoundException {
        return new ResponseEntity<DeleteUserResponse>(userService.deleteUser(userID), HttpStatus.OK);
    }
}