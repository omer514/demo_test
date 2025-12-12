package com.example.demo.model.controller;
import com.example.demo.model.Etudiant;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.EtudiantService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService service ; 

    public EtudiantController(EtudiantService service) {
        this.service = service ; 
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("etudiants", service.findAll());
        return "etudiants/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiants/form"; 

    }

     @PostMapping
    public String save(@Valid @ModelAttribute("etudiants") Etudiant etudiant,
                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "etudiants/form";
        }
        service.save(etudiant);
        return "redirect:/etudiants/list";
    }

        // Formulaire édition
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        var opt = service.findById(id);
        if (opt.isEmpty()) {
            return "redirect:/etudiants";
        }
        model.addAttribute("etudiant", opt.get());
        return "etudiants/form";
    }

    // Suppression
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/etudiants";
    }

     @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        var opt = service.findById(id);
        if (opt.isEmpty()) {
            return "redirect:/etudiants";
        }
        model.addAttribute("etudiant", opt.get());
        return "etudiants/view";
    }

    
}
