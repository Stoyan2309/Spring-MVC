package com.example.battleshipsexam.model.view;


import com.example.battleshipsexam.model.entity.User;
import com.example.battleshipsexam.util.CurrentUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShipViewModel {

    private Long id ;
    private String name;
    private Long health;
    private Long power;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    private LocalDate created;

    public ShipViewModel() {
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

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }
}
