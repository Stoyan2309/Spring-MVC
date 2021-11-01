package com.example.battleshipsexam.service.impl;

import com.example.battleshipsexam.model.entity.Category;
import com.example.battleshipsexam.model.entity.enums.CategoryNameEnum;
import com.example.battleshipsexam.repository.CategoryRepository;
import com.example.battleshipsexam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory() {


        if (categoryRepository.count() != 0) {

            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);

                    switch (categoryNameEnum) {

                        case CARGO -> category.setDescription("CARGO");
                        case BATTLE -> category.setDescription("BATTLE");
                        case PATROL -> category.setDescription("PATROL");
                    }
                    categoryRepository.save(category);

                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum category) {


        return categoryRepository.findByName(category).orElse(null);
    }
}
