package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.Langue;

import java.util.List;

public class JoueurDTO {

    private String prenom;
    private String pseudo;
    private int anneeDeNaissance;
    private Langue langue;
    private List<String> centreInteret;

    public JoueurDTO(String prenom, String pseudo, int anneeDeNaissance, Langue langue, List<String> centreInteret) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.anneeDeNaissance = anneeDeNaissance;
        this.langue = langue;
        this.centreInteret = centreInteret;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getAnneeDeNaissance() {
        return anneeDeNaissance;
    }

    public Langue getLangue() {
        return langue;
    }


    public List<String> getCentreInteret() {
        return centreInteret;
    }


}
