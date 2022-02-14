package com.example.coffeeshoppractise.repository;

import com.example.coffeeshoppractise.model.entity.CategoryEntity;
import com.example.coffeeshoppractise.model.entity.enums.NameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity , Long> {

    Optional<CategoryEntity> findByName(NameEnum name);
}
