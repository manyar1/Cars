package ru.daniel.MoscowDrive.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.daniel.MoscowDrive.services.ComfortPlusService;
import ru.daniel.MoscowDrive.models.ComfortPlus;

@Controller
@RequestMapping("/comfortPlus")
public class ComfortPlusController {
    private final ComfortPlusService comfortPlusService;

    @Autowired
    public ComfortPlusController(ComfortPlusService comfortPlusService) {
        this.comfortPlusService = comfortPlusService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("comfortPlus", comfortPlusService.findAll());
        return "comfortPlus/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("comfortPlus", comfortPlusService.findOne(id));
        return "comfortPlus/show";
    }

    @GetMapping("/new")
    public String newComfortPlus(@ModelAttribute("comfortPlus") ComfortPlus comfortPlus) {
        return "comfortPlus/new";}

    @PostMapping()
    public String create(@ModelAttribute("comfortPlus") @Valid ComfortPlus comfortPlus,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "comfortPlus/new";

        comfortPlusService.save(comfortPlus);
        return "redirect:/comfortPlus/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("comfortPlus", comfortPlusService.findOne(id));
        return "comfortPlus/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("comfortPlus") @Valid ComfortPlus comfortPlus,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "comfortPlus/edit";

        comfortPlusService.update(id, comfortPlus);
        return "redirect:/comfortPlus/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        comfortPlusService.delete(id);
        return "redirect:/comfortPlus/index";
    }
}
