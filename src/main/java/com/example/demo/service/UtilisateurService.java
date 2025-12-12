package com.example.demo.service;

import com.example.demo.model.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository repo;

    public UtilisateurService(UtilisateurRepository repo) {
        this.repo = repo;
    }

    public List<Utilisateur> findAll() {
        return repo.findAll();
    }

    public Optional<Utilisateur> findById(Long id) {
        return repo.findById(id);
    }

    public Utilisateur save(Utilisateur u) {
        return repo.save(u);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Optional<Utilisateur> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
