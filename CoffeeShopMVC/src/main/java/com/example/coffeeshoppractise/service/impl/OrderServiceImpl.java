package com.example.coffeeshoppractise.service.impl;

import com.example.coffeeshoppractise.model.entity.OrdersEntity;
import com.example.coffeeshoppractise.model.service.OrderServiceModel;
import com.example.coffeeshoppractise.model.view.OrderViewModel;
import com.example.coffeeshoppractise.repository.OrderRepository;
import com.example.coffeeshoppractise.service.CategoryService;
import com.example.coffeeshoppractise.service.OrderService;
import com.example.coffeeshoppractise.service.UserService;
import com.example.coffeeshoppractise.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;


    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {

        OrdersEntity ordersEntity = modelMapper.map(orderServiceModel,OrdersEntity.class);

        ordersEntity.setEmployee(userService.findById(currentUser.getId()));
        ordersEntity.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));


        orderRepository.save(ordersEntity);
    }

    @Override
    public List<OrderViewModel> findAllOrderOrderByPriceDesc() {

        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(ordersEntity -> modelMapper.map(ordersEntity , OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
