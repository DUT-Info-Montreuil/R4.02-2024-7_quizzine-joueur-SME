package org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.entites.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr7.quizzine.utiles.Langue;

import java.util.List;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueurDTO = (JoueurDTO) o;
        return anneeDeNaissance == joueurDTO.anneeDeNaissance && Objects.equals(prenom, joueurDTO.prenom) && Objects.equals(pseudo, joueurDTO.pseudo) && langue == joueurDTO.langue && Objects.equals(centreInteret, joueurDTO.centreInteret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, pseudo, anneeDeNaissance, langue, centreInteret);
    }
}
