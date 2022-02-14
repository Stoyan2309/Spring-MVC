package com.example.coffeeshoppractise.service;

import com.example.coffeeshoppractise.model.service.OrderServiceModel;
import com.example.coffeeshoppractise.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {


    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDesc();

    void readyOrder(Long id);
}


