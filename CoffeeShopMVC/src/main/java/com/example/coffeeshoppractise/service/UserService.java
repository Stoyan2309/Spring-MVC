package com.example.coffeeshoppractise.service;

import com.example.coffeeshoppractise.model.entity.UserEntity;
import com.example.coffeeshoppractise.model.service.UserServiceModel;
import com.example.coffeeshoppractise.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrderByCountDesc();
}
