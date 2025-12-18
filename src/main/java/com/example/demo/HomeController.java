package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Redirige la racine vers la liste des utilisateurs
    @GetMapping("/")
    public String home() {
        return "redirect:/utilisateurs/list";
    }
}
