package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.Category;
import com.example.coffeeshop.model.enums.CategoryEnumName;
import com.example.coffeeshop.repository.CategoryRepository;
import com.example.coffeeshop.service.CategoryService;
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

        Arrays.stream(CategoryEnumName.values())
                .forEach(categoryEnumName -> {
                    Category category = new Category();
                    category.setName(categoryEnumName);

                    switch (categoryEnumName) {
                        case CAKE -> category.setNeededTime(10);
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                    }

                    categoryRepository.save(category);
                });

    }

    @Override
    public Category findByCategoryNameEnum(CategoryEnumName categoryEnumName) {

        return categoryRepository.findByName(categoryEnumName)
                .orElse(null);
    }
}
