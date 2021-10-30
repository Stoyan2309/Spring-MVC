package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.UserEntity;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.securityUtil.CurrentUser;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        UserEntity userEntity =  modelMapper.map(userServiceModel , UserEntity.class);

        return modelMapper.map(userRepository.save(userEntity) , UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username , password)
                .map(userEntity -> modelMapper.map(userEntity , UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserEntity findById(Long id) {

        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc() {


        return userRepository.findAllByOrdersCountDesc()
                .stream()
                .map(userEntity -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(userEntity.getUsername());
                    userViewModel.setCountOfOrders(userEntity.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
