package com.example.demo.model.controller;

import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    // Liste
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("utilisateurs", service.findAll());
        return "utilisateurs/list";
    }

    // Formulaire création
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateurs/form";
    }

    // Sauvegarde création
    @PostMapping
    public String save(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "utilisateurs/form";
        }
        service.save(utilisateur);
        return "redirect:/utilisateurs/list";
    }

    // Formulaire édition
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        var opt = service.findById(id);
        if (opt.isEmpty()) {
            return "redirect:/utilisateurs";
        }
        model.addAttribute("utilisateur", opt.get());
        return "utilisateurs/form";
    }

    // Suppression
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/utilisateurs";
    }

    // Détail
    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        var opt = service.findById(id);
        if (opt.isEmpty()) {
            return "redirect:/utilisateurs";
        }
        model.addAttribute("utilisateur", opt.get());
        return "utilisateurs/view";
    }
}
