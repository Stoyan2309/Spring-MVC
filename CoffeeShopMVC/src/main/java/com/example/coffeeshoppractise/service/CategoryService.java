package com.example.coffeeshoppractise.service;

import com.example.coffeeshoppractise.model.entity.CategoryEntity;
import com.example.coffeeshoppractise.model.entity.enums.NameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(NameEnum categoryNameEnum);
}
