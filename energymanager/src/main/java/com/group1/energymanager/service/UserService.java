package com.group1.energymanager.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.group1.energymanager.model.User;
import com.group1.energymanager.repo.UserRepository;
import com.group1.energymanager.request.UserRequest;
import com.group1.energymanager.response.BaseResponse;
import com.group1.energymanager.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //public UserService(UserRepository userRepository) {
       // this.userRepository = userRepository;
    //}

    public RegistrationResponse addUser(UserRequest userRequest){
        RegistrationResponse resp=new RegistrationResponse();
        BaseResponse result = new BaseResponse(HttpStatus.OK, null);
        
        //inserisco a db
        User user = new User();
        String username = userRequest.getNome()+"."+userRequest.getCognome();
        user.setUsername(username);
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

        //popolo la response da riportatre al controller
        resp.setUserID(username);
        resp.setResult(result);
        return resp;
    }
}
