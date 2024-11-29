package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String mdp;

    private String role;

    // Constructeurs
    public User() {
    }

    public User(String nom,String mdp, String email) {
        this.nom = nom;
        this.mdp = mdp;
        this.role = email;
    }
}
