package com.example.coffeeshoppractise.model.service;

import com.example.coffeeshoppractise.model.entity.CategoryEntity;
import com.example.coffeeshoppractise.model.entity.UserEntity;
import com.example.coffeeshoppractise.model.entity.enums.NameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private NameEnum category;
    private String description;
    private UserEntity employee;

    public OrderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public NameEnum getCategory() {
        return category;
    }

    public void setCategory(NameEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public void setEmployee(UserEntity employee) {
        this.employee = employee;
    }
}
