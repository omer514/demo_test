package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "etudiants")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'etudiant est obligatoire")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    private String nom;

    @NotBlank(message = "Le prenom est obligatoire")
    @Size(max = 100, message = "Le prenom ne doit pas dépasser 100 caractères")
    private String prenom;

    @NotNull(message = "L'âge est obligatoire")
    @Min(value = 1, message = "L'âge doit être au minimum 1")
    @Max(value = 120, message = "L'âge doit être au maximum 120")
    private Integer age;

    // constructors 
    public Etudiant() {} 

    public Etudiant(String nom, String prenom , int age ) {
        this.nom = nom ;
        this.prenom = prenom ; 
        this.age = age ; 
    }

    // getters et setters
    public Long getId() {return id ;}
    public void setId(Long id) {this.id = id ;} 

    public String getNom() {return nom ;}
    public void setNom(String nom) {this.nom = nom ;} 

    public String getPrenom() {return prenom ;}
    public void setPrenom(String prenom) {this.prenom = prenom ;} 

    public Integer getAge() {return age ;}
    public void setAge(Integer age) {this.age = age ;} 






}
