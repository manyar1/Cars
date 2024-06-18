package ru.daniel.MoscowDrive.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.daniel.MoscowDrive.models.Econom;
import ru.daniel.MoscowDrive.services.EconomService;

@Controller
@RequestMapping("/econom")
public class EconomController {
    private final EconomService economService;

    @Autowired
    public EconomController(EconomService economService) {
        this.economService = economService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("econom", economService.findAll());
        return "econom/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("econom", economService.findOne(id));
        return "econom/show";
    }

    @GetMapping("/new")
    public String newEconom(@ModelAttribute("econom") Econom econom) {return "econom/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("econom") @Valid Econom econom,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "econom/new";

        economService.save(econom);
        return "redirect:/econom/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("econom", economService.findOne(id));
        return "econom/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("econom") @Valid Econom econom, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "econom/edit";

        economService.update(id, econom);
        return "redirect:/econom/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        economService.delete(id);
        return "redirect:/econom/index";
    }

}
