package ru.daniel.MoscowDrive.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.daniel.MoscowDrive.models.Comfort;
import ru.daniel.MoscowDrive.services.ComfortService;

@Controller
@RequestMapping("/comfort")
public class ComfortController {
    private final ComfortService comfortService;

    @Autowired
    public ComfortController(ComfortService comfortService) {
        this.comfortService = comfortService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("comfort", comfortService.findAll());
        return "comfort/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("comfort", comfortService.findOne(id));
        return "comfort/show";
    }

    @GetMapping("/new")
    public String newComfort(@ModelAttribute("comfort") Comfort comfort) {return "comfort/new";}

    @PostMapping()
    public String create(@ModelAttribute("comfort") @Valid Comfort comfort,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "comfort/new";

        comfortService.save(comfort);
        return "redirect:/comfort/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("comfort", comfortService.findOne(id));
        return "comfort/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("comfort") @Valid Comfort comfort, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "comfort/edit";

        comfortService.update(id, comfort);
        return "redirect:/comfort/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        comfortService.delete(id);
        return "redirect:/comfort/index";
    }
}
