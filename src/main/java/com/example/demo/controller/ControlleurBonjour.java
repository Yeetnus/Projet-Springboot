package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlleurBonjour {

    @GetMapping("/bonjour") // Route associée à "/bonjour"
    public String bonjour() {
        return "redirect:/bonjour.html"; // Redirection vers le fichier HTML statique
    }
}