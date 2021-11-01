package com.example.battleshipsexam.model.service;

import com.example.battleshipsexam.model.entity.Category;
import com.example.battleshipsexam.model.entity.User;
import com.example.battleshipsexam.model.entity.enums.CategoryNameEnum;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ShipServiceModel {

    private Long id;
    private LocalDate created;
    private Integer health;
    private String name;
    private Integer power;
    private User user;
    private CategoryNameEnum category;

    public ShipServiceModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
