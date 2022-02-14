package com.example.coffeeshoppractise.service.impl;

import com.example.coffeeshoppractise.model.entity.CategoryEntity;
import com.example.coffeeshoppractise.model.entity.enums.NameEnum;
import com.example.coffeeshoppractise.repository.CategoryRepository;
import com.example.coffeeshoppractise.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(NameEnum.values())
                .forEach(nameEnum -> {
                    CategoryEntity categoryEntity = new CategoryEntity();

                    categoryEntity.setName(nameEnum);
                    switch (nameEnum){
                        case COFFEE -> categoryEntity.setNeededTime(2);
                        case DRINK -> categoryEntity.setNeededTime(1);
                        case OTHER -> categoryEntity.setNeededTime(5);
                        case CAKE -> categoryEntity.setNeededTime(10);
                    }

                    categoryRepository.save(categoryEntity);

                });
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(NameEnum categoryNameEnum) {


        return categoryRepository.findByName(categoryNameEnum)
                .orElse(null);
    }
}
