package com.example.battleshipsexam.web;

import com.example.battleshipsexam.model.binding.ShipsAddBindingModel;
import com.example.battleshipsexam.model.entity.Ship;
import com.example.battleshipsexam.model.service.ShipServiceModel;
import com.example.battleshipsexam.model.view.AttackersViewModel;
import com.example.battleshipsexam.repository.ShipRepository;
import com.example.battleshipsexam.service.ShipService;
import com.example.battleshipsexam.util.CurrentUser;
import org.hibernate.annotations.Parameter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ShipRepository shipRepository;




    public ShipController(ShipService shipService, ModelMapper modelMapper, CurrentUser currentUser, ShipRepository shipRepository) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.shipRepository = shipRepository;

    }

    @GetMapping("/add")
    public String addShip(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String confirmAddShip(@Valid ShipsAddBindingModel shipsAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("shipsAddBindingModel",shipsAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipsAddBindingModel",bindingResult);

            return "redirect:add";
        }


shipService.addShip(modelMapper.map(shipsAddBindingModel , ShipServiceModel.class));


        return "redirect:/";
    }

    @PostMapping("/fire")
    public String fire( Long attackerId , Long defenderId) {

        shipService.fire(attackerId , defenderId);

        return "redirect:/";
    }

    @ModelAttribute
    public ShipsAddBindingModel shipsAddBindingModel(){
        return new ShipsAddBindingModel();
    }
}
