package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Setter
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date datePublication;

    private String auteur;

    private String titre;

    private String contenu;

    @OneToMany(mappedBy = "article")
    private Set<Liker> likes;

    public Article() {
    }

    public Article(Date datePublication, String auteur, String contenu, String titre) {
        this.datePublication = datePublication;
        this.auteur = auteur;
        this.contenu = contenu;
        this.titre = titre;
    }
}
