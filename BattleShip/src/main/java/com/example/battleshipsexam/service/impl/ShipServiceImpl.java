package com.example.battleshipsexam.service.impl;

import com.example.battleshipsexam.model.entity.Ship;
import com.example.battleshipsexam.model.service.ShipServiceModel;
import com.example.battleshipsexam.model.view.AttackersViewModel;
import com.example.battleshipsexam.model.view.ShipViewModel;
import com.example.battleshipsexam.repository.ShipRepository;
import com.example.battleshipsexam.service.CategoryService;
import com.example.battleshipsexam.service.ShipService;
import com.example.battleshipsexam.service.UserService;
import com.example.battleshipsexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;


    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;


    }

    @Override
    public ShipServiceModel addShip(ShipServiceModel shipServiceModel) {

        Ship ship = modelMapper.map(shipServiceModel, Ship.class);

        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));

        return modelMapper.map(shipRepository.save(ship), ShipServiceModel.class);
    }

    @Override
    public List<ShipViewModel> findAllShips() {

        return shipRepository.findAllByOrderById()
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AttackersViewModel> findShipsByOwner(Long id) {


        return shipRepository.findByUserId(id)
                .stream()
                .map(ship -> modelMapper.map(ship, AttackersViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AttackersViewModel> findShipsOfAnotherOwners(Long id) {

        return shipRepository.findByUserIdNot(id)
                .stream()
                .map(ship -> modelMapper.map(ship, AttackersViewModel.class))
                .collect(Collectors.toList());
    }



    @Override
    public void fire(Long attackerId , Long defenderId) {

        List<ShipViewModel> allShips = findAllShips();
        Map<String, List<ShipViewModel>> result = new HashMap<>();

        List<ShipViewModel> all = new ArrayList<>();
        List<ShipViewModel> attackers = new ArrayList<>();
        List<ShipViewModel> defenders = new ArrayList<>();

        result.put("all", all);
        result.put("attackers", attackers);
        result.put("defenders", defenders);

        for (ShipViewModel allShip : allShips) {
            if (allShip.getUser().getId() != currentUser.getId()) {
                result.get("defenders").add(modelMapper.map(allShip, ShipViewModel.class));
                defenderId = allShip.getId();
            } else {
                result.get("attackers").add(modelMapper.map(allShip, ShipViewModel.class));
                attackerId = allShip.getId();
            }
            result.get("all").add(modelMapper.map(allShip, ShipViewModel.class));
        }


        Ship attacker = shipRepository.findById(attackerId).orElse(null);
        Ship defender = shipRepository.findById(defenderId).orElse(null);



        Long dif = defender.getHealth() - attacker.getPower();

        defender.setHealth(dif);
        if(defender.getHealth() <= 0){
            shipRepository.deleteById(defenderId);
        }else{
            shipRepository.save(defender);
        }


    }


}
