package com.example.battleshipsexam.service.impl;

import com.example.battleshipsexam.model.entity.User;
import com.example.battleshipsexam.model.service.UserServiceModel;
import com.example.battleshipsexam.repository.UserRepository;
import com.example.battleshipsexam.service.UserService;
import com.example.battleshipsexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel , User.class);


        return modelMapper.map(userRepository.save(user) , UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {



        return userRepository.findByUsernameAndPassword(username , password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id) {

        currentUser.setId(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
