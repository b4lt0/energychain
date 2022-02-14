package com.group1.energymanager.service;

//import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.model.User;
import com.group1.energymanager.repo.UserRepository;
import com.group1.energymanager.request.DepositRequest;
import com.group1.energymanager.request.RegistrationRequest;
import com.group1.energymanager.request.UserRequest;
import com.group1.energymanager.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //public UserService(UserRepository userRepository) {
    // this.userRepository = userRepository;
    //}

    public RegistrationResponse addUser(RegistrationRequest registrationRequest) {

        User newUser = new User();
        //L'id viene generato automaticamente, non occorre inserirlo da tastiera
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword(registrationRequest.getPassword());
        newUser.setRagSociale(registrationRequest.getRagSociale());
        newUser.setWallet(registrationRequest.getWallet());
        userRepository.save(newUser);

        //popolo la response da riportare al controller
        RegistrationResponse resp = new RegistrationResponse();
        BaseResponse result = new BaseResponse(HttpStatus.CREATED, "User " + newUser.getId() + " successfully signed up!");
        resp.setUserID(newUser.getId());
        resp.setResult(result);
        return resp;
    }

    public UpdateUserResponse updateUser(UserRequest userRequest) {//throws UserNotFoundException { //occorre gestire l'eccezione in caso di utente non trovato o id non presente
        //Vedo se l'utente è presente nel db, in caso affermativo lo aggiorno
        User updatedUser = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new RuntimeException("User by id: " + userRequest.getId() + " was not found!"));
        updatedUser.setRagSociale(userRequest.getRagSociale());
        updatedUser.setUsername(userRequest.getUsername());
        //updatedUser.setPassword(userRequest.getPassword()); DA GESTIRE
        //salvo le modifiche a db
        userRepository.save(updatedUser);
        //creo la response
        UpdateUserResponse resp = new UpdateUserResponse();
        BaseResponse result = new BaseResponse(HttpStatus.OK, "User: " + updatedUser.getId() + " Successfully updated!");
        resp.setId(updatedUser.getId());
        resp.setResult(result); //CAMBIARE CON IL DTO DI USER
        return resp;
    }

    public DepositOnWalletResponse depositMoney(DepositRequest depositRequest) {//throws UserNotFoundException { //occore gestire l'eccezione in caso di utente non trovato
        //cerco se l'utente è presente a db, in caso contrario, lancio l'eccezione
        User user = userRepository.findById(depositRequest.getId())
                .orElseThrow(() -> new RuntimeException("User by id " + depositRequest.getId() + " was not found!"));
        user.setWallet(depositRequest.getWallet()); //modifichi il valore di wallet nel db
        //salvo le modifiche a db
        userRepository.save(user);
        //popolo la response
        DepositOnWalletResponse resp = new DepositOnWalletResponse();
        BaseResponse result = new BaseResponse(HttpStatus.OK, "User" + user.getId() + " has " + user.getWallet() + " $ on personal portfolio");
        resp.setId(user.getId());
        resp.setWallet(user.getWallet());
        resp.setResult(result);
        return resp;
    }

    public DeleteUserResponse deleteUser(String userID) {//throws UserNotFoundException {
        //rimuovo a db
        User user = new User(userID);
        //cerco se l'utente è presente a db, in caso contrario lancio eccezione
        User removedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User by id " + userID + " was not found!"));//
        userRepository.delete(removedUser);
        //popolo la response da riportare al controller
        DeleteUserResponse resp = new DeleteUserResponse();
        BaseResponse result = new BaseResponse(HttpStatus.OK, "User " + removedUser.getId() + " successfully eliminated!");
        resp.setId(removedUser.getId());
        resp.setResult(result);
        return resp;
    }
}
