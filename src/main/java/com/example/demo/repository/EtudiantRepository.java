package com.example.demo.repository;

import com.example.demo.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}

