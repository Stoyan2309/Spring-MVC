package com.example.battleshipsexam.service;

import com.example.battleshipsexam.model.entity.User;
import com.example.battleshipsexam.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id);


    User findById(Long id);
}
