package com.example.battleshipsexam.web;

import com.example.battleshipsexam.model.view.AttackersViewModel;
import com.example.battleshipsexam.model.view.ShipViewModel;
import com.example.battleshipsexam.service.ShipService;
import com.example.battleshipsexam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;


    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {


            return "index";

        }

        List<ShipViewModel> ships = shipService.findAllShips();


        List<AttackersViewModel> attackers = shipService.findShipsByOwner(currentUser.getId());
        List<AttackersViewModel> defenders = shipService.findShipsOfAnotherOwners(currentUser.getId());

        model.addAttribute("ships", ships);
        model.addAttribute("attackers", attackers);
        model.addAttribute("defenders", defenders);

        return "home";


    }



}