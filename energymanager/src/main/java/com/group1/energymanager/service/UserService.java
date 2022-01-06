package com.group1.energymanager.service;

import com.group1.energymanager.exceptions.InsufficientFundsException;
import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.model.Packet;
import com.group1.energymanager.model.User;
import com.group1.energymanager.repo.UserRepository;
import com.group1.energymanager.request.DepositMoneyRequest;
import com.group1.energymanager.request.Operation;
import com.group1.energymanager.request.RegistrationRequest;
import com.group1.energymanager.request.UpdateRequest;
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
        //inserisco a db
        User newUser = new User();
        //L'id viene generato automaticamente, non occorre inserirlo da tastiera

        newUser.setRagSociale(registrationRequest.getRagSociale());
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword(registrationRequest.getPassword());
        newUser.setWallet(registrationRequest.getWallet());
        userRepository.save(newUser);

        //popolo la response da riportare al controller
        RegistrationResponse resp = new RegistrationResponse();
        BaseResponse result = new BaseResponse(HttpStatus.CREATED, "User " + newUser.getId() + " successfully signed up!");
        resp.setUserID(newUser.getId());
        resp.setResult(result);
        return resp;
    }

    public UpdateUserResponse updateUser(UpdateRequest updateRequest) throws UserNotFoundException { //occorre gestire l'eccezione in caso di utente non trovato o id non presente
        //Vedo se l'utente è presente nel db, in caso affermativo lo aggiorno
        User updatedUser = userRepository.findById(updateRequest.getId())
                .orElseThrow(() -> new UserNotFoundException( "User by id: " + updateRequest.getId() + " was not found!"));
        updatedUser.setRagSociale(updateRequest.getRagSociale());
        updatedUser.setUsername(updateRequest.getUsername());
        updatedUser.setPassword(updateRequest.getPassword());
        //salvo le modifiche a db
        userRepository.save(updatedUser); //tanto questo non lo sovrascrive
        //creo la response
        UpdateUserResponse resp = new UpdateUserResponse();
        BaseResponse result = new BaseResponse(HttpStatus.OK, "User: " + updatedUser.getId() + " Successfully updated!");
        resp.setId(updatedUser.getId());
        resp.setResult(result);
        return resp;
    }

    public DepositOnWalletResponse depositMoney(DepositMoneyRequest depositMoneyRequest) throws UserNotFoundException, InsufficientFundsException { //occore gestire l'eccezione in caso di utente non trovato
        //cerco se l'utente è presente a db, in caso contrario, lancio l'eccezione
        User user = userRepository.findById(depositMoneyRequest.getId())
                .orElseThrow(() -> new UserNotFoundException("User by id " + depositMoneyRequest.getId() + " was not found!"));
        Double newWallet;
        if (depositMoneyRequest.getOperation() == Operation.WITHDRAW && user.getWallet() > depositMoneyRequest.getMoney()){
            newWallet = user.getWallet() - depositMoneyRequest.getMoney();
            user.setWallet(newWallet);
        }
        else if (depositMoneyRequest.getOperation() == Operation.WITHDRAW && user.getWallet() < depositMoneyRequest.getMoney())
        {
            throw new InsufficientFundsException("There aren't enough money on wallet!");
        }
        else if (depositMoneyRequest.getOperation() == Operation.ADD){
            newWallet = user.getWallet() + depositMoneyRequest.getMoney();
            user.setWallet(newWallet);
        }
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

    public DeleteUserResponse deleteUser(String userID)  throws UserNotFoundException {
        //rimuovo a db
        //cerco se l'utente è presente a db, in caso contrario lancio eccezione
        User removedUser = userRepository.findById(userID)
                .orElseThrow(() -> new UserNotFoundException("User by id " + userID + " was not found!"));
        userRepository.delete(removedUser);
        //popolo la response da riportare al controller
        DeleteUserResponse resp = new DeleteUserResponse();
        BaseResponse result = new BaseResponse(HttpStatus.OK, "User " + removedUser.getId() + " successfully eliminated!");
        resp.setId(removedUser.getId());
        resp.setResult(result);
        return resp;
    }

}