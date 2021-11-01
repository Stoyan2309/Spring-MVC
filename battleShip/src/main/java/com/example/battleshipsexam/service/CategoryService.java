package com.example.battleshipsexam.service;

import com.example.battleshipsexam.model.entity.Category;
import com.example.battleshipsexam.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategory();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}
