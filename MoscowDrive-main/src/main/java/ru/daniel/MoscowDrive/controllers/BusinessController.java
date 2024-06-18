package ru.daniel.MoscowDrive.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.daniel.MoscowDrive.services.BusinessService;
import ru.daniel.MoscowDrive.models.Business;

@Controller
@RequestMapping("/business")
public class BusinessController {
    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("business", businessService.findAll());
        return "business/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("business", businessService.findOne(id));
        return "business/show";
    }

    @GetMapping("/new")
    public String newBusiness(@ModelAttribute("business") Business business) {return "business/new";}

    @PostMapping()
    public String create(@ModelAttribute("business") @Valid Business business,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "business/new";

        businessService.save(business);
        return "redirect:/business/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("business", businessService.findOne(id));
        return "business/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("business") @Valid Business business, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "business/edit";

        businessService.update(id, business);
        return "redirect:/business/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        businessService.delete(id);
        return "redirect:/business/index";
    }
}
