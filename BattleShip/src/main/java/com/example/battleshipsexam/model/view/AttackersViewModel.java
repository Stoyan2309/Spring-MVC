package com.example.battleshipsexam.model.view;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class AttackersViewModel {

    private Long id;
    private String name;

    public AttackersViewModel() {
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
}
