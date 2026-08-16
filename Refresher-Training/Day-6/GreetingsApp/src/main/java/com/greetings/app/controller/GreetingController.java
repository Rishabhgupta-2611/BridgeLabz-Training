package com.greetings.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.greetings.app.model.Greeting;
import com.greetings.app.service.GreetingService;

@Controller
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllGreetings(Model model) {

        List<Greeting> greetings = service.getAllGreetings();

        model.addAttribute("greetings", greetings);

        return "greetings";
    }

    @GetMapping("/add")
    public String showAddPage(Model model) {

        model.addAttribute("greeting", new Greeting());

        return "add-greeting";
    }

    @PostMapping("/save")
    public String saveGreeting(
            @ModelAttribute Greeting greeting) {

        service.addGreeting(greeting);

        return "redirect:/greetings";
    }

    @GetMapping("/edit/{id}")
    public String editGreeting(
            @PathVariable Long id,
            Model model) {

        Greeting greeting = service.getGreetingById(id);

        model.addAttribute("greeting", greeting);

        return "edit-greeting";
    }

    @PostMapping("/update")
    public String updateGreeting(
            @ModelAttribute Greeting greeting) {

        service.updateGreeting(
                greeting.getId(),
                greeting.getMessage()
        );

        return "redirect:/greetings";
    }

    @GetMapping("/delete/{id}")
    public String deleteGreeting(
            @PathVariable Long id) {

        service.deleteGreeting(id);

        return "redirect:/greetings";
    }
}