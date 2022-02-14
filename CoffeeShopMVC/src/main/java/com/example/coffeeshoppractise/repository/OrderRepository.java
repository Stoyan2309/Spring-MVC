package com.example.coffeeshoppractise.repository;

import com.example.coffeeshoppractise.model.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrdersEntity , Long> {

    List<OrdersEntity> findAllByOrderByPriceDesc();
}
