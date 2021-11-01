package com.example.battleshipsexam.repository;

import com.example.battleshipsexam.model.entity.Ship;
import com.example.battleshipsexam.model.entity.User;
import com.example.battleshipsexam.model.view.AttackersViewModel;
import com.example.battleshipsexam.model.view.ShipViewModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {


    List<Ship> findAllByOrderById();

    List<Ship> findByUserId(Long id);

    List<Ship> findByUserIdNot(Long id);



    Optional<Ship> findShipsById(Long aLong);
}
