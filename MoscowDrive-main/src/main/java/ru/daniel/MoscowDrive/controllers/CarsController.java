package ru.daniel.MoscowDrive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

    public CarsController() {}

    @GetMapping("/all")
    public String index(Model model) {
        return "allcars/index";
    }
}
