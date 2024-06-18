package ru.daniel.MoscowDrive.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.daniel.MoscowDrive.models.Luxury;
import ru.daniel.MoscowDrive.services.LuxuryService;

@Controller
@RequestMapping("/luxury")
public class LuxuryController {
    private final LuxuryService luxuryService;

    @Autowired
    public LuxuryController(LuxuryService luxuryService) {
        this.luxuryService = luxuryService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("luxury", luxuryService.findAll());
        return "luxury/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("luxury", luxuryService.findOne(id));
        return "luxury/show";
    }

    @GetMapping("/new")
    public String newLuxury(@ModelAttribute("luxury") Luxury luxury) {return "luxury/new";}

    @PostMapping()
    public String create(@ModelAttribute("luxury") @Valid Luxury luxury,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "luxury/new";

        luxuryService.save(luxury);
        return "redirect:/luxury/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("luxury", luxuryService.findOne(id));
        return "luxury/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("luxury") @Valid Luxury luxury, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "luxury/edit";

        luxuryService.update(id, luxury);
        return "redirect:/luxury/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        luxuryService.delete(id);
        return "redirect:/luxury/index";
    }
}
