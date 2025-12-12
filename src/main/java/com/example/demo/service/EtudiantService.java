package com.example.demo.service;
import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EtudiantService {
     private final EtudiantRepository repo;

     public EtudiantService(EtudiantRepository repo) {
        this.repo = repo ;
     }

     public List<Etudiant> findAll() {
        return repo.findAll();
    }

         public Optional<Etudiant> findById(Long id) {
        return repo.findById(id);
    }

    public Etudiant save(Etudiant e) {
        return repo.save(e);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
