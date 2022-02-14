package com.example.coffeeshoppractise.Init;

import com.example.coffeeshoppractise.model.entity.CategoryEntity;
import com.example.coffeeshoppractise.model.entity.enums.NameEnum;
import com.example.coffeeshoppractise.repository.CategoryRepository;
import com.example.coffeeshoppractise.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {


    private final CategoryService categoryService;

    public DatabaseInit(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        categoryService.initCategories();


    }
}
