package com.example.battleshipsexam.service;

import com.example.battleshipsexam.model.entity.Ship;
import com.example.battleshipsexam.model.service.ShipServiceModel;
import com.example.battleshipsexam.model.view.AttackersViewModel;
import com.example.battleshipsexam.model.view.ShipViewModel;
import com.example.battleshipsexam.util.CurrentUser;

import java.util.List;
import java.util.Map;

public interface ShipService {
    ShipServiceModel addShip(ShipServiceModel shipServiceModel);





    List<ShipViewModel> findAllShips();

    List<AttackersViewModel> findShipsByOwner(Long id);

    List<AttackersViewModel> findShipsOfAnotherOwners(Long id);

    void fire(Long attackerId , Long defenderId);
}
